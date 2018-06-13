package sg.nus.iss.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.nus.iss.model.Userrole;

public interface UserroleRepository extends JpaRepository<Userrole, Integer> {
	@Query("SELECT DISTINCT r.rolename FROM Userrole r")
	ArrayList<String> findAlluserroles();
	
	@Query("SELECT DISTINCT r.roleId FROM Userrole r")
	ArrayList<Integer> findAlluserroleID();

	@Query("SELECT DISTINCT r from Userrole r where r.rolename=:name")
	Userrole findRolebyname(@Param("name") String name);
}
