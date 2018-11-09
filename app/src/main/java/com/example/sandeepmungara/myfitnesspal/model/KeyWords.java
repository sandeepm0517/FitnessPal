package com.example.sandeepmungara.myfitnesspal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeyWords {
    @SerializedName("name")
    @Expose
    public String keyWordsName;

    @SerializedName("value")
    @Expose
    public String keyWordsValue;

    @SerializedName("rank")
    @Expose
    public int rank;

    @SerializedName("major")
    @Expose
    public String majorValue;
}
