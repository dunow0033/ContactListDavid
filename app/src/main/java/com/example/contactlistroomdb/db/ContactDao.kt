package com.example.contactlistroomdb.db

import androidx.room.*
import com.example.contactlistroomdb.model.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addContact(contact: Contact)

    @Query("SELECT * FROM contact_table")
    fun readAllContacts(): Flow<List<Contact>>

    @Delete
    suspend fun deleteContact(contact: Contact)


}