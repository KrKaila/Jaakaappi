package HaagaHelia.Jaakaappi.domain;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Tuote {
//id ja generatedValue tekevät yksilöllisen primary keyn tuotteille
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long tuoteid;
	private String name;
	@Basic
	private Date date;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "luokkaid")
    private Luokka lname;
	
	public Tuote() {}
	
	public Tuote(String name, Date date, Luokka lname) {
		super();
		this.name = name;
		this.date = date;
		this.lname = lname;
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

	public Luokka getLuokka() {
		return lname;
	}

	public void setLuokka(Luokka luokka) {
		this.lname = lname;
	}

	
	@Override
	public String toString() {
		if (this.lname != null)
			return "Tuote [tuoteid=" + tuoteid + ", name=" + name + ", date=" + date + ", lname=" + lname + "]";
		else
			return "Tuote [tuoteid=" + tuoteid + ", name=" + name + ", date=" + date + "]";
	}

}
