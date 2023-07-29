package StageTalan.SpringBootApp.MockAPI.model;

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

    @Column(name = "endpoint")
    private String endpoint;

    @Column(name = "method")
    private String method;

    @Column(name = "response_code")
    private Long response_code;

    @Column(name = "response_status")
    private String response_status;
}
