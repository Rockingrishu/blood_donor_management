package donorManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DonorController {
	@Autowired
	private DonorService service;
	
	@RequestMapping("/donor/all")
	
	public List<Donor> getAllDonors() {
		return service.getAllDonors();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/donor/add")
	
	public void addDonor(@RequestBody Donor d) {
		service.addDonor(d);
	}
	
	@RequestMapping("/donor/search/{id}") 
	
	public Donor getDonorById(@PathVariable String id) {
		return service.getDonorById(id);
	}
	
	@RequestMapping("/donor/searchByCity/{CityName}")
	
	public List<Donor> getDonorByCity(@PathVariable String CityName) {
		return service.getDonorByCity(CityName);
	}
	
	@RequestMapping("/donor/searchByMobile/{mobileNo}")
	
	public Donor getDonorByMobileNo(@PathVariable String mobileNo) {
		return service.getDonorByMobileNo(mobileNo);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/donor/update/{id}")
	
	public void updateDonor(@RequestBody Donor donor, @PathVariable String id) {
		service.updateDonor(donor, id);
	}
}
