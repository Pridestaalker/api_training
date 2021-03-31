package fr.esiea.ex4A;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {

public final String userCountry;

public UserInfo(@JsonProperty("userCountry") String userCountry) {
    this.userCountry = userCountry;
}
}
