package com.kwon.dlbapm.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SNSReply {
	private BigDecimal dsr_no;
	private BigDecimal dsr_ds_no;
	private String dsr_owner;
	private String dsr_txt;
	private Date dsr_when;
	
	public SNSReply() {
		// TODO Auto-generated constructor stub
	}

	public SNSReply(BigDecimal dsr_no, BigDecimal dsr_ds_no, String dsr_owner, String dsr_txt, Date dsr_when) {
		super();
		this.dsr_no = dsr_no;
		this.dsr_ds_no = dsr_ds_no;
		this.dsr_owner = dsr_owner;
		this.dsr_txt = dsr_txt;
		this.dsr_when = dsr_when;
	}

	public BigDecimal getDsr_no() {
		return dsr_no;
	}

	public void setDsr_no(BigDecimal dsr_no) {
		this.dsr_no = dsr_no;
	}

	public BigDecimal getDsr_ds_no() {
		return dsr_ds_no;
	}

	public void setDsr_ds_no(BigDecimal dsr_ds_no) {
		this.dsr_ds_no = dsr_ds_no;
	}

	public String getDsr_owner() {
		return dsr_owner;
	}

	public void setDsr_owner(String dsr_owner) {
		this.dsr_owner = dsr_owner;
	}

	public String getDsr_txt() {
		return dsr_txt;
	}

	public void setDsr_txt(String dsr_txt) {
		this.dsr_txt = dsr_txt;
	}

	public Date getDsr_when() {
		return dsr_when;
	}

	public void setDsr_when(Date dsr_when) {
		this.dsr_when = dsr_when;
	}
	
}
