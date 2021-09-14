package com.example.contactlistroomdb.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.contactlistroomdb.model.Contact
import com.example.contactlistroomdb.repository.ContactRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ContactViewModel(app: Application, private val repo: ContactRepository) :
    AndroidViewModel(app) {


    private var _contactInfo: MutableLiveData<List<Contact>> = MutableLiveData()
    val contactInfo: LiveData<List<Contact>> = _contactInfo


    init {
        getAllTodos()
    }


    private fun getAllTodos() {
        viewModelScope.launch {
            repo.readAllContacts.collect {
                _contactInfo.postValue(it)
            }
        }
    }

    fun addContact(contact: Contact) {
        viewModelScope.launch {
            repo.addContact(contact)
        }
    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch {
            repo.deleteContact(contact)
        }

    }


}