package com.kwon.dlbapm.sns;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//프사, ID, 날짜, 내용, 색깔, 글번호 그리고 댓글들..

//JavaBean, DTO, POJO : JOIN시킬거 생각해서
public class SNSMsg {
	private String dm_photo;
	private String dm_id;
	
	private Date ds_when;
	private String ds_txt;
	private String ds_color;
	private BigDecimal ds_no;
	
	private List<SNSReply> reply; // 댓글들
	
	public SNSMsg() {
		// TODO Auto-generated constructor stub
	}

	public SNSMsg(String dm_photo, String dm_id, Date ds_when, String ds_txt, String ds_color, BigDecimal ds_no,
			List<SNSReply> reply) {
		super();
		this.dm_photo = dm_photo;
		this.dm_id = dm_id;
		this.ds_when = ds_when;
		this.ds_txt = ds_txt;
		this.ds_color = ds_color;
		this.ds_no = ds_no;
		this.reply = reply;
	}

	public String getDm_photo() {
		return dm_photo;
	}

	public void setDm_photo(String dm_photo) {
		this.dm_photo = dm_photo;
	}

	public String getDm_id() {
		return dm_id;
	}

	public void setDm_id(String dm_id) {
		this.dm_id = dm_id;
	}

	public Date getDs_when() {
		return ds_when;
	}

	public void setDs_when(Date ds_when) {
		this.ds_when = ds_when;
	}

	public String getDs_txt() {
		return ds_txt;
	}

	public void setDs_txt(String ds_txt) {
		this.ds_txt = ds_txt;
	}

	public String getDs_color() {
		return ds_color;
	}

	public void setDs_color(String ds_color) {
		this.ds_color = ds_color;
	}

	public BigDecimal getDs_no() {
		return ds_no;
	}

	public void setDs_no(BigDecimal ds_no) {
		this.ds_no = ds_no;
	}

	public List<SNSReply> getReply() {
		return reply;
	}

	public void setReply(List<SNSReply> reply) {
		this.reply = reply;
	}
	
	
	
}
