package StageTalan.SpringBootApp.MockAPI.controller;

import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericController {

    @RequestMapping("/mock/**")
    public ResponseEntity<Object> index(HttpServletRequest request, HttpServletResponse response){
        return new ResponseEntity<Object>("Hello world", HttpStatus.ACCEPTED);
    }

}




