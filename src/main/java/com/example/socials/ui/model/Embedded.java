package com.example.socials.ui.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Embedded {

    @JsonProperty("_embedded")
    private ExecutorSchedulers embedded;

}
