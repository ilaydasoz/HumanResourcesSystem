package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "Users")
public class Employer extends User {
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone_number")
	private int phoneNumber;
	
	@Column(name="website")
	private String website;
	
	@Column(name="email_verify")
	private boolean emailVerify;

}
