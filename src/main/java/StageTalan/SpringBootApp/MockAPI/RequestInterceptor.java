package StageTalan.SpringBootApp.MockAPI;

import StageTalan.SpringBootApp.MockAPI.model.Api;
import StageTalan.SpringBootApp.MockAPI.repository.ApiRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Autowired
    private ApiRepository apiRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI();
        String[] pathSegments = path.split("/");

        if (pathSegments.length >= 2) {
            String endpoint = "/" + pathSegments[1];
            String method = request.getMethod().toUpperCase();

            List<Api> matchingRequests = apiRepository.findByEndpointAndMethod(endpoint, method);

            if (!matchingRequests.isEmpty()) {
                // Redirect the request to the MockAPIController
                request.getRequestDispatcher("/" + endpoint).forward(request, response);
                return false;
            }
        }

        return true;
    }
}
