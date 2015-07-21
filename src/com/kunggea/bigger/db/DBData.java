package com.kunggea.bigger.db;

import com.kunggea.bigger.base.BiggerApplication;

public class DBData {
	public static final int CACHE_CLEARCOUNT_INFOREAD = 100;
	public static final int CACHE_CLEARCOUNT_REFRESHDATE = 100;
	public static final int CACHE_COUNT_INFOREAD = 1000;
	public static final int CACHE_COUNT_REFRESHDATE = 1000;
	// public static final String DATABASE_NAME = MainApp.getPagename() + ".db";
	public static final String DATABASE_NAME = BiggerApplication.getInstance()
			.getPackageName() + ".db";
	public static final String INFOREADER_ADDTIME = "addtime";
	public static final String INFOREADER_FLAG = "flag";
	public static final String INFOREADER_ID = "id";
	public static final String INFOREADER_INFOID = "infoid";
	public static final String INFOREADER_TABLENAME = "t_inforeader";
	public static final String INFOREADER_TYPE = "type";
	public static final String REFRESHDATE_DATE = "date";
	public static final String REFRESHDATE_FLAG = "flag";
	public static final String REFRESHDATE_ID = "id";
	public static final String REFRESHDATE_TABLENAME = "t_refreshdate";
	public static final String REFRESHDATE_TYPE = "type";
	public static final int VERSION = 1;
}
