package sg.nus.iss.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "userrole")
public class Userrole {
	@Id
	@Column(name = "roleid")
	private int roleId;
	@Column(name = "rolename")
	private String rolename;
	@OneToMany(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name ="roleid")		
	private Set<User> users = new HashSet<User>();
	
	//getters & Setters
	public int getRoleId() {
		return roleId;
	}
	
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	//default constructor
	public Userrole() {
		// TODO Auto-generated constructor stub
	}
	
	public Userrole(int roleId, String rolename) {
		super();
		this.roleId = roleId;
		this.rolename = rolename;
	}
	
	@Override
	public String toString() {
		return "Userrole [roleId=" + roleId + ", rolename=" + rolename + "]";
	}
	
	
	
	
	
	
	
	
	

}
