package com.caresyntax.scheduling.service.impl;

import com.caresyntax.scheduling.domain.dto.request.ChangeStatusDTO;
import com.caresyntax.scheduling.domain.dto.request.PageRequestDTO;
import com.caresyntax.scheduling.domain.dto.request.StudyRequestDTO;
import com.caresyntax.scheduling.domain.dto.response.StudyResponseDTO;
import com.caresyntax.scheduling.domain.entity.DoctorEntity;
import com.caresyntax.scheduling.domain.entity.PatientEntity;
import com.caresyntax.scheduling.domain.entity.RoomEntity;
import com.caresyntax.scheduling.domain.entity.StudyEntity;
import com.caresyntax.scheduling.exception.BusinessException;
import com.caresyntax.scheduling.exception.specific.NoSuchStudyException;
import com.caresyntax.scheduling.repository.DoctorRepository;
import com.caresyntax.scheduling.repository.PatientRepository;
import com.caresyntax.scheduling.repository.RoomRepository;
import com.caresyntax.scheduling.repository.StudyRepository;
import com.caresyntax.scheduling.service.api.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        if (id == null || id < 1) {
            throw new NoSuchStudyException("Study not found!");
        }
        try {
            StudyEntity entity = studyRepository.findOne(id);
            if (entity == null) {
                throw new NoSuchStudyException("Study not found!");
            }
            StudyResponseDTO responseDTO = StudyResponseDTO.builder().id(entity.getId()).build();
            return responseDTO;
        } catch (DataAccessException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public void changeStatus(ChangeStatusDTO reqDTO) {
        if (reqDTO.getId() == null || reqDTO.getId() < 1) {
            throw new NoSuchStudyException("Study not found!");
        }
        try {
            StudyEntity studyEntity = studyRepository.findOne(reqDTO.getId());
            if (studyEntity == null) {
                throw new NoSuchStudyException("Study not found!");
            }
            studyEntity.setStatus(reqDTO.getStatus());
            studyRepository.save(studyEntity);
        } catch (DataAccessException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public Page<StudyEntity> findAll(PageRequestDTO requestDTO) {
        try {
            Page<StudyEntity> page = studyRepository.findAll(new PageRequest(requestDTO.getPage(), requestDTO.getSize()));
            return page;
        } catch (DataAccessException ex) {
            throw new BusinessException(ex.getMessage(), ex.getCause());
        }

    }
}
