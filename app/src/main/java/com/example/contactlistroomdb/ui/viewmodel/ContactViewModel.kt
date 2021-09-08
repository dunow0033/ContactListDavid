package com.example.contactlistroomdb.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactlistroomdb.model.Contact

class ContactViewModel : ViewModel() {
    lateinit var contactList: MutableList<Contact>
    private var _contactInfo: MutableLiveData<MutableList<Contact>> = MutableLiveData()
    val contactInfo: LiveData<MutableList<Contact>> get() = _contactInfo


    fun addData(contact: Contact) {
        contact?.let {
            contactList.add(it)
            _contactInfo.postValue(contactList)
        }
    }


}