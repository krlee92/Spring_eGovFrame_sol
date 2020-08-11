package com.kwon.dlbapm.gallery;

import java.math.BigDecimal;

public class GalleryFile {
	private BigDecimal dg_no;
	private String dg_owner;
	private String dg_title;
	private String dg_file;

	public GalleryFile() {
		// TODO Auto-generated constructor stub
	}

	public GalleryFile(BigDecimal dg_no, String dg_owner, String dg_title, String dg_file) {
		super();
		this.dg_no = dg_no;
		this.dg_owner = dg_owner;
		this.dg_title = dg_title;
		this.dg_file = dg_file;
	}

	public BigDecimal getDg_no() {
		return dg_no;
	}

	public void setDg_no(BigDecimal dg_no) {
		this.dg_no = dg_no;
	}

	public String getDg_owner() {
		return dg_owner;
	}

	public void setDg_owner(String dg_owner) {
		this.dg_owner = dg_owner;
	}

	public String getDg_title() {
		return dg_title;
	}

	public void setDg_title(String dg_title) {
		this.dg_title = dg_title;
	}

	public String getDg_file() {
		return dg_file;
	}

	public void setDg_file(String dg_file) {
		this.dg_file = dg_file;
	}

}
