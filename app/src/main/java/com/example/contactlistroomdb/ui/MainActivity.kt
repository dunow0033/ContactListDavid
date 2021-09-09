package com.example.contactlistroomdb.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactlistroomdb.databinding.ActivityMainBinding
import com.example.contactlistroomdb.db.ContactDatabase
import com.example.contactlistroomdb.model.Contact
import com.example.contactlistroomdb.repository.ContactRepository
import com.example.contactlistroomdb.ui.adapter.ContactAdapter
import com.example.contactlistroomdb.ui.viewmodel.ContactViewModel
import com.example.contactlistroomdb.ui.viewmodel.ContactViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var contactAdapter: ContactAdapter


    val viewModel: ContactViewModel by viewModels {
        ContactViewModelFactory(
            this.application,
            ContactRepository(ContactDatabase(this))
        )

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()


        binding.btnAddContact.setOnClickListener {
            with(binding) {
                var name = etName.text.toString()
                var number = etNumber.text.toString()
                viewModel.addContact(Contact(name = name, phoneNumber = number))

                etName.setText("")
               etNumber.setText("Juan")

                //myArray.add(contact)
                //contactAdapter.differ.submitList(myArray)
                //contactAdapter.notifyItemInserted(myArray.size - 1)

                //Toast.makeText(this@MainActivity, "Number added", Toast.LENGTH_SHORT).show()
                //etName.text.clear()
                //etNumber.text.clear()
                //viewModel = ViewModelProvider(this@MainActivity).get(ContactViewModel::class.java)


                viewModel.contactInfo.observe(this@MainActivity, Observer {
                    contactAdapter.differ.submitList(it)
                    Toast.makeText(this@MainActivity, "Number added", Toast.LENGTH_SHORT).show()

                })
            }
        }
    }


    private fun setupRecyclerView() = binding.rvContacts.apply {
        contactAdapter = ContactAdapter()
        adapter = contactAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }

}















