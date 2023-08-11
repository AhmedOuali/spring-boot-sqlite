package StageTalan.SpringBootApp.MockAPI.controller;

import StageTalan.SpringBootApp.MockAPI.model.Api;
import StageTalan.SpringBootApp.MockAPI.repository.ApiRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MockAPIController {

    @Autowired
    private ApiRepository apiRepository;

    @RequestMapping(value = "/{endpoint}/**", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<String> handleRequest(@PathVariable String endpoint, HttpServletRequest request, @RequestBody(required = false) String requestBody) {
        String method = request.getMethod().toUpperCase();

        List<Api> matchingRequests = apiRepository.findByEndpointAndMethod(endpoint, method);

        if (matchingRequests.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Api api = matchingRequests.get(0);
        String responseData = api.getResponse_status();
        Integer responseCode = api.getResponse_code();

        return ResponseEntity.status(responseCode).body(responseData);
    }
}
