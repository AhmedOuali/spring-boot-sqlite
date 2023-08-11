package StageTalan.SpringBootApp.MockAPI.controller;

import java.lang.String;
import StageTalan.SpringBootApp.MockAPI.exception.ResourceNotFoundException;
import StageTalan.SpringBootApp.MockAPI.model.Api;
import StageTalan.SpringBootApp.MockAPI.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mockapi/v1/apis")
public class ApiController {


    @Autowired
    private ApiRepository apiRepository;

    @GetMapping
    public List<Api> getAllApis(){
        return apiRepository.findAll();
    }

    @PostMapping
    public Api createApi(@RequestBody Api api){
        return apiRepository.save(api);
    }

    @GetMapping("{id}")
    public ResponseEntity<Api> getApiById(@PathVariable  Long id){
        Api api = apiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Api not exist with id: " + id));
        return ResponseEntity.ok(api);
    }

    @PutMapping("{id}")
    public ResponseEntity<Api> updateApi(@PathVariable Long id,@RequestBody Api apiDetails) {
        Api updateApi = apiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Api not exist with id: " + id));

        updateApi.setEndpoint(apiDetails.getEndpoint());
        updateApi.setMethod(apiDetails.getMethod());
        updateApi.setResponse_code(apiDetails.getResponse_code());
        updateApi.setResponse_status(apiDetails.getResponse_status());

        apiRepository.save(updateApi);

        return ResponseEntity.ok(updateApi);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteApi(@PathVariable Long id){

        Api api = apiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Api not exist with id: " + id));

        apiRepository.delete(api);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}

