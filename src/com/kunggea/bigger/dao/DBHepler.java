package com.kunggea.bigger.dao;

import com.android.common.util.CMLog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

public class DBHepler extends SQLiteOpenHelper {
	private static final String TAG = "DBHepler";
	private static DBHepler dbHelper;

	public DBHepler(Context paramContext) {
		super(paramContext, DBData.DATABASE_NAME, null, 1);
	}

	public static DBHepler getInstance(Context paramContext) {
		try {
			if (dbHelper == null)
				dbHelper = new DBHepler(paramContext);
			DBHepler localDBHepler = dbHelper;
			return localDBHepler;
		} finally {
		}
	}

	public long add(String paramString, ContentValues paramContentValues) {
		if ((paramContentValues == null) || (paramContentValues.size() == 0))
			return -1L;
		return getWritableDatabase().insert(paramString, null,
				paramContentValues);
	}

	public int delete(String paramString1, String paramString2,
			String[] paramArrayOfString) {
		return getWritableDatabase().delete(paramString1, paramString2,
				paramArrayOfString);
	}

	public boolean executeSQl(String paramString) {
		try {
			getWritableDatabase().execSQL(paramString);
			return true;
		} catch (SQLException localSQLException) {
			CMLog.i("DBHepler-executeSQl-SQLException-e>"
					+ localSQLException.getMessage());
		}
		return false;
	}

	protected void finalize() throws Throwable {
		if (dbHelper != null) {
			dbHelper.close();
			dbHelper = null;
		}
		super.finalize();
	}

	public int getCount(String paramString1, String paramString2,
			String[] paramArrayOfString) {
		String str = "SELECT COUNT(*) FROM " + paramString1;
		if (!TextUtils.isEmpty(paramString2))
			str = str + " WHERE " + paramString2;
		return getCount(str, paramArrayOfString);
	}

	public int getCount(String paramString, String[] paramArrayOfString) {
		int i = -1;
		Cursor localCursor = getWritableDatabase().rawQuery(paramString,
				paramArrayOfString);
		if (localCursor.moveToNext())
			i = localCursor.getInt(0);
		localCursor.close();
		return i;
	}

	public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
		paramSQLiteDatabase
				.execSQL("CREATE TABLE t_inforeader(id INTEGER PRIMARY KEY AUTOINCREMENT,infoid INTEGER,flag INTEGER,type INTEGER,addtime VARCHAR(20))");
		paramSQLiteDatabase
				.execSQL("CREATE TABLE t_refreshdate(id INTEGER PRIMARY KEY AUTOINCREMENT,flag INTEGER,type VARCHAR(20),date VARCHAR(20))");
	}

	public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1,
			int paramInt2) {
		paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_inforeader");
		paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_refreshdate");
	}

	public Cursor query(String paramString1, String[] paramArrayOfString1,
			String paramString2, String[] paramArrayOfString2,
			String paramString3) {
		return getWritableDatabase().query(paramString1, paramArrayOfString1,
				paramString2, paramArrayOfString2, null, null, paramString3);
	}

	public Cursor queryBySingle(String paramString1, String paramString2,
			String[] paramArrayOfString) {
		String str = "SELECT * FROM " + paramString1;
		if (!TextUtils.isEmpty(paramString2))
			str = str + " WHERE " + paramString2;
		return getWritableDatabase().rawQuery(str, paramArrayOfString);
	}

	public Cursor queryBySingle(String paramString, String[] paramArrayOfString) {
		return getWritableDatabase().rawQuery(paramString, paramArrayOfString);
	}

	public Cursor queryBySingle(String paramString1,
			String[] paramArrayOfString1, String paramString2,
			String[] paramArrayOfString2) {
		return query(paramString1, paramArrayOfString1, paramString2,
				paramArrayOfString2, null);
	}

	public int update(String paramString1, ContentValues paramContentValues,
			String paramString2, String[] paramArrayOfString) {
		return getWritableDatabase().update(paramString1, paramContentValues,
				paramString2, paramArrayOfString);
	}
}
