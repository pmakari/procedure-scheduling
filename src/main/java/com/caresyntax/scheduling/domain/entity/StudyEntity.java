package com.caresyntax.scheduling.domain.entity;

import com.caresyntax.scheduling.domain.BaseEntity;
import com.caresyntax.scheduling.domain.enums.Status;
import java.util.Date;
import javax.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Parviz on 10.05.2018.
 */
@Entity
@Table(name = "studies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudyEntity extends BaseEntity {

    @NotBlank
    @Column(nullable = false, length = 512)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private Status status = Status.PLANNED;

    @Column(name = "start_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @ManyToOne //unidirectional mapping
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patientEntity;

    @ManyToOne //unidirectional mapping
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity roomEntity;

    @ManyToOne //unidirectional mapping
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorEntity doctorEntity;

}
