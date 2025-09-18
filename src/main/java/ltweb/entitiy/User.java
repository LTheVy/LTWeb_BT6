package ltweb.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll()", query = "SELECT c FROM User c")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "VARCHAR (255)")
	private String username;
	
	@Column(columnDefinition = "VARCHAR (255)")
	private String email;
	
	@Column(columnDefinition = "VARCHAR (255)")
	private String password;
	
	@Column(columnDefinition = "VARCHAR (255)")
	private String fullname;
	
	@Column(columnDefinition = "VARCHAR (255)")
	private String phone;
		
}
