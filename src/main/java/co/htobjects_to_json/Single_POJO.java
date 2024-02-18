package co.htobjects_to_json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Single_POJO {
    private String panel,breaker,htt,line;


}
