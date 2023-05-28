package lk.hnb.model;
// Generated 13 Apr 2023, 20:25:18 by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Insurancepolicy generated by hbm2java
 */
@Entity
@Table(name = "insurancepolicy", catalog = "iqrah_students")
public class Insurancepolicy implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long policyId;
	private String company;
	private String policyName;
	private String policyType;
	private Integer tenure;

	public Insurancepolicy() {
	}

	public Insurancepolicy(String company, String policyName, String policyType, Integer tenure) {
		this.company = company;
		this.policyName = policyName;
		this.policyType = policyType;
		this.tenure = tenure;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "policyId", unique = true, nullable = false)
	public Long getPolicyId() {
		return this.policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	@Column(name = "company")
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "policyName")
	public String getPolicyName() {
		return this.policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	@Column(name = "policyType")
	public String getPolicyType() {
		return this.policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	@Column(name = "tenure")
	public Integer getTenure() {
		return this.tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "Insurancepolicy [policyId=" + policyId + ", company=" + company + ", policyName=" + policyName
				+ ", policyType=" + policyType + ", tenure=" + tenure + "]";
	}

	
}
