package donorManagement;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service


public class DonorService {
	private ArrayList<Donor> donors = new ArrayList<Donor>(
				Arrays.asList(
							new Donor("101", "Reetika", "Jammu", "O+", "Jammu and Kashmir", "1234567890"),
							new Donor("102", "Yash", "MuzaffarPur", "A+", "Bihar", "9999999999"),
							new Donor("103", "Payal", "Jammu", "A+", "Jammu and Kashmir", "1010101010")
						)
			);

	public List<Donor> getAllDonors() {
		// TODO Auto-generated method stub
		return donors;
	}

	public void addDonor(Donor d) {
		donors.add(d);
	}

	public Donor getDonorById(String id) {
		return
				donors.stream().filter(don -> don.getId().equals(id)).findFirst().get();
	}

	public List<Donor> getDonorByCity(String cityName) {
		List<Donor> donorsByCity = new ArrayList<Donor>();
		donorsByCity.addAll(donors.stream().filter(don -> don.getCity().equalsIgnoreCase(cityName)).toList());
		return donorsByCity;
	}

	public Donor getDonorByMobileNo(String mobileNo) {
		return
				donors.stream().filter(don -> don.getMobileNo().equals(mobileNo)).findFirst().get();
	}

	public void updateDonor(Donor donor, String id) {
		for(int i = 0; i<donors.size(); i++) {
			Donor d = donors.get(i);
			if(d.getId().equals(id)) {
				donors.set(i, donor);
				return;
			}
		}
	}
	
}
