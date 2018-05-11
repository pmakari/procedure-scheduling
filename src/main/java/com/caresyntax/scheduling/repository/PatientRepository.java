package com.caresyntax.scheduling.repository;

import com.caresyntax.scheduling.domain.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Parviz on 10.05.2018.
 */
@Repository
public interface PatientRepository extends JpaRepository<PatientEntity,Long>{
    public PatientEntity findByName(String name);
}
