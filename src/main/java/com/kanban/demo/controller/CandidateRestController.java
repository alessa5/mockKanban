package com.kanban.demo.controller;

import com.kanban.demo.candidate.Candidate;
import com.kanban.demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController

@RequestMapping("/candidateREST")
@CrossOrigin(origins = "http://localhost:3000")
public class CandidateRestController {
    @Autowired
    CandidateService sev;


    @GetMapping("/find/all")
    public List<Candidate> getCandidateAll (){
        return sev.getCandidateList();
    }

    @GetMapping("/find/{id}")
    public Candidate getCandidateById (@PathVariable int id){
        return sev.getCandidateById(id);
    }


    @PutMapping("/update")
    public List<Candidate> updateCandidateInfo (@RequestBody Candidate candidate){
        sev.updateCandidateInfo(candidate);
        System.out.println("post request received");
        return sev.getCandidateList();
    }

    //@CrossOrigin(origins = "http://localhost:3000/putCandidate")
    @PostMapping("/create")
    public Candidate addCandidate (@RequestBody Candidate candidate){
        return sev.createNewCandidate(candidate);
    }

    @DeleteMapping("/delete/{id}")
    public List<Candidate> addCandidate (@PathVariable int id){
        sev.deleteCandidateById(id);
        return sev.getCandidateList();
    }

    @DeleteMapping("/delete/all")
    public List<Candidate> addCandidate (){return new ArrayList<>();
    }
}
