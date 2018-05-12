package com.caresyntax.scheduling.repository;

import com.caresyntax.scheduling.domain.entity.StudyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by Parviz on 10.05.2018.
 */
@Repository
public interface StudyRepository extends JpaRepository<StudyEntity,Long> {
}
