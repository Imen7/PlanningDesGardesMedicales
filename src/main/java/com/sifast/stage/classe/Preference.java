package com.sifast.stage.classe;


public class Preference {
	private String date;
	private PrefEnum prefenum;

	Preference(String date, PrefEnum prefenum) {
		this.setDate(date);
		this.setPrefenum(prefenum);
	}

	public PrefEnum getPrefenum() {
		return prefenum;
	}

	public void setPrefenum(PrefEnum prefenum) {
		this.prefenum = prefenum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
