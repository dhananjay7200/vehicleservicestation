package com.vssm.dao;


import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vssm.dtos.ServiceCenterDto;
import com.vssm.entity.ServiceCenter;
import com.vssm.repository.ServiceCenterRepository;

@Component
public class ServiceCenterDao {
	
	
	
	  private ServiceCenterRepository centerRepo;

	  public ServiceCenterDao() {

	  }

	  @Autowired
	  public ServiceCenterDao(ServiceCenterRepository centerRepo) {
		   this.centerRepo=centerRepo; 
	  	}
	  
	  //add service centre
	  public ServiceCenter RegisterCenter(ServiceCenter center)
	  {
		   return centerRepo.save(center);
	  }

	  public List<ServiceCenterDto> GetAll()
	  {
		  List <ServiceCenter> centerList= centerRepo.findAll();
		  List<ServiceCenterDto> centerDtoList=new ArrayList<>();
		  for(ServiceCenter center:centerList)
		  {
			 ServiceCenterDto dto=new ServiceCenterDto();
			   dto.setName(center.getName());
			   dto.setEmail(center.getEmail());
			   dto.setCity(center.getCity());
			   dto.setAddress(center.getAddress());
			   dto.setRegNo(center.getRegNo());
			    centerDtoList.add(dto);
		  }
		  return centerDtoList;
	  }

	  public ServiceCenterDto getByName(String name)
	  {  
		   ServiceCenter center=centerRepo.findByName(name);
		   ServiceCenterDto centerDto=new ServiceCenterDto();
		    centerDto.setName(center.getName());
		    centerDto.setRegNo(center.getRegNo());
		    centerDto.setEmail(center.getEmail());
		    centerDto.setAddress(center.getAddress());
		    centerDto.setCity(center.getCity());
		    return centerDto;
	  }

	  //service center can update capacity, contact details, email,name
	  public String updateCenterDetails(ServiceCenter serviceCenter)
	  {
		  System.out.println(serviceCenter.getCity());
		  ServiceCenter center = centerRepo.findByEmail(serviceCenter.getEmail());
		  System.out.println(center);
		  center.setCapacity(serviceCenter.getCapacity());
		  center.setContactNo(serviceCenter.getContactNo());
		  center.setName(serviceCenter.getName());
		  System.out.println(center.getName());
		  centerRepo.save(center);
		  return "center details updated";
	  }
	  
	  
	 
	  public ArrayList<String> getCities()
	  {
		  return centerRepo.getCitiesAll();
	  }
	  public ArrayList<String> getCenters(String city)
	  {
		  ArrayList<String> nameList=new ArrayList<String>();
		  ArrayList<ServiceCenter> serCenter=centerRepo.getCityCenters(city);
		  for(int i=0;i<serCenter.size();i++)
		  {
			  if(serCenter.get(i).getCity().contains(city))
					  {
				  			nameList.add(serCenter.get(i).getName());
					  }
		  }
		  return nameList;
	  }

}

