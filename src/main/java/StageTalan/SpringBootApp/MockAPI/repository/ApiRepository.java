package StageTalan.SpringBootApp.MockAPI.repository;

import StageTalan.SpringBootApp.MockAPI.model.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ApiRepository extends JpaRepository<Api, Long> {
    //@Query("SELECT a FROM Api a WHERE a.endpoint =:endpoint AND a.method =:method")

    Api findByEndpointAndMethod(String endpoint, String method);
}
