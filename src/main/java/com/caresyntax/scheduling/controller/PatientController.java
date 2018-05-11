package com.caresyntax.scheduling.controller;

import com.caresyntax.scheduling.domain.dto.request.PageRequestDTO;
import com.caresyntax.scheduling.domain.dto.request.PatientRequestDTO;
import com.caresyntax.scheduling.domain.dto.response.PatientResponseDTO;
import com.caresyntax.scheduling.domain.entity.PatientEntity;
import com.caresyntax.scheduling.service.api.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Parviz on 10.05.2018.
 */
@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/show")
    public String showPatients(@Validated PageRequestDTO requestDTO, BindingResult bindingResult, Model model) {
        Page<PatientEntity> page = patientService.findAll(requestDTO);
        model.addAttribute("data", page);
        model.addAttribute("filter", requestDTO);
        return "patient/show";
    }

    @RequestMapping(value = "/show-add-edit/{id}", method = RequestMethod.GET)
    public ModelAndView showAddOrEdit(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "id") Long id
    ) {
        System.out.println("idddddddddd"+id);
        Map<String, Object> map = new HashMap<>();
        PatientResponseDTO responseDTO;
        if (id == 0) {
            responseDTO = new PatientResponseDTO();
        } else {
            responseDTO = patientService.findById(id);
        }
//        System.out.println(responseDTO.toString());
        map.put("data", responseDTO);
        ModelAndView modelAndView = new ModelAndView("patient/addEdit", map);
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(HttpServletRequest request, HttpServletResponse response,
                       @Valid @ModelAttribute(value = "data") PatientRequestDTO requestDTO, BindingResult bindingResult, Model model
    )
    {
        System.out.println(requestDTO.toString());
        patientService.save(requestDTO);
        model.addAttribute("data", requestDTO);
        return "redirect:/patient/show";
    }


}
