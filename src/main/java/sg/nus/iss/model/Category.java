package sg.nus.iss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	
	@OneToMany
	@Id
	@Column(name = "categoryid")
	private int categoryId;
	@Column(name = "categoryname")
	private String categoryname;
	
	//getters & Setters
	public int getCategoryId() {
		return categoryId;
	}
	
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	//default constructor
	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	//constructor using fields
	public Category(int categoryId, String categoryname) {
		super();
		this.categoryId = categoryId;
		this.categoryname = categoryname;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryname=" + categoryname + "]";
	}
	
	

}
