package it.nikatti.waaagh.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Characteristics {

    private String $text;
    private String name;


}
