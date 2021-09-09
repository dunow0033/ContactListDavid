package com.example.contactlistroomdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactlistroomdb.model.Contact
import com.example.contactlistroomdb.utils.DB_NAME


@Database(
    entities = [Contact::class],
    version = 1,
    exportSchema = false
)

abstract class ContactDatabase : RoomDatabase() {

    abstract fun getContactDao() : ContactDao

    companion object {
        @Volatile
        private var instance: ContactDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ContactDatabase::class.java,
                DB_NAME
            ).build()


    }


}