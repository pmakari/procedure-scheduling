package com.caresyntax.scheduling.domain.dto.response;

import com.caresyntax.scheduling.domain.dto.BaseResponseDTO;
import com.caresyntax.scheduling.domain.enums.Sex;
import lombok.*;

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
public class PatientResponseDTO extends BaseResponseDTO {
    private Long id;
    private String name;
    private Sex sex;
    private Date birthDate;
}
