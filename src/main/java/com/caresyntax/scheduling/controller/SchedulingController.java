package com.caresyntax.scheduling.controller;

import com.caresyntax.scheduling.domain.dto.request.PageRequestDTO;
import com.caresyntax.scheduling.domain.entity.PatientEntity;
import com.caresyntax.scheduling.service.api.PatientService;
import com.caresyntax.scheduling.service.api.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Parviz on 10.05.2018.
 */
@Controller
@RequestMapping("/study")
public class SchedulingController {


//    @GetMapping("/show")
//    public String showPatients(@Validated PageRequestDTO requestDTO, BindingResult bindingResult, Model model) {
//        Page<PatientEntity> page = studyService.findAll(requestDTO);
//        model.addAttribute("data", page);
//        model.addAttribute("filter", requestDTO);
//        return "patient/show";
//    }
//

}
