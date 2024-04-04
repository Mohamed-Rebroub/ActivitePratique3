package com.example.ActivitePratique3.web;

import com.example.ActivitePratique3.entities.Patient;
import com.example.ActivitePratique3.repository.PatientRepository;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/")
    public String home() {
        return "index"; // Retourne le nom de la page HTML sans extension
    }
    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name="page",defaultValue="0")int p,
                        @RequestParam(name="size",defaultValue="6")int s,
                        @RequestParam(name="keyword",defaultValue="")String kw
    ){
        Page<Patient> pagePatients=patientRepository.findByNomContains(kw, PageRequest.of(p,s));

        model.addAttribute("ListPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",p);
        model.addAttribute("keyword",kw);
        return "patients";
    }

    @GetMapping("/delete")
    public String delete(long id, String keyword, int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
}
