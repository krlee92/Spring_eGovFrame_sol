package com.kwon.dlbapm.dr;

import java.math.BigDecimal;
import java.util.Date;

public class DRFile {
	private BigDecimal dd_no;
	private String dd_owner;
	private String dd_title;
	private String dd_cate;
	private String dd_file;
	private Date dd_when;

	public DRFile() {
		// TODO Auto-generated constructor stub
	}

	public DRFile(BigDecimal dd_no, String dd_owner, String dd_title, String dd_cate, String dd_file, Date dd_when) {
		super();
		this.dd_no = dd_no;
		this.dd_owner = dd_owner;
		this.dd_title = dd_title;
		this.dd_cate = dd_cate;
		this.dd_file = dd_file;
		this.dd_when = dd_when;
	}

	public BigDecimal getDd_no() {
		return dd_no;
	}

	public void setDd_no(BigDecimal dd_no) {
		this.dd_no = dd_no;
	}

	public String getDd_owner() {
		return dd_owner;
	}

	public void setDd_owner(String dd_owner) {
		this.dd_owner = dd_owner;
	}

	public String getDd_title() {
		return dd_title;
	}

	public void setDd_title(String dd_title) {
		this.dd_title = dd_title;
	}

	public String getDd_cate() {
		return dd_cate;
	}

	public void setDd_cate(String dd_cate) {
		this.dd_cate = dd_cate;
	}

	public String getDd_file() {
		return dd_file;
	}

	public void setDd_file(String dd_file) {
		this.dd_file = dd_file;
	}

	public Date getDd_when() {
		return dd_when;
	}

	public void setDd_when(Date dd_when) {
		this.dd_when = dd_when;
	}

}
