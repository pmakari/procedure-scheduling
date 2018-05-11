package com.caresyntax.scheduling.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Parviz on 10.05.2018.
 * All the request DTOs should extend this baseDTO
 */
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseResponseDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean success;

}
