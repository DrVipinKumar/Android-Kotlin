package edu.kiet.roomwithkotlin.roomdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities=[User::class],version=1)
abstract class UserDatabase:RoomDatabase (){
    abstract fun userDao():UserDAO
    companion object {
        var INSTANCE:UserDatabase?=null
        fun getInstance(context: Context):UserDatabase
        {
            if(INSTANCE==null)
            {
                INSTANCE= Room.databaseBuilder(
                            context.applicationContext,
                            UserDatabase::class.java,
                            "User.db").build()

            }
            return INSTANCE!!
        }
    }
}