package sg.nus.iss.model;

import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.Transient;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "memberid")
	private int memberid;
	
	@Basic(optional = false)
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "secondname")
	private String secondname;
	
	@Basic(optional = false)
	@Column(name = "surname")
	private String surname;
	
	@Basic(optional = false)
	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;
	
	@Column(name = "joindate")
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date joindate;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "expirydate")
	private Date expirydate;
	
	@Basic(optional = false)
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "phoneno")
	private int phone;
	
	@Basic(optional = false)
	@Column(name = "userid", unique = true)
	private String userid;
	
	@Basic(optional = false)
	@Size(min=5, max=15, message= "Your passowrd should be between 5 to 15 characters")
	@Column(name = "password")
	private String password;
	

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="roleid", insertable=false, updatable=false)
	private Userrole role;

	@Column(name="roleid")
	private int roleid;
	

	@Basic(optional = false)
	@Column(name = "status")
	private String Status;
	
	@Transient
	@OneToMany
	@JoinColumn(name = "memberid")
	private List<Booking> bookset = new ArrayList<Booking>();
	
	//Getters and Setters
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Userrole getRole() {
		return role;
	}
	public void setRole(Userrole role) {
		this.role = role;
	}
	public String getStatus() {
		return Status;
	}
	
	public void setStatus(String status) {
		Status = status;
	}
	
	public int getMemberid() {
		return memberid;
	}
	
	public void setMemberid(int id) {
		memberid = id;
	}
	

	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	public List<Booking> getBookset() {
		return bookset;
	}
	public void setBookset(List<Booking> bookset) {
		this.bookset = bookset;
	}
	
	//Constructor with all fields
	public User(String firstname, String secondname, String surname, Date dob, String email, int phone,
			String userid, String password, Userrole role) throws ParseException {
		super();
		this.firstname = firstname;
		this.secondname = secondname;
		this.surname = surname;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.userid = userid;
		this.password = password;
		this.joindate = DateChange();
		this.expirydate = RenewExpiry(this.joindate);
		this.Status = "Active";
		this.role = role;
	}
	
	//Constructor with all fields
		public User(String firstname, String secondname, String surname, Date dob, String email, int phone,
				String userid, String password, int role) throws ParseException {
			super();
			this.firstname = firstname;
			this.secondname = secondname;
			this.surname = surname;
			this.dob = dob;
			this.email = email;
			this.phone = phone;
			this.userid = userid;
			this.password = password;
			this.joindate = DateChange();
			this.expirydate = RenewExpiry(this.joindate);
			this.Status = "Active";
			this.roleid = role;
		}
	
		//Constructor with all fields
			public User(int id,String firstname, String secondname, String surname, Date dob, String email, int phone,
						String userid, String password, int role) throws ParseException {
					super();
					this.memberid=id;
					this.firstname = firstname;
					this.secondname = secondname;
					this.surname = surname;
					this.dob = dob;
					this.email = email;
					this.phone = phone;
					this.userid = userid;
					this.password = password;
					this.joindate = DateChange();
					this.expirydate = RenewExpiry(this.joindate);
					this.Status = "Active";
					this.roleid = role;
				}
	//constructor without phone number
	public User(String firstname, String secondname, String surname, Date dob, String email, String userid, String password, Userrole role) throws ParseException {
		super();
		this.firstname = firstname;
		this.secondname = secondname;
		this.surname = surname;
		this.dob = dob;
		this.email = email;
		this.phone = 0;
		this.userid = userid;
		this.password = password;
		this.joindate = DateChange();
		this.expirydate = RenewExpiry(this.joindate);
		this.Status = "Active";
		this.role = role;
	}
	
	public User(String firstname, String secondname, String surname, Date dob, String email, String userid, String password, int role) throws ParseException {
		super();
		this.firstname = firstname;
		this.secondname = secondname;
		this.surname = surname;
		this.dob = dob;
		this.email = email;
		this.phone = 0;
		this.userid = userid;
		this.password = password;
		this.joindate = DateChange();
		this.expirydate = RenewExpiry(this.joindate);
		this.Status = "Active";
		this.roleid = role;
	}
	
	public User(int id,String firstname, String secondname, String surname, Date dob, String email, String userid, String password, int role) throws ParseException {
		super();
		this.memberid =id;
		this.firstname = firstname;
		this.secondname = secondname;
		this.surname = surname;
		this.dob = dob;
		this.email = email;
		this.phone = 0;
		this.userid = userid;
		this.password = password;
		this.joindate = DateChange();
		this.expirydate = RenewExpiry(this.joindate);
		this.Status = "Active";
		this.roleid = role;
	}
	
	//Constructor without secondname
	public User(String firstname, String surname, Date dob, String email, int phone, String userid,
			String password, Userrole role) throws ParseException {
		super();
		this.firstname = firstname;
		this.surname = surname;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.userid = userid;
		this.password = password;
		this.joindate = DateChange();
		this.expirydate = RenewExpiry(this.joindate);
		this.Status = "Active";
		this.role = role;
	}
	
	public User(String firstname, String surname, Date dob, String email, int phone, String userid,
			String password, int role) throws ParseException {
		super();
		this.firstname = firstname;
		this.surname = surname;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.userid = userid;
		this.password = password;
		this.joindate = DateChange();
		this.expirydate = RenewExpiry(this.joindate);
		this.Status = "Active";
		this.roleid = role;
	}
	
	public User(int id, String firstname, String surname, Date dob, String email, int phone, String userid,
			String password, int role) throws ParseException {
		super();
		this.memberid = id;
		this.firstname = firstname;
		this.surname = surname;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.userid = userid;
		this.password = password;
		this.joindate = DateChange();
		this.expirydate = RenewExpiry(this.joindate);
		this.Status = "Active";
		this.roleid = role;
	}
	//Constructor without secondname and phone number
	public User(String firstname, String surname, Date dob, String email, String userid,
			String password, Userrole role) throws ParseException {
		super();
		this.firstname = firstname;
		this.surname = surname;
		this.dob = dob;
		this.email = email;
		this.phone = 0;
		this.userid = userid;
		this.password = password;
		this.joindate = DateChange();
		this.expirydate = RenewExpiry(this.joindate);
		this.Status = "Active";
		this.role = role;
	}
	
	public User(String firstname, String surname, Date dob, String email, String userid,
			String password, int role) throws ParseException {
		super();
		this.firstname = firstname;
		this.surname = surname;
		this.dob = dob;
		this.email = email;
		this.phone = 0;
		this.userid = userid;
		this.password = password;
		this.joindate = DateChange();
		this.expirydate = RenewExpiry(this.joindate);
		this.Status = "Active";
		this.roleid = role;
	}
	
	public User(int id,String firstname, String surname, Date dob, String email, String userid,
			String password, int role) throws ParseException {
		super();
		this.memberid = id;
		this.firstname = firstname;
		this.surname = surname;
		this.dob = dob;
		this.email = email;
		this.phone = 0;
		this.userid = userid;
		this.password = password;
		this.joindate = DateChange();
		this.expirydate = RenewExpiry(this.joindate);
		this.Status = "Active";
		this.roleid = role;
	}
	//Default constructor
	public User(){
		// TODO Auto-generated constructor stub
	}
	
	private Date RenewExpiry(Date fromDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(fromDate); // Now use join date.
		c.add(Calendar.DATE, 365); // Adding 365 days
		if(c.getTime().getDay() == DayOfWeek.SATURDAY.getValue())
		{
			c.add(Calendar.DATE, 2);
		}
		if(c.getTime().getDay() == DayOfWeek.SUNDAY.getValue())
		{
			c.add(Calendar.DATE, 1);
		}
		String output = sdf.format(c.getTime());
		Date ddd= (Date) new SimpleDateFormat("yyyy-MM-dd").parse(output);
		 return ddd;
	}
	
	@Override
	public String toString() {
		return "User [memberid=" + memberid + ", firstname=" + firstname + ", secondname=" + secondname + ", surname="
				+ surname + ", dob=" + dob + ", joindate=" + joindate + ", expirydate=" + expirydate + ", email="
				+ email + ", phone=" + phone + ", userid=" + userid + ", password=" + password + ", roleid=" + roleid
				+ ", Status=" + Status + "]";
	}
	
	public Date DateChange() throws ParseException
	{
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 Calendar calobj = Calendar.getInstance();
		 String dd = df.format(calobj.getTime());	
		 Date ddd= (Date) new SimpleDateFormat("yyyy-MM-dd").parse(dd);
		 return ddd;
	}
	
}