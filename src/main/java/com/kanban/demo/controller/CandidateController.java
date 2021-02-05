package com.kanban.demo.controller;

import com.kanban.demo.candidate.Candidate;
import com.kanban.demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    CandidateService sev;

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable int id){
        return new ResponseEntity<>(sev.getCandidateById(id), HttpStatus.OK);
    }

    /*@GetMapping("/{name}")
    public ResponseEntity<Candidate> getCandidateByName(@PathVariable String name){
        return new ResponseEntity<>(sev.getCandidateByName(name), HttpStatus.OK);
    }*/

    @PostMapping("/update")
    public ResponseEntity<List<Candidate>>  updateCandidateInfo(@RequestBody Candidate candidate){
        sev.updateCandidateInfo(candidate);
        return new ResponseEntity<>(sev.getCandidateList(),HttpStatus.OK);
    }

    @PutMapping("/create")
    public ResponseEntity<List<Candidate>>  createCandidateInfo(@RequestBody Candidate candidate){
        sev.createNewCandidate(candidate);
        return new ResponseEntity<>(sev.getCandidateList(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Candidate>>  deleteCandidateById(@PathVariable int id){
        sev.deleteCandidateById(id);
        return new ResponseEntity<>(sev.getCandidateList(),HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public @ResponseBody  List<Candidate>  deleteAll(){
        return new ArrayList<>();
    }


}
