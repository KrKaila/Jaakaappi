package HaagaHelia.Jaakaappi.domain;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Tuote {
//id ja generatedValue tekevät yksilöllisen primary keyn tuotteille
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long tuoteid;
	
	@NotNull
	@Min(1)
	@Max(30)
	private String name;
	
	@NotNull
	@Basic
	@Past
	private Date date;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "category_id")
    private Category categoryName;
	
	public Tuote() {}
	
	
	
	public Tuote(@NotNull @Min(1) @Max(30) String name, @NotNull @Past Date date, Category categoryName) {
		super();
		this.name = name;
		this.date = date;
		this.categoryName = categoryName;
	}



	public long getTuoteid() {
		return tuoteid;
	}



	public void setTuoteid(long tuoteid) {
		this.tuoteid = tuoteid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Category getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(Category categoryName) {
		this.categoryName = categoryName;
	}



	public Tuote(long tuoteid, @NotNull @Min(1) @Max(30) String name, @NotNull @Past Date date, Category categoryName) {
		super();
		this.tuoteid = tuoteid;
		this.name = name;
		this.date = date;
		this.categoryName = categoryName;
	}



		
	}
