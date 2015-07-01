package com.sifast.stage.classe;

import java.util.Date;
import java.util.HashMap;


public class Preference {

	private static HashMap<Date, PrefEnum> mapPerference =new HashMap<Date, PrefEnum>();
	
	public static HashMap<Date, PrefEnum>  getMapPerference() {
		return mapPerference;
	}

}
