package sg.nus.iss.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "booking")
public class Booking {
	
	public static final String CONFIRMED = "CONFIRMED";
	public static final String CANCELLED = "CANCELLED";
	public static final String MAINTENANCE = "MAINTENANCE";	
	
	@Id
	@Column(name = "bookingid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingId;
	
	@ManyToOne
	@JoinColumn(name = "memberid", insertable=false, updatable=false)
	private User usr;
	
	@Column(name="memberid")
	private Integer memberId;
	
	@ManyToOne
	@JoinColumn(name = "facilityid", insertable=false, updatable=false)
	private Facility fac;
	
	@Column(name = "dateofbooking")
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bookingdate;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "bookstartdate")
	private Date startdate;
	
	@Column(name = "bookingcomments")
	private String comments;
	
	@Column(name = "bookingstatus")
	private String bookstatus;
	
	@Column(name="facilityid")
	private Integer facilityId;
	
	//getters & setters
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public User getUsr() {
		return usr;
	}
	public void setUsr(User usr) {
		this.usr = usr;
	}
	public Facility getFac() {
		return fac;
	}
	public void setFac(Facility fac) {
		this.fac = fac;
	}
	public Date getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getBookstatus() {
		return bookstatus;
	}
	public void setBookstatus(String bookstatus) {
		this.bookstatus = bookstatus;
	}
	
	public Integer getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	//constructor using fields
	public Booking(User usr, Facility fac, Date bookingdate, Date startdate, String comments, String bookstatus) {
		super();
		this.usr = usr;
		this.fac = fac;
		this.bookingdate = bookingdate;
		this.startdate = startdate;
		this.comments = comments;
		this.bookstatus = bookstatus;
	}
	
	//constructor without comments
	public Booking(User usr, Facility fac, Date bookingdate, Date startdate, String bookstatus) {
		super();
		this.usr = usr;
		this.fac = fac;
		this.bookingdate = bookingdate;
		this.startdate = startdate;
		this.bookstatus = bookstatus;
	}

	//default constructor
	public Booking() {
		// TODO Auto-generated constructor stub
	}
	
	public Booking(int bookingId, User usr, Date bookingdate, Date startdate, String comments, String bookstatus,
			Integer facilityId) {
		super();
		this.bookingId = bookingId;
		this.usr = usr;
		this.bookingdate = bookingdate;
		this.startdate = startdate;
		this.comments = comments;
		this.bookstatus = bookstatus;
		this.facilityId = facilityId;
	}
	
	//constructor with memberId and facilityId
		public Booking(int bookingId, Integer memberId, Date bookingdate, Date startdate, String comments,
				String bookstatus, Integer facilityId) {
			super();
			this.bookingId = bookingId;
			this.memberId = memberId;
			this.bookingdate = bookingdate;
			this.startdate = startdate;
			this.comments = comments;
			this.bookstatus = bookstatus;
			this.facilityId = facilityId;
		}
	
	
}
