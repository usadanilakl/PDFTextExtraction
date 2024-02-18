package co.htobjects_to_json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Panel {
    private String panelNumber;
    private List<Breaker> breakers;
    private String location;
}
