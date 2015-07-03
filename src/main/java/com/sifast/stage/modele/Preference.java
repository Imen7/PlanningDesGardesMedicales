package com.sifast.stage.modele;

import java.util.Date;

public class Preference {
	private Date date;
	private PrefEnum prefenum;

	// Constructeur
	Preference(Date date, PrefEnum prefenum) {
		this.date = date;
		this.prefenum = prefenum;
	}

	public Preference() {
	}

	// set,get

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PrefEnum getPrefenum() {
		return prefenum;
	}

	public void setPrefenum(PrefEnum prefenum) {
		this.prefenum = prefenum;
	}
	
	
	
}
