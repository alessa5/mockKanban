package com.kanban.demo.service;

import com.kanban.demo.candidate.Candidate;
import com.kanban.demo.respository.CandidateRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CandidateService {
    @Autowired
    CandidateRespository repo;

    //get all method
    public final List<Candidate> getCandidateList(){
        return repo.findAll();
    }

    //get by name method
    public Candidate getCandidateByName(String name){
        Candidate res = getCandidateList().stream().filter(c->c.getName().equals(name)).findAny().orElse(null);
        return res;
    }

    //get by id method
    public Candidate getCandidateById(int id){
        Candidate res = getCandidateList().stream().filter(c->c.getId()==id).findAny().orElse(null);
        return res;
    }

    //post info changing method
    public Candidate updateCandidateInfo(Candidate candidate) {
        List<Candidate> canList = getCandidateList();
        Iterator<Candidate> ite = canList.iterator();
        Candidate current = canList.get(0);
        int targetId = candidate.getId();

        while(ite.hasNext()){
            current = ite.next();
            if(current.getId() == targetId){
                current.setName(candidate.getName());
                current.setContact(candidate.getContact());
                current.setEducation(candidate.getEducation());
                current.setStates(candidate.getStates());
            }
            break;
        }
        return current;
    }

    //put info changing method
    public Candidate createNewCandidate(Candidate candidate){
        List<Candidate> old = getCandidateList();
        int maxId = old.stream().mapToInt(c->c.getId()).max().orElse(0);
        candidate.setId(maxId+10);
        return repo.save(candidate);
    }

    //delete candidate by id method
    public void deleteCandidateById(int id){
        Iterator<Candidate> ite = getCandidateList().iterator();
        while(ite.hasNext()){
            Candidate current = ite.next();
            if(current.getId() == id){
                repo.delete((current));
            }
        }
    }


}
