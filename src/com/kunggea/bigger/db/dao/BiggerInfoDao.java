package com.kunggea.bigger.db.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.kunggea.bigger.db.DBHepler;
import com.kunggea.bigger.info.BiggerInfo;

public class BiggerInfoDao {
    private DBHepler dbHpler = null;

    public BiggerInfoDao(Context paramContext) {
        dbHpler = DBHepler.getInstance(paramContext);
    }

    public long add(BiggerInfo paramBiggerInfo) {
        SQLiteDatabase localSQLiteDatabase = dbHpler.getWritableDatabase();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("title", paramBiggerInfo.title);
        // localContentValues.put("flag",
        // Integer.valueOf(paramBiggerInfo.getFlag()));
        // localContentValues.put("infoid",
        // Integer.valueOf(paramBiggerInfo.getInfoid()));
        // localContentValues.put("type",
        // Integer.valueOf(paramBiggerInfo.getType()));
        // localContentValues.put("addtime", DateUtil.getNowDateLong());
        return localSQLiteDatabase.insert("t_BiggerInfo", "flag", localContentValues);
    }

    public int delete() {
        return dbHpler.getWritableDatabase().delete("t_BiggerInfo",
                " infoid IN(SELECT infoid FROM t_BiggerInfo ORDER BY id LIMIT 0,100) ", null);
    }

    public int delete(int paramInt) {
        SQLiteDatabase localSQLiteDatabase = dbHpler.getWritableDatabase();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = String.valueOf(paramInt);
        return localSQLiteDatabase.delete("t_BiggerInfo", "id=?", arrayOfString);
    }

    public void delete(int paramInt1, int paramInt2) {
    }

    public int delete(int[] paramArrayOfInt) {
        int i = 0;
        int j = 0;
        SQLiteDatabase localSQLiteDatabase = dbHpler.getWritableDatabase();
        localSQLiteDatabase.beginTransaction();
        try {
            int k = paramArrayOfInt.length;
            while (true) {
                if (i >= k) {
                    localSQLiteDatabase.setTransactionSuccessful();
                    return j;
                }
                int m = paramArrayOfInt[i];
                String[] arrayOfString = new String[1];
                arrayOfString[0] = String.valueOf(m);
                int n = localSQLiteDatabase.delete("t_BiggerInfo", "id=?", arrayOfString);
                j += n;
                i++;
            }
        } catch (Exception localException) {
            return j;
        } finally {
            localSQLiteDatabase.endTransaction();
        }
    }

    public int getCount() {
        Cursor localCursor = dbHpler.getReadableDatabase().rawQuery(
                "SELECT COUNT(*) FROM t_BiggerInfo", null);
        boolean bool = localCursor.moveToNext();
        int i = 0;
        if (bool) {
            i = localCursor.getInt(0);
        }
        localCursor.close();
        return i;
    }

    public boolean isExist(int paramInt1, int paramInt2) {
        int i = -1;
        SQLiteDatabase localSQLiteDatabase = dbHpler.getWritableDatabase();
        String[] arrayOfString = new String[2];
        arrayOfString[0] = String.valueOf(paramInt1);
        arrayOfString[1] = String.valueOf(paramInt2);
        Cursor localCursor = localSQLiteDatabase.rawQuery(
                "SELECT COUNT(*) FROM t_BiggerInfo WHERE infoid=? AND flag=?", arrayOfString);
        if (localCursor.moveToNext()) {
            i = localCursor.getInt(0);
        }
        localCursor.close();
        return i > 0;
    }

    public boolean isOver() {
        return getCount() > 1000;
    }

    @SuppressWarnings("unchecked")
    public List<BiggerInfo> searchAll() {
        ArrayList localArrayList = new ArrayList();
        Cursor localCursor = dbHpler.getWritableDatabase().rawQuery(
                "SELECT * FROM t_BiggerInfo ORDER BY id DESC", null);
        while (localCursor.moveToNext()) {
            BiggerInfo localBiggerInfo = new BiggerInfo();
            localBiggerInfo.title = localCursor.getString(localCursor.getColumnIndex("title"));

            // localBiggerInfo.setId(localCursor.getInt(localCursor
            // .getColumnIndex("id")));
            // localBiggerInfo.setInfoid(localCursor.getInt(localCursor
            // .getColumnIndex("infoid")));
            // localBiggerInfo.setFlag(localCursor.getInt(localCursor
            // .getColumnIndex("flag")));
            // localBiggerInfo.setType(localCursor.getInt(localCursor
            // .getColumnIndex("type")));
            // localBiggerInfo.setAddtime(localCursor.getString(localCursor
            // .getColumnIndex("addtime")));
            localArrayList.add(localBiggerInfo);
        }

        localCursor.close();
        return localArrayList;
    }

    // decode from jd [:
    public String searchAll(int paramInt1, int paramInt2) {
        StringBuffer localStringBuffer = new StringBuffer();
        String[] arrayOfString = null;
        String str = null;
        Cursor localCursor = null;

        if ((paramInt1 != -1) && (paramInt2 == -1)) {
            arrayOfString = new String[1];
            arrayOfString[0] = String.valueOf(paramInt1);
            str = "flag=?";
        } else if ((paramInt2 != -1) && (paramInt1 == -1)) {
            arrayOfString = new String[1];
            arrayOfString[0] = String.valueOf(paramInt2);
            str = "type=?";
        } else if (paramInt1 == -1) {
            arrayOfString = null;
            str = null;
        } else if (paramInt2 == -1) {
            arrayOfString = new String[2];
            arrayOfString[0] = String.valueOf(paramInt1);
            arrayOfString[1] = String.valueOf(paramInt2);
            str = "flag=? AND type=?";
        }

        if ((arrayOfString != null) && (str != null)) {
            localCursor = dbHpler.getWritableDatabase().rawQuery(
                    "SELECT * FROM t_inforeader WHERE " + str + " ORDER BY " + "id" + " DESC",
                    arrayOfString);
            while (localCursor.moveToNext()) {
                localStringBuffer.append("#")
                        .append(localCursor.getInt(localCursor.getColumnIndex("infoid")))
                        .append("#");
            }
        }
        localCursor.close();
        return localStringBuffer.toString();
    }

}
