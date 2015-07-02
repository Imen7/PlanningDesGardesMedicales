package com.sifast.stage.modele;

import java.util.Date;
import java.util.HashMap;

public class Preference {

	private HashMap<Date, PrefEnum> mapPerference = new HashMap<Date, PrefEnum>();

    // constructeurs
	
	public Preference() {
		super();
	}

	public Preference(HashMap<Date, PrefEnum> mapPerference) {
		super();
		this.setMapPerference(mapPerference);
	}
	
	// methodes set,get


	public HashMap<Date, PrefEnum> getMapPerference() {
		return mapPerference;
	}

	public void setMapPerference(HashMap<Date, PrefEnum> mapPerference) {
		this.mapPerference = mapPerference;
	}
}
