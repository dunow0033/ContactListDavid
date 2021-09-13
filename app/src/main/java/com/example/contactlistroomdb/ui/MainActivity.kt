package com.example.contactlistroomdb.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlistroomdb.R
import com.example.contactlistroomdb.databinding.ActivityMainBinding
import com.example.contactlistroomdb.db.ContactDatabase
import com.example.contactlistroomdb.model.Contact
import com.example.contactlistroomdb.repository.ContactRepository
import com.example.contactlistroomdb.ui.adapter.ContactAdapter
import com.example.contactlistroomdb.ui.viewmodel.ContactViewModel
import com.example.contactlistroomdb.ui.viewmodel.ContactViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ContactViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
lateinit var contactAdapter:ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}














