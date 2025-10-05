package it.nikatti.waaagh.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Roster {

    //private Costs[] costs;
    //private CostLimits[] costLimits;
    private Forces[] forces;
    private String name;
    private String id;

}

