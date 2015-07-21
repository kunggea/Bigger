package com.kunggea.bigger.util;

import android.annotation.SuppressLint;

import com.android.common.util.CMLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static final String TAG = "DateUtil";

	public static String calendarToString(Calendar paramCalendar,
			String paramString) {
		return dateToString(paramCalendar.getTime(), paramString);
	}

	public static String dateFormat(String paramString1, String paramString2,
			String paramString3) {
		Date localDate = stringToDate(paramString1, paramString2);
		if (localDate != null)
			return dateToString(localDate, paramString3);
		return "";
	}

	public static long dateStrTomillisecond(String paramString1,
			String paramString2) {
		Date localDate = stringToDate(paramString1, paramString2);
		if (localDate != null)
			return localDate.getTime();
		return 0L;
	}

	@SuppressLint({ "SimpleDateFormat" })
	public static String dateToString(Date paramDate, String paramString) {
		return new SimpleDateFormat(paramString).format(paramDate);
	}

	public static String getNowDateLong() {
		return dateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	public static String getNowDateShort() {
		return dateToString(new Date(), "yyyy-MM-dd");
	}

	public static String getNowTimeShort() {
		return dateToString(new Date(), "HH:mm");
	}

	public static String getNumAndZero(int paramInt) {
		if (paramInt > 9)
			return paramInt + "";
		return "0" + paramInt;
	}

	public static String getTimeByRefresh(long paramLong1, long paramLong2) {
		return getTimeState(paramLong1, paramLong2, "上次更新：");
	}

	public static String getTimeState(long paramLong1, long paramLong2,
			String paramString) {
		if (paramLong1 == 0L)
			return "未刷新";
		if (paramLong2 == 0L)
			return "时间错误";
		Object localObject = "";
		long l = paramLong2 - paramLong1;
		if (l < 60000L) {
			localObject = "刚刚";
			return paramString + (String) localObject;
		}
		
		return paramString;
//		while (true) {
//
//			if (l < 1800000L) {
//				try {
//					localObject = l / 1000L / 60L + "分钟前";
//					continue;
//					Calendar localCalendar1 = Calendar.getInstance();
//					localCalendar1.setTimeInMillis(paramLong2);
//					Calendar localCalendar2 = Calendar.getInstance();
//					localCalendar2.setTimeInMillis(paramLong1);
//					if (localCalendar2.get(1) == localCalendar1.get(1)) {
//						if (localCalendar2.get(2) == localCalendar1.get(2)) {
//							if (localCalendar2.get(5) == localCalendar1.get(5))
//								localObject = dateToString(
//										localCalendar2.getTime(), "今天 HH:mm");
//							else if (localCalendar2.get(5) == -1
//									+ localCalendar1.get(5))
//								localObject = dateToString(
//										localCalendar2.getTime(), "昨天 HH:mm");
//							else
//								localObject = dateToString(
//										localCalendar2.getTime(),
//										"M月d日 HH:mm:ss");
//						} else
//							localObject = dateToString(
//									localCalendar2.getTime(), "M月d日 HH:mm:ss");
//					} else {
//						String str = dateToString(localCalendar2.getTime(),
//								"yyyy年M月d日 HH:mm:ss");
//						localObject = str;
//					}
//				} catch (Exception localException) {
//				}
//			}
//		}

	}

	public static int getWeekNum(Date paramDate) {
		Calendar localCalendar = Calendar.getInstance();
		localCalendar.setTime(paramDate);
		return localCalendar.get(7);
	}

	public static String getWeekStr(int paramInt) {
		switch (paramInt) {
		default:
			return "";
		case 1:
			return "星期日";
		case 2:
			return "星期一";
		case 3:
			return "星期二";
		case 4:
			return "星期三";
		case 5:
			return "星期四";
		case 6:
			return "星期五";
		case 7:
		}
		return "星期六";
	}

	public static long millisecondToTimestamp(long paramLong) {
		return paramLong / 1000L;
	}

	public static String millisecondTodateStr(long paramLong, String paramString) {
		return dateToString(new Date(paramLong), paramString);
	}

	public static Calendar stringToCalendar(String paramString1,
			String paramString2) {
		Calendar localCalendar = Calendar.getInstance();
		Date localDate = stringToDate(paramString1, paramString2);
		if (localDate != null)
			localCalendar.setTime(localDate);
		return localCalendar;
	}

	@SuppressLint({ "SimpleDateFormat" })
	public static Date stringToDate(String paramString1, String paramString2) {
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(
				paramString2);
		try {
			Date localDate = localSimpleDateFormat.parse(paramString1);
			return localDate;
		} catch (ParseException localParseException) {
			CMLog.i("DateUtil-stringToDate-ParseException-e>"
					+ localParseException.getMessage());
		}
		return null;
	}

	@SuppressLint({ "UseValueOf" })
	public static long timestampToMillisecond(long paramLong) {
		return new Long(1000L * paramLong).longValue();
	}
}

/*
 * Location: /Users/lk/Desktop/huoshiClasses_dex2jar.jar Qualified Name:
 * com.flint.applib.util.DateUtil JD-Core Version: 0.6.2
 */