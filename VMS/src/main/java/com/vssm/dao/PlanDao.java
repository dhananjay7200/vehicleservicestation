package com.vssm.dao;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vssm.dtos.PlanDto;
import com.vssm.entity.Plan;
import com.vssm.entity.ServiceCenter;
import com.vssm.repository.PlanRepository;
import com.vssm.repository.ServiceCenterRepository;

@Component
public class PlanDao {
	

	private PlanRepository planRepo;
	@Autowired
	private ServiceCenterRepository centerRepo;

	public PlanDao()
	{
		
	}
	
	@Autowired
	public PlanDao(PlanRepository planRepo)
	{
		this.planRepo=planRepo;
	}

	 public Plan addPlan(Plan plan)
	 {
		 String email= plan.getServiceCenterRef().getEmail();
		 ServiceCenter center=centerRepo.findByEmail(email);
		 plan.setServiceCenterRef(center);
		 return planRepo.save(plan);

	 }

	 public List<PlanDto> getPlan(int regNo) throws FileNotFoundException
	 {
	       ServiceCenter center= centerRepo.findByRegNo(regNo);
	        List<Plan> plans=center.getPlans();
	        List<PlanDto> list=new ArrayList<>();

	         for(Plan plan:plans)
	         {
	           PlanDto dto=new PlanDto();
	           dto.setName(plan.getName());
	           dto.setCost(plan.getCost());
	           dto.setDescription(plan.getDescription());
	           dto.setImage(plan.getImage());
	           list.add(dto);
	         }
	        return list;
	 }

}