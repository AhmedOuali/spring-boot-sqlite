package StageTalan.SpringBootApp.MockAPI.controller;

import StageTalan.SpringBootApp.MockAPI.model.Api;
import StageTalan.SpringBootApp.MockAPI.repository.ApiRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mockapii")
public class MockAPIController {

    @Autowired
    private ApiRepository apiRepository;

    @RequestMapping(value = "/**", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<Object> handleRequest(HttpServletRequest request, @RequestBody(required = false) String requestBody) {
        String method = request.getMethod().toUpperCase();
        String endpoint = request.getRequestURI().split("/mockapii")[1];


        Api matchingRequest = apiRepository.findByEndpointAndMethod(endpoint, method);


        //if (matchingRequests.isEmpty()) {
            //return ResponseEntity.notFound().build();


        //Api api = matchingRequests.get(0);
        //String responseData = api.getResponse_status();
        //Integer responseCode = api.getResponse_code();

        return new ResponseEntity<Object>(matchingRequest.getResponse_data(), HttpStatus.ACCEPTED);
    }
}
