package com.sowedid.SimpleProject.services;

import java.util.List;

import com.sowedid.SimpleProject.domain.AddressDomain;
import com.sowedid.SimpleProject.domain.BranchesDomain;
import com.sowedid.SimpleProject.models.Address;
import com.sowedid.SimpleProject.models.Branches;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.sowedid.SimpleProject.repositories.BranchesRepository;

@Service
public class BranchesService {
	@Autowired
	private BranchesRepository branchesRepository;
	public List<Branches> getBranchesDetails(){
		return branchesRepository.findAll();
	}
	public Branches getBranchesByStudentId(Integer studentId) {
		Branches branches=branchesRepository.findByStudentId(studentId);
		return branches;
	}

	public BranchesDomain saveOrUpdateBranches(Branches branches) {
		// TODO Auto-generated method stub
		Branches branches2=branchesRepository.save(branches);
		BranchesDomain branchesDomain=new BranchesDomain();
		if(branches2!=null){
			branchesDomain.setStudentId(branches2.getStudentId());
			branchesDomain.setStudentName(branches2.getStudentName());
			branchesDomain.setDepartments(branches2.getDepartments());
			
		}
		return branchesDomain;
	
		
	}
}