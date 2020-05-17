package com.app.pojos;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Roles {
private Integer RoleId;
private Role RoleName;
@JsonIgnore
private List<Users> usrs = new ArrayList<>();

public Roles()
{
	System.out.println("Inside Role constructor !!");
}

public Roles(Role RoleName)
{
	super();
	this.RoleName=RoleName;	
}
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getRoleId() {
	return RoleId;
}

public void setRoleId(Integer roleId) {
	RoleId = roleId;
}

@Column(length = 15)
@Enumerated(EnumType.STRING)
public Role getRoleName() {
	return RoleName;
}

public void setRoleName(Role roleName) {
	RoleName = roleName;
}

@OneToMany(fetch = FetchType.EAGER,mappedBy = "role",cascade = CascadeType.ALL,orphanRemoval = true)
public List<Users> getUsrs() {
return usrs;
}

public void setUsrs(List<Users> usrs) {
	this.usrs = usrs;
}

@Override
public String toString() {
	return "Roles [RoleId=" + RoleId + ", RoleName=" + RoleName + "]";
}


public void adduser(Users u) {
	System.out.println("helper method");
	// add student info in course
	usrs.add(u);
	System.out.println("helper method");
	// add course info to student
	u.setRole(this);
	System.out.println("helper method");
}

}