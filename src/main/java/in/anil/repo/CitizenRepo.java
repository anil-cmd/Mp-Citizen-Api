package in.anil.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.anil.entity.Citizen;
import java.util.List;


public interface CitizenRepo extends JpaRepository<Citizen, Integer>{
	
	Citizen findByEmail(String email);
	
	Citizen findByEmailAndPassword(String email, String password);

}
