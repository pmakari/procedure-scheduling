package com.caresyntax.scheduling.domain.dto.request;

import com.caresyntax.scheduling.domain.dto.BaseRequestDTO;
import com.caresyntax.scheduling.domain.entity.DoctorEntity;
import com.caresyntax.scheduling.domain.entity.RoomEntity;
import com.caresyntax.scheduling.domain.enums.Status;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Parviz on 12.05.2018.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyRequestDTO extends BaseRequestDTO{
    private Long id;
    private String description;
    @NotNull
    private Status status;
    @NotNull
    private Date startTime;
    private Date endTime;
    private Long patientId;
    private Long patientName;
    private Long doctors;
    private Long rooms;
}
