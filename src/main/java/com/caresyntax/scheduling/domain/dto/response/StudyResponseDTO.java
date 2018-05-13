package com.caresyntax.scheduling.domain.dto.response;

import com.caresyntax.scheduling.domain.dto.BaseResponseDTO;
import com.caresyntax.scheduling.domain.entity.DoctorEntity;
import com.caresyntax.scheduling.domain.entity.RoomEntity;
import com.caresyntax.scheduling.domain.enums.Status;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Parviz on 12.05.2018.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyResponseDTO extends BaseResponseDTO{
    private Long id;
    private String description;
    private Status status;
    private Date startTime;
    private Date endTime;
    private Long patientId;
    private List<DoctorEntity> doctors;
    private List<RoomEntity> rooms;
    private String patientName;
    private String roomName;
    private String doctorName;
}
