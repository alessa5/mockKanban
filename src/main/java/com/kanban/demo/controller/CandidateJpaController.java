package com.kanban.demo.controller;

import com.kanban.demo.candidate.Candidate;
import com.kanban.demo.respository.CandidateRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controllerwithjpa")
public class CandidateJpaController {
    @Autowired
    private CandidateRespository repo;

    @GetMapping("/get/{id}")
    public Candidate getCandidateById(@PathVariable int id){
        Candidate target = repo.getOne(id);
        return target;
    }

    @GetMapping("/getAll")
    public List<Candidate> getAllCandidates(){
        return repo.findAll();
    }

    @PutMapping("/update")
    public List<Candidate> updateCandidateInfo(@RequestBody Candidate input){
        Integer targetId = input.getId();
        Candidate target = repo.getOne(targetId);
        target.setStates(input.getStates());
        target.setEducation(input.getEducation());
        target.setContact(input.getContact());
        target.setName(input.getName());
        repo.save(target);
        return repo.findAll();
    }

    @PostMapping("/add")
    public List<Candidate> addNewCandidate(@RequestBody Candidate input){
        repo.save(input);
        return repo.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public List<Candidate> deleteCandidateById(@PathVariable int id){
        repo.deleteById(id);
        return repo.findAll();
    }

}
