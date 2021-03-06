package com.tool;

import java.io.File;
import java.util.ArrayList;

import com.model.MDataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MDBHelper {
	private SQLiteDatabase 	mDB;		//  数据库件;
    private final int 		NID_DB_VERSION=	3;
	private final String 	SNAME_DB	  =	"myDB.db";
	private int   column;	
	private int   line;

	public MDBHelper(Context mContext) {
		File 	  file 		=	mContext.getFilesDir();
		String 	  path 		= 	file.getAbsolutePath() + "/"+SNAME_DB;
		MDataBase mDBhelper	=	new MDataBase(mContext, path, NID_DB_VERSION);
		this.mDB 			= 	mDBhelper.getReadableDatabase();
	}
	//	数据库操作类;	
	public void oper(String sql){
		mDB.execSQL(sql);
	}
	//	查询结果;
	public ArrayList<String[]> query(String sql){
		column=0;
		line=0;
		ArrayList<String[]> list=new ArrayList<String[]>();
		Cursor mCursor	= 	mDB.rawQuery(sql, null);
		column			=	mCursor.getColumnCount();
		while (mCursor.moveToNext()) {
			String[] arrays	=	new String[column];
			for(int i=0;i<column;i++){
				arrays[i]=mCursor.getString(i);
			}
			list.add(arrays);
			line++;
		}
		if(mCursor!=null){
			mCursor.close();
		}
		return list;
	}
	
	//	查询结果的列数;
	public int getColumn() {
		return column;
	}
	
	//	查询的行数;
	public int getLine() {
		return line;
	}
	
}
