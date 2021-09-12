package edu.kiet.roomwithkotlin.roomdata

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="User")
data class User (
    @PrimaryKey(autoGenerate = true)
    val uid:Int?,
    val userName:String?,
    val userPhone:String?

        )
