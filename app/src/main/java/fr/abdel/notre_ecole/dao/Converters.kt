package fr.abdel.notre_ecole.dao


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.sql.Date



class Converters {

    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        @TypeConverter
        @JvmStatic
        fun toDate(dateLong: Long): Date {
            return Date(dateLong)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        @TypeConverter
        @JvmStatic
        fun fromDate(date: Date): Long {
            return date.time
        }


    }
}






