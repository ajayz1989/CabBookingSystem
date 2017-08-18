package com.ajay.util;

import java.util.Calendar;

import com.ajay.constants.Constants;
import com.ajay.entity.Area;

/**
 * Utility class for common operations required in the application .
 */
public class Utils {
	
	public static Calendar getFutureTime(int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		return calendar;
	}
	
	public static Integer calculateDistance(Area startPoint, Area endPoint) {
		int travelleddistance = startPoint.getAreaShortId() - endPoint.getAreaShortId();
		return Math.abs(travelleddistance) * Constants.DISTANCE_BETWEEN_AREA ;
	}

}
