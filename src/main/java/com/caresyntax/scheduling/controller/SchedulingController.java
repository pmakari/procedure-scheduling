package com.caresyntax.scheduling.controller;

import com.caresyntax.scheduling.domain.dto.request.PageRequestDTO;
import com.caresyntax.scheduling.domain.dto.request.PatientRequestDTO;
import com.caresyntax.scheduling.domain.dto.request.StudyRequestDTO;
import com.caresyntax.scheduling.domain.dto.response.PatientResponseDTO;
import com.caresyntax.scheduling.domain.dto.response.StudyResponseDTO;
import com.caresyntax.scheduling.domain.entity.PatientEntity;
import com.caresyntax.scheduling.domain.enums.Status;
import com.caresyntax.scheduling.repository.DoctorRepository;
import com.caresyntax.scheduling.repository.RoomRepository;
import com.caresyntax.scheduling.service.api.PatientService;
import com.caresyntax.scheduling.service.api.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Parviz on 10.05.2018.
 */
@Controller
@RequestMapping("/study")
public class SchedulingController {

    @Autowired
    StudyService studyService;
    @Autowired
    PatientService patientService;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    RoomRepository roomRepository;


//    @GetMapping("/show")
//    public String showPatients(@Validated PageRequestDTO requestDTO, BindingResult bindingResult, Model model) {
//        Page<PatientEntity> page = studyService.findAll(requestDTO);
//        model.addAttribute("data", page);
//        model.addAttribute("filter", requestDTO);
//        return "patient/show";
//    }


    @RequestMapping(value = "/show-add-edit/{id}", method = RequestMethod.GET)
    public ModelAndView showAddOrEdit(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id") Long id
    ) {
        Map<String, Object> map = new HashMap<>();
        StudyResponseDTO responseDTO=StudyResponseDTO.builder().patientName(patientService.findById(id).getName()).patientId(id)
                .doctors(doctorRepository.findAll()).rooms(roomRepository.findAll()).build();
        map.put("data", responseDTO);
        ModelAndView modelAndView = new ModelAndView("study/addEdit", map);
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest request, HttpServletResponse response,
                       @Valid @ModelAttribute(value = "data") StudyRequestDTO requestDTO, BindingResult bindingResult, Model model
    ) {
        System.out.println(requestDTO);
        studyService.save(requestDTO);
        model.addAttribute("data", requestDTO);
        return "redirect:/study/show";
    }


}
