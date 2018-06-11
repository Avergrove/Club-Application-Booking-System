package sg.nus.iss.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Id
	@Column(name = "bookingid")
	private int bookingId;
	@ManyToOne
	@JoinColumn(name = "memberid")
	private User usr;
	@ManyToOne
	@JoinColumn(name = "faciltiyid")
	private Facility fac;
	@Column(name = "dateofbooking")
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bookingdate;
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "bookstartdate")
	private Date startdate;
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "bookenddate")
	private Date enddate;
	//@Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern="hh-mm")
	@Column(name = "bookstarttime")
	private Time starttime;
	//@Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern="hh-mm")
	@Column(name = "bookendtime")
	private Time endtime;
	@Column(name = "bookingcomments")
	private String comments;
	@Column(name = "bookingstatus")
	private String bookstatus;
	
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
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public Time getStarttime() {
		return starttime;
	}
	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}
	public Time getEndtime() {
		return endtime;
	}
	public void setEndtime(Time endtime) {
		this.endtime = endtime;
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
	
	//constructor using fields
	public Booking(User usr, Facility fac, Date bookingdate, Date startdate, Date enddate,
			Time starttime, Time endtime, String comments, String bookstatus) {
		super();
		this.usr = usr;
		this.fac = fac;
		this.bookingdate = bookingdate;
		this.startdate = startdate;
		this.enddate = enddate;
		this.starttime = starttime;
		this.endtime = endtime;
		this.comments = comments;
		this.bookstatus = bookstatus;
	}
	
	//constructor without comments
	public Booking(User usr, Facility fac, Date bookingdate, Date startdate, Date enddate,
			Time starttime, Time endtime, String bookstatus) {
		super();
		this.usr = usr;
		this.fac = fac;
		this.bookingdate = bookingdate;
		this.startdate = startdate;
		this.enddate = enddate;
		this.starttime = starttime;
		this.endtime = endtime;
		this.bookstatus = bookstatus;
	}

	//default constructor
	public Booking() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
