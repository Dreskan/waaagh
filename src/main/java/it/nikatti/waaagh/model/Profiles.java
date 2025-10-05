package it.nikatti.waaagh.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Profiles {

    private String name;
    private String typeName;
    private Characteristics[] characteristics;

}
