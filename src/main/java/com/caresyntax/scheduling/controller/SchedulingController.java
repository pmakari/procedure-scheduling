package com.caresyntax.scheduling.controller;

import com.caresyntax.scheduling.aspect.CheckBindingResult;
import com.caresyntax.scheduling.domain.dto.request.ChangeStatusDTO;
import com.caresyntax.scheduling.domain.dto.request.PageRequestDTO;
import com.caresyntax.scheduling.domain.dto.request.PatientRequestDTO;
import com.caresyntax.scheduling.domain.dto.request.StudyRequestDTO;
import com.caresyntax.scheduling.domain.dto.response.PatientResponseDTO;
import com.caresyntax.scheduling.domain.dto.response.StudyResponseDTO;
import com.caresyntax.scheduling.domain.entity.PatientEntity;
import com.caresyntax.scheduling.domain.entity.StudyEntity;
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


    @GetMapping("/show")
    public String showPatients(@Validated PageRequestDTO requestDTO, BindingResult bindingResult, Model model) {
        Page<StudyEntity> page = studyService.findAll(requestDTO);
        model.addAttribute("data", page);
        page.getContent().forEach(n -> System.out.println(n.getDescription() + n.getStatus()));
        return "study/show";
    }


    @RequestMapping(value = "/show-add-edit/{id}", method = RequestMethod.GET)
    public ModelAndView showAddOrEdit(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id") Long id
    ) {
        Map<String, Object> map = new HashMap<>();
        StudyResponseDTO responseDTO = StudyResponseDTO.builder().patientName(patientService.findById(id).getName()).patientId(id)
                .doctors(doctorRepository.findAll()).rooms(roomRepository.findAll()).build();
        map.put("data", responseDTO);
        ModelAndView modelAndView = new ModelAndView("study/addEdit", map);
        return modelAndView;
    }
    @CheckBindingResult
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest request, HttpServletResponse response,
                       @Validated @ModelAttribute(value = "data") StudyRequestDTO requestDTO, BindingResult bindingResult, Model model
    ) {
        requestDTO.setStatus(Status.PLANNED);
        studyService.save(requestDTO);
        return "redirect:/study/show";
    }
    @CheckBindingResult
    @RequestMapping(value = "/change-status", method = RequestMethod.POST)
    public void changeStatus(HttpServletRequest request, HttpServletResponse response,
                             @RequestBody @Validated ChangeStatusDTO requestDTO, BindingResult bindingResult, Model model
    ) {
        studyService.changeStatus(requestDTO);
    }


}
