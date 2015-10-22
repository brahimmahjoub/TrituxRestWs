package com.tritux.trituxws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tritux.trituxws.dao.CandidateRepository;
import com.tritux.trituxws.model.Candidate;
import com.tritux.trituxws.validation.exception.EmailExistsException;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {
	
	@Autowired
	CandidateRepository repository;

	@Override
	public void addCandidate(Candidate candidate) throws EmailExistsException {
		repository.addCandidate(candidate);
	}

	@Override
	public Candidate getcandidate(Long id) {
		return repository.getcandidate(id);
	}

	@Override
	public void updateCandidate(Candidate candidate, Long id) {
		repository.updateCandidate(candidate, id);
	}

	@Override
	public void deleteCandidate(Long id) {
		repository.deleteCandidate(id);		
	}

	@Override
	public List<Candidate> getAllCandidates() {
		return repository.getAllCandidates();
	}


}
