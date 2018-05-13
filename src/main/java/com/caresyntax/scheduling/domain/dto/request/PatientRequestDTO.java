package com.caresyntax.scheduling.domain.dto.request;

import com.caresyntax.scheduling.domain.dto.BaseRequestDTO;
import com.caresyntax.scheduling.domain.enums.Sex;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Parviz on 10.05.2018.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PatientRequestDTO extends BaseRequestDTO{

    @NotBlank
    private String name;
    private Long id;
    private Sex sex;
    private Date birthDate;

}
