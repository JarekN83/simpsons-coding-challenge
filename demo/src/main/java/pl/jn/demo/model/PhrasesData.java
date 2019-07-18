package pl.jn.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhrasesData {
    @JsonProperty("_id")
    private String id;
    private String character;
    private String phrase;
}
