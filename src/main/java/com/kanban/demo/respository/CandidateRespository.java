package com.kanban.demo.respository;

import com.kanban.demo.candidate.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRespository extends JpaRepository<Candidate, Integer> {
}
