package com.vssm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vssm.entity.ServiceCenter;
import com.vssm.entity.ServiceSlotInfoTable;
import com.vssm.repository.ServiceCenterRepository;
import com.vssm.repository.ServiceSlotInfoRepository;

@Component
public class ServiceSlotInfoDao {

	private ServiceSlotInfoRepository slotRepo;


	@Autowired
	private ServiceCenterRepository centerRepo;

	public ServiceSlotInfoDao()
	{

	}

	@Autowired
	public ServiceSlotInfoDao(ServiceSlotInfoRepository slotRepo) {
		this.slotRepo = slotRepo;
	}
	/*@Transactional
	public void addSlot(ServiceSlotInfoTable slot)
	{
		ServiceSlotInfoTable slotDetails = slotRepo.save(slot);
		slotRepo.changeSlotForRecent(slotDetails.getTotalSlot(), slotDetails.getBookingId());
	} */
/*
	public ServiceSlotInfoTable slotDetailsOfCenter(String date, int regNo)
	{
		return slotRepo.getByDateAndRegNo(date,regNo);
	}*/
	public void addSlot(ServiceSlotInfoTable slot) {
		System.out.println("hiiii"+slot.getTotalSlot());
		String email=slot.getCenter().getEmail();
		  ServiceCenter center=centerRepo.findByEmail(email);
		  slot.setCenter(center);
		 slot.setRemainingSlot(slot.getTotalSlot());
		 slotRepo.save(slot);



	}


	  public List<ServiceSlotInfoTable> getRemaiangingSlot(int RegNo)
	  {
		  ServiceCenter center=centerRepo.findByRegNo(RegNo);
		  return center.getSlotList();
	  }

	  //Akshay  
		/*
		 * public int getRemaiangingSlot(int RegNo,String date) {
		 * System.out.println(RegNo+" "+date); ServiceCenter
		 * center=centerRepo.findByRegNo(RegNo); int id=center.getId(); return
		 * slotRepo.getRemainingSlots(id, date); }
		 */

	  public int slotDetailsOfCenter(String date, int regNo)
		{
		  ServiceCenter center=centerRepo.findByRegNo(regNo);
		  int id=center.getId();
		  ServiceSlotInfoTable ss= slotRepo.getByDateAndRegNo(date,id);

		  return ss.getRemainingSlot();
		}
	  
	  public void updateSlot(ServiceSlotInfoTable slot) {
			System.out.println("hiiii"+slot.getTotalSlot());
			String email=slot.getCenter().getEmail();
			ServiceSlotInfoTable obj=slotRepo.getByDateAndEmail(slot.getDate(), email);
			//int remaingslot=obj.getRemainingSlot();
			//int newRemaining=remaingslot+(slot.getTotalSlot()-obj.getTotalSlot());
			
			obj.setTotalSlot(slot.getTotalSlot());
			obj.setRemainingSlot(slot.getTotalSlot());
		
			slotRepo.save(obj);
		}

	  
	  
}
