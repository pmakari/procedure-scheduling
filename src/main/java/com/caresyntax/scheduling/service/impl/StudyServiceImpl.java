package com.caresyntax.scheduling.service.impl;

import com.caresyntax.scheduling.domain.dto.request.StudyRequestDTO;
import com.caresyntax.scheduling.domain.dto.response.StudyResponseDTO;
import com.caresyntax.scheduling.domain.entity.DoctorEntity;
import com.caresyntax.scheduling.domain.entity.PatientEntity;
import com.caresyntax.scheduling.domain.entity.RoomEntity;
import com.caresyntax.scheduling.domain.entity.StudyEntity;
import com.caresyntax.scheduling.exception.BusinessException;
import com.caresyntax.scheduling.repository.DoctorRepository;
import com.caresyntax.scheduling.repository.PatientRepository;
import com.caresyntax.scheduling.repository.RoomRepository;
import com.caresyntax.scheduling.repository.StudyRepository;
import com.caresyntax.scheduling.service.api.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Parviz on 10.05.2018.
 */
@Service
public class StudyServiceImpl implements StudyService {

    @Autowired
    StudyRepository studyRepository;

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    @Transactional
    public void save(StudyRequestDTO requestDTO) {
        try {
            StudyEntity studyEntity = StudyEntity.builder().description(requestDTO.getDescription()).status(requestDTO.getStatus()).startTime(requestDTO.getStartTime())
                    .endTime(requestDTO.getEndTime()).build();
            RoomEntity roomEntity = roomRepository.findOne(requestDTO.getRooms());
            PatientEntity patientEntity = patientRepository.findOne(requestDTO.getPatientId());
            DoctorEntity doctorEntity = doctorRepository.findOne(requestDTO.getDoctors());
            studyEntity.setDoctorEntity(doctorEntity);
            studyEntity.setPatientEntity(patientEntity);
            studyEntity.setRoomEntity(roomEntity);
            if (requestDTO.getId() != null && requestDTO.getId() != 0) {
                studyEntity.setId(requestDTO.getId());
            }
            studyRepository.save(studyEntity);
        } catch (DataAccessException ex) {
            throw new BusinessException(ex.getMessage(), ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public StudyResponseDTO findById(Long id) {
        StudyEntity entity = studyRepository.findOne(id);
        StudyResponseDTO responseDTO = StudyResponseDTO.builder().id(entity.getId()).build();
        return responseDTO;
    }
}
