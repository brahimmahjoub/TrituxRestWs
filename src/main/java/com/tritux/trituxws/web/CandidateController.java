package com.tritux.trituxws.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tritux.trituxws.model.Candidate;
import com.tritux.trituxws.service.CandidateService;
import com.tritux.trituxws.validation.exception.EmailExistsException;

@Controller
@RequestMapping(value = "/candidate")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	@RequestMapping(value = "/all", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Candidate> getAllCandidates() {
		List<Candidate> candidateList = candidateService.getAllCandidates();
		return candidateList;

	}
	
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Candidate getCandidate(@PathVariable Long id) {
		Candidate candidate = candidateService.getcandidate(id);
		return candidate;
		
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody Candidate addCandidate(@ModelAttribute Candidate candidate) {
		try {
			candidateService.addCandidate(candidate);
			return candidate;
		} catch (EmailExistsException e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody Candidate updateCandidate(@ModelAttribute Candidate candidate, @PathVariable Long id) {
		candidateService.updateCandidate(candidate, id);
		return candidate;
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Candidate> removeCandidate(@PathVariable Long id) {
		candidateService.deleteCandidate(id);
		List<Candidate> candidateList = candidateService.getAllCandidates();
		return candidateList;
	}

}
