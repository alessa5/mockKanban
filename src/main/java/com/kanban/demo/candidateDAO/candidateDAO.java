package com.kanban.demo.candidateDAO;

import com.kanban.demo.candidate.Candidate;
import com.kanban.demo.states.States;

import java.util.ArrayList;
import java.util.List;

public class candidateDAO {
    private static List<Candidate> candidateList;

    private candidateDAO(){};

    static {
        candidateList = new ArrayList<>();
        candidateList.add(new Candidate(10,"elwen", "high school", "123", States.Rejected));
        candidateList.add(new Candidate(20,"alex", "associate ", "456", States.Offered));
        candidateList.add(new Candidate(30,"browdey", "master", "789", States.OnSite));
    }

    public List<Candidate> getCandidateList(){
        return candidateList;
    }

    public void setCandidateList(List<Candidate> candidateList){
        this.candidateList = candidateList;
    }
}
