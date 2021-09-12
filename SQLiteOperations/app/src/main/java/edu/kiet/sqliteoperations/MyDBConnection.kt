package edu.kiet.sqliteoperations

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBConnection (var context: Context,var dbName:String,var dbVersion:Int): SQLiteOpenHelper(context,dbName,null,dbVersion) {
    companion object{
        val tableName:String="LoginInfo"
        val col1:String="Uid"
        val col2:String="Username"
        val col3:String="Password"
    }
    val query:String="create table "+ tableName+" ("+col1+" integer primary key autoincrement,"+col2+" text,"+col3+" text)"
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
       db?.execSQL("drop table if exits "+ tableName)
        db?.execSQL(query)
    }
   fun insert(userName:String, password:String):Long
   {
       val db:SQLiteDatabase=this.writableDatabase
       val contentValues= ContentValues()
       contentValues.put(col2,userName)
       contentValues.put(col3,password)
      val result:Long= db.insert(tableName,null,contentValues)
       return result
   }
    fun display(): Cursor
    {
        val db:SQLiteDatabase=this.readableDatabase
        val cursor:Cursor=db.rawQuery("Select * from "+ tableName,null)
        return cursor
    }
   fun delete(userName:String): Int {
       val db:SQLiteDatabase=this.writableDatabase
       val result=db.delete(tableName,col2+"=?", arrayOf(userName))
       return result
   }
   fun update(userName:String, password:String):Int
   {
       val db:SQLiteDatabase=this.writableDatabase
       val contentValues= ContentValues()
       contentValues.put(col2,userName)
       contentValues.put(col3,password)
       val result= db.update(tableName,contentValues,col2+"=?", arrayOf(userName))
       return result
   }


}