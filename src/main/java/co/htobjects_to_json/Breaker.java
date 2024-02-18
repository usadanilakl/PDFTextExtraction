package co.htobjects_to_json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Breaker {
    private String brNumber;
    private List<Circuit> circuits;
}
