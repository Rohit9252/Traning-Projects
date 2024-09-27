package com.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry {

    @JsonProperty("API")
    private String api;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Auth")
    private String auth;

    @JsonProperty("Https")
    private String https;

    @JsonProperty("cors")
    private String cors;

    @JsonProperty("Category")
    private String category;


}
