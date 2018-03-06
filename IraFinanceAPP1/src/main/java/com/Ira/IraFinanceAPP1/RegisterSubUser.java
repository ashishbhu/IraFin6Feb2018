package com.Ira.IraFinanceAPP1;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegisterSubUser {
	
	private String mainuser;
	private String subuser;
	private String pass;
	private int access;
	private String substsrtdate;
	private String subenddate;
	
	
	public String getMainuser() {
		return mainuser;
	}
	public void setMainuser(String mainuser) {
		this.mainuser = mainuser;
	}
	public String getSubuser() {
		return subuser;
	}
	public void setSubuser(String subuser) {
		this.subuser = subuser;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getAccess() {
		return access;
	}
	public void setAccess(int access) {
		this.access = access;
	}
	public String getSubstsrtdate() {
		return substsrtdate;
	}
	public void setSubstsrtdate(String substsrtdate) {
		this.substsrtdate = substsrtdate;
	}
	public String getSubenddate() {
		return subenddate;
	}
	public void setSubenddate(String subenddate) {
		this.subenddate = subenddate;
	}
	

	
}
