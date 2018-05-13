package com.caresyntax.scheduling.repository;

import com.caresyntax.scheduling.domain.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Parviz on 12.05.2018.
 */
@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity,Long>{
}
