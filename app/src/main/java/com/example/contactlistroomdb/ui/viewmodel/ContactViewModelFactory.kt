package com.example.contactlistroomdb.ui.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contactlistroomdb.repository.ContactRepository

class ContactViewModelFactory (

    private val app: Application,
    private val repo: ContactRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
                return ContactViewModel(app, repo) as T
            } else {
                throw IllegalArgumentException("instance of Contact ViewModel cannot be created")
            }
        }

    }