package com.tritux.trituxws.dao;

import java.util.List;

import com.tritux.trituxws.model.Candidate;
import com.tritux.trituxws.validation.exception.EmailExistsException;

public interface CandidateRepository {

    public void addCandidate(Candidate candidate) throws EmailExistsException;
    public Candidate getcandidate(Long id);
    public void updateCandidate(Candidate candidate, Long id);
    public void deleteCandidate(Long id);
    public List<Candidate> getAllCandidates();
    
}
