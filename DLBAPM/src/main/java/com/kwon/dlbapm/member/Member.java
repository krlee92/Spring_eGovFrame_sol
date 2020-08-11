package com.kwon.dlbapm.member;

public class Member {
	private String dm_id;
	private String dm_pw;
	private String dm_name;
	private String dm_addr;
	private String dm_photo;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String dm_id, String dm_pw, String dm_name, String dm_addr, String dm_photo) {
		super();
		this.dm_id = dm_id;
		this.dm_pw = dm_pw;
		this.dm_name = dm_name;
		this.dm_addr = dm_addr;
		this.dm_photo = dm_photo;
	}

	public String getDm_id() {
		return dm_id;
	}

	public void setDm_id(String dm_id) {
		this.dm_id = dm_id;
	}

	public String getDm_pw() {
		return dm_pw;
	}

	public void setDm_pw(String dm_pw) {
		this.dm_pw = dm_pw;
	}

	public String getDm_name() {
		return dm_name;
	}

	public void setDm_name(String dm_name) {
		this.dm_name = dm_name;
	}

	public String getDm_addr() {
		return dm_addr;
	}

	public void setDm_addr(String dm_addr) {
		this.dm_addr = dm_addr;
	}

	public String getDm_photo() {
		return dm_photo;
	}

	public void setDm_photo(String dm_photo) {
		this.dm_photo = dm_photo;
	}

}
