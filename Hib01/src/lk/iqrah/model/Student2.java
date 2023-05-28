package lk.iqrah.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Student2 {
	@Id
	@GenericGenerator(name = "gen1", strategy = "lk.iqrah.model.StudentIdGenerator")
	@GeneratedValue(generator = "gen1")
	private String sid;

	private String sname;

	private Integer sage;

	private String saddress;

	public Student2() {

	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	@Override
	public String toString() {
		return "Student2 [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + "]";
	}

}
