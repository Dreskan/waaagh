package it.nikatti.waaagh.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Selections {

    private Rules[] rulse;
    private Selections[] selections;
    private Categories[] categories;
    private Profiles[] profiles;
}
