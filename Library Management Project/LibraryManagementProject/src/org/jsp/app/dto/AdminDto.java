package org.jsp.app.dto;

public class AdminDto 
{
	private String name;
	private String id;
	private String email;
	private String mobile;
	private String password;
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getMobile() 
	{
		return mobile;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	@Override
	public String toString() 
	{
		return "AdminDto [name=" + name + ", id=" + id + ", email=" + email + ", mobile=" + mobile + ", password="
				+ password + "]";
	}
}
