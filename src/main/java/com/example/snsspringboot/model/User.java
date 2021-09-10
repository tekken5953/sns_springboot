package com.example.snsspringboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class User {

    private final UUID id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String phone;
    @NotBlank
    private final String pwd;
    @NotBlank
    private final String repeat_pwd;
    @NotBlank
    private final String profile;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPwd() {
        return pwd;
    }

    public String getRepeat_pwd() {
        return repeat_pwd;
    }

    public String getProfile() {
        return profile;
    }

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("name") @NotBlank String name,
                @JsonProperty("phone") @NotBlank String phone,
                @JsonProperty("pwd") @NotBlank String pwd,
                @JsonProperty("repeat_pwd") @NotBlank String repeat_pwd,
                @JsonProperty("profile") @NotBlank String profile){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.pwd = pwd;
        this.repeat_pwd = repeat_pwd;
        this.profile = profile;
    }
}
