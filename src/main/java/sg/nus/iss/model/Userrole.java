package sg.nus.iss.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "userrole")
public class Userrole {
	
	public static final int MEMBER = 1;
	public static final int ADMIN = 1;
	
	
	@Id
	@Column(name = "roleid")
	private int roleId;
	@Column(name = "rolename")
	private String rolename;
	@Transient
	@OneToMany(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<User> users = new ArrayList<User>();
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	//getters & Setters
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId)
	{
		this.roleId=roleId;
	}
	
	public Userrole(int roleId, String rolename, List<User> users) {
		super();
		this.roleId = roleId;
		this.rolename = rolename;
		this.users = users;
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
