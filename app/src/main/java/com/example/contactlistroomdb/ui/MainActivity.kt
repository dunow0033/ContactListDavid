package com.example.contactlistroomdb.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactlistroomdb.databinding.ActivityMainBinding
import com.example.contactlistroomdb.model.Contact
import com.example.contactlistroomdb.ui.adapter.ContactAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var contactAdapter: ContactAdapter
    private var myArray = mutableListOf<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()


        binding.btnAddContact.setOnClickListener {
            with(binding) {
                var name = etName.text.toString()
                var number = etNumber.text.toString()
                val contact = Contact(name, number)
                myArray.add(contact)
                contactAdapter.differ.submitList(myArray)
                contactAdapter.notifyItemInserted(myArray.size - 1)

                Toast.makeText(this@MainActivity, "Number added", Toast.LENGTH_SHORT).show()
                etName.text.clear()
                etNumber.text.clear()
            }
        }
    }

    private fun setupRecyclerView() = binding.rvContacts.apply {
        contactAdapter = ContactAdapter()
        adapter = contactAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }

}















