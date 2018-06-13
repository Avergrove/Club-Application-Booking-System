package sg.nus.iss.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.nus.iss.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
	@Query("SELECT u FROM User u WHERE u.userid=:un AND u.password=:pwd")
	User findUserByNamePwd(@Param("un") String uname, @Param("pwd") String pwd);
	
	@Query("SELECT u FROM User u WHERE u.userid=:username")
	User findUserByUsername(@Param("username") String username);
	
	@Query("SELECT u FROM User u WHERE u.email=:email")
	User findUserByEmail(@Param("email") String email);
	
	@Query("Select DISTINCT count(u) from User u where u.userid=:un")
	int findUserIDAvailability(@Param("un") String userid);
	
	@Query("UPDATE User u SET u.Status = 'InActive' WHERE u.memberid =:id")
	void UpdateMemberStatus(@Param("id") int memberid);
	
	@Query("Select roleid from User u where u.userid=:un")
	int findUserrole(@Param("un") int memberid);	
	
	
	
}
