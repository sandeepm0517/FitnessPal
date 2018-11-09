package com.example.sandeepmungara.myfitnesspal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Byline implements Serializable {
    @SerializedName("original")
    @Expose
    public String original;

    @SerializedName("person")
    @Expose
    public List<Person> person;

    @SerializedName("organization")
    @Expose
    public String organization;
}
