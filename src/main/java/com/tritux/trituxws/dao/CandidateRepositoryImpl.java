package com.tritux.trituxws.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tritux.trituxws.model.Candidate;
import com.tritux.trituxws.validation.exception.EmailExistsException;

@Repository
public class CandidateRepositoryImpl implements CandidateRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addCandidate(Candidate candidate) throws EmailExistsException {
		getCurrentSession().save(candidate);
	}

	@Override
	public Candidate getcandidate(Long id) {
		Candidate candidateInstance = (Candidate) getCurrentSession().get(Candidate.class, id);
		return candidateInstance;
	}

	@Override
	public void updateCandidate(Candidate candidate, Long id) {
		Candidate candidateInstance = (Candidate) getcandidate(id);
		candidateInstance.setName(candidate.getName());
		candidateInstance.setSurname(candidate.getSurname());
		candidateInstance.setEmail(candidate.getEmail());
		candidateInstance.setAge(candidate.getAge());
		getCurrentSession().update(candidateInstance);
	}

	@Override
	public void deleteCandidate(Long id) {
		Candidate candidateInstance = (Candidate) getcandidate(id);
		getCurrentSession().delete(candidateInstance);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Candidate> getAllCandidates() {
		String hql = "from Candidate";
		List<Candidate> candidateList = getCurrentSession().createQuery(hql).list();
		return candidateList;
	}

}
