package com.vssm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vssm.dao.ServiceSlotInfoDao;
import com.vssm.entity.ServiceSlotInfoTable;


@CrossOrigin
@RestController
@RequestMapping(path = "slotmanagement")
public class ServiceSlotInfoController {
	@Autowired
	private ServiceSlotInfoDao dao;



	@PostMapping("/addSlots")
	public String addSlot(@RequestBody ServiceSlotInfoTable slot)
	{
		dao.addSlot(slot);
		return "successfully Added";

	}
	
	//get remaining slot from regNo and date
	@GetMapping("/getSlot/{regNo}")
   	public  List<ServiceSlotInfoTable> getSlot(@PathVariable int regNo)
   	{
   		return  dao.getRemaiangingSlot(regNo);
   	}
	

	@GetMapping("/getSlots/{regNo}/{date}")
    public int getSlot(@PathVariable int regNo,@PathVariable String date)
    {
		System.out.println("entereddddd");
     return  dao.slotDetailsOfCenter(date, regNo);
    }
	@PostMapping("/updateSlots")
	public String updateSlot(@RequestBody ServiceSlotInfoTable slot)
	{
		dao.updateSlot(slot);
		return "successfully Added";

	}

	
		
//	@DeleteMapping("/deleteSlots/{date}/{regNo}")
//	public String deleteSlot(@PathVariable String date, @PathVariable int regNo)
//	{
//		dao.deleteSlot(date, regNo);
//		return "successfully deleted";
//	}
}