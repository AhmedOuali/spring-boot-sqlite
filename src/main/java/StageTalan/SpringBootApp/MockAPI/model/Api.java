package StageTalan.SpringBootApp.MockAPI.model;

import StageTalan.SpringBootApp.MockAPI.helpers.JpaJsonConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "apis")
public class Api {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "endpoint", unique = true)
    private String endpoint;

    @Column(name = "method")
    private String method;

    @Column(name = "response_code")
    private Integer response_code;

    @Column(name = "response_status")
    private String response_status;

    //@Type(type = "")
    @Convert(converter = JpaJsonConverter.class)
    @Column(name = "response_data")
    private Object response_data;

    public Integer getResponse_code() {
        return response_code;
    }

    public void setResponse_code(Integer response_code) {
        this.response_code = response_code;
    }

    public String getResponse_status() {
        return response_status;
    }

    public void setResponse_status(String response_status) {
        this.response_status = response_status;
    }
}
