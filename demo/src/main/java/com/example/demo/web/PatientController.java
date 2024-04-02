package com.example.demo.web;

import com.example.demo.entities.patient;
import com.example.demo.repositories.Patientrepositories;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
public class PatientController {
    private Patientrepositories  Patientrepositories;
    @GetMapping(path = "/index")
    public String patients(Model model ,
             @RequestParam(name ="page" ,defaultValue = "0") int page,
                           @RequestParam(name ="size" ,defaultValue = "5") int size,
    @RequestParam(name ="keyword" ,defaultValue = "") String keyword
    )
            {
        Page<patient> pagePatients=Patientrepositories.findByNomContains(keyword, PageRequest.of(page,size));
        model.addAttribute("ListPatients",pagePatients.getContent());
        model.addAttribute("pages" ,new int[pagePatients.getTotalPages()]);

        model.addAttribute("currentPage" ,page);
        model.addAttribute("keyword" ,keyword);


        return "patients";
    }

    @GetMapping("/delete")
    public String delete(Long id,String keyword ,int page) {
        Patientrepositories.deleteById(id);
        return "redirect:/index";

    }

    @GetMapping("/")
    public String home() {
       return "redirect:/index";

    }

}


