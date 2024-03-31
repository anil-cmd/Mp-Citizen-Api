package in.anil.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.anil.entity.User;
import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);
	
	User findByEmailAndPassword(String email, String password);

}
