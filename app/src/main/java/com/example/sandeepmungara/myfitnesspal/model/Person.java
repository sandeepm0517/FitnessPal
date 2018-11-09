package com.example.sandeepmungara.myfitnesspal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person implements Serializable {
    @SerializedName("firstname")
    @Expose
    public String firstName;

    @SerializedName("middlename")
    @Expose
    public String middleName;

    @SerializedName("lastname")
    @Expose
    public String lastName;

    @SerializedName("qualifier")
    @Expose
    public String qualifier;

    @SerializedName("title")
    @Expose
    public String PesonTitle;

    @SerializedName("role")
    @Expose
    public String role;

    @SerializedName("organization")
    @Expose
    public String organization;

    @SerializedName("rank")
    @Expose
    public String rank;
}
