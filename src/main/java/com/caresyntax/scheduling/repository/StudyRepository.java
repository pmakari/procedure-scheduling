package com.caresyntax.scheduling.repository;

import com.caresyntax.scheduling.domain.entity.StudyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Parviz on 10.05.2018.
 */
public interface StudyRepository extends JpaRepository<StudyEntity,Long> {
}
