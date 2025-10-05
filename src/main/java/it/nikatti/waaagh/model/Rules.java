package it.nikatti.waaagh.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Rules {

    private String name;
    private String description;

}
