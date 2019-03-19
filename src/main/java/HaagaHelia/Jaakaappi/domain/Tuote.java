package HaagaHelia.Jaakaappi.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Tuote {
//id ja generatedValue tekevät yksilöllisen primary keyn tuotteille
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tuoteid;
	
	@NotNull
	private String name;
	
	/*@NotNull
	@Basic
	private Date date;
	*/
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "category_id")
	private Category categoryName;
	
	public Tuote() {}
	public Tuote(@NotNull String name, Date date, Category categoryName) {
	super();
	this.name = name;
	//this.date = date;
	this.categoryName = categoryName;
	}
	/*public Tuote(@NotNull String name, Date date) {
	super();
	this.name = name;
	this.date = date;
	}
	*/
	public Tuote(String name) {
		super();
		this.name = name;
	}
	public Long getTuoteid() {
		return tuoteid;
	}
	public void setTuoteid(Long tuoteid) {
		this.tuoteid = tuoteid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	*/
	public Category getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(Category categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return "Tuote [tuoteid=" + tuoteid + ", name=" + name + "]";
	}
}
