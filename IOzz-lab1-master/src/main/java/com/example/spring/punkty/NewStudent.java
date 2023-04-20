package com.example.spring.punkty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewStudent {
    private final String name;
    private final String number;
    private final String group;
    @JsonCreator
    public NewStudent(@JsonProperty("name") String name, @JsonProperty ("number")String number, @JsonProperty ("group")String group) {
        this.name = name;
        this.number = number;
        this.group = group;
    }
    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getGroup() {
        return group;
    }
}
