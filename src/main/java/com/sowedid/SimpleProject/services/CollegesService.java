package com.sowedid.SimpleProject.services;

import java.util.List;

//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sowedid.SimpleProject.models.Colleges;
import com.sowedid.SimpleProject.repositories.CollegesRepository;

@Service
public class CollegesService {
	private CollegesRepository collegesRepository;
	
	/*@Autowired
	public CollegesService(CollegesRepository collegesRepository) {
		this.collegesRepository=collegesRepository;
	}
	
	public Colleges createColleges(Colleges colleges) {
		return collegesRepository.save(colleges);
		}
	
	public Iterable<Colleges> list() {
		return collegesRepository.findAll();
	}
	
	public Colleges byCandidate(Integer candidateId) {
			return collegesRepository.findByCandidateId(candidateId);
	}*/

	public Iterable<Colleges> getCollegesDetails() {
		// TODO Auto-generated method stub
		return collegesRepository.findAll();
	}
}
