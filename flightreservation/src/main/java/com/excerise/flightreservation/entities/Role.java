package com.excerise.flightreservation.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

//import org.springframework.security.core.GrantedAuthority;

// need to implement GrantedAuthority in order to use Spring security
@Entity
public class Role extends AbstractEntity {//implements GrantedAuthority {

	private String name;
	// the meaning is to set the definition of the relation by roles entity
	// their we define also the inverse relation
	@ManyToMany(mappedBy="roles")
	private Set<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [name=" + name + ", users=" + users + "]";
	}

	//@Override
	//public String getAuthority() {
	//	return name;
	//}
}
