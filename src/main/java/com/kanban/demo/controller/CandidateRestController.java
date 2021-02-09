package com.kanban.demo.controller;

import com.kanban.demo.candidate.Candidate;
import com.kanban.demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(allowCredentials="true",maxAge = 3600,origins = "http://localhost:3000")
@RequestMapping("/candidateREST")
public class CandidateRestController {
    @Autowired
    CandidateService sev;

    //@CrossOrigin
    @GetMapping("/find/all")
    public List<Candidate> getCandidateAll (){
        return sev.getCandidateList();
    }

    @GetMapping("/find/{id}")
    public Candidate getCandidateById (@PathVariable int id){
        return sev.getCandidateById(id);
    }

    @PostMapping("/update")
    public List<Candidate> updateCandidateInfo (@RequestBody Candidate candidate){
        sev.updateCandidateInfo(candidate);
        return sev.getCandidateList();
    }

    @PutMapping("/create")
    public List<Candidate> addCandidate (@RequestBody Candidate candidate){
        sev.createNewCandidate(candidate);
        return sev.getCandidateList();
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
