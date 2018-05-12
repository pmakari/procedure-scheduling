package com.caresyntax.scheduling.domain.entity;

import com.caresyntax.scheduling.domain.BaseEntity;
import com.caresyntax.scheduling.domain.enums.Sex;
import java.util.Date;
import javax.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Parviz on 10.05.2018.
 */
@Entity
@Table(name = "patients")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientEntity extends BaseEntity {

    @NotBlank
    @Column(nullable = false, length = 128)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 16)
    private Sex sex;

    @Column(name = "birth_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    public PatientEntity(Long id) {
        this.setId(id);
    }
}
