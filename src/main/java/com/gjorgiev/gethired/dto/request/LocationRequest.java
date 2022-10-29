package com.gjorgiev.gethired.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LocationRequest {
    @NotNull(message = "City cannot be null")
    private String city;
    @NotNull(message = "Country cannot be null")
    private String country;
}
