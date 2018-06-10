package sg.nus.iss.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.nus.iss.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
	@Query("SELECT u FROM User u WHERE u.userid=:un AND u.password=:pwd")
	User findUserByNamePwd(@Param("un") String uname, @Param("pwd") String pwd);
	
}
