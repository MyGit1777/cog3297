package com.patientservice.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidatorUsingDateFormat {
	private String dateFormat;

	public DateValidatorUsingDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public boolean isValid(String dateStr) {
		DateFormat sdf = new SimpleDateFormat(this.dateFormat);
		sdf.setLenient(false);
		try {
			sdf.parse(dateStr);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	public boolean isBeforeSystemDate(String dateStr) {
		DateFormat sdf = new SimpleDateFormat(this.dateFormat);
		boolean compareDateFlag = false;
		try {
			Date date = sdf.parse(dateStr);
			Date today = new Date();
			if (date.compareTo(today) < 0)
				compareDateFlag = true;

		} catch (ParseException e1) {

			e1.printStackTrace();
		}

		return true && compareDateFlag;
	}
}