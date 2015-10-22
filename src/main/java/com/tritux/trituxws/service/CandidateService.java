package com.tritux.trituxws.service;

import java.util.List;

import com.tritux.trituxws.model.Candidate;
import com.tritux.trituxws.validation.exception.EmailExistsException;

/**
 * A simple CandidateServiceDao for Candidate entity provide some action:
 * 
 * <ul>
 * <li>addCandiate(): to add new candidate</li>
 * <li>findCandiate(): to find candidate</li>
 * <li>updateCandiate(): to update candidate information</li>
 * <li>removeCandiate(): to remove candidate</li>
 * </ul>
 * 
 * @author Brahim Mahjoub (brahimmahjoub@yahoo.fr)
 *
 */

public interface CandidateService {

	/*
	 * add new candidate and throw an exception if candidate email already exist
	 * 
	 * @param candidate object contain candidate information
	 */
	public void addCandidate(Candidate candidate) throws EmailExistsException;

	/*
	 * find candidate by id
	 * 
	 * @param id candidate's id
	 */
	public Candidate getcandidate(Long id);

	/*
	 * update candidate information
	 * 
	 * @param id candidate's id
	 * 
	 * @param email new candidate's email
	 * 
	 * @param name candidate's name
	 * 
	 * @param surname candidate's surname
	 * 
	 * @param age candidate's age
	 */
	public void updateCandidate(Candidate candidate, Long id);

	/*
	 * remove candidate
	 * 
	 * @param id candidate's id
	 */
	public void deleteCandidate(Long id);

	/*
	 * find all candidates
	 * 
	 */
	public List<Candidate> getAllCandidates();

}
