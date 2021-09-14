package com.example.contactlistroomdb.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlistroomdb.R
import com.example.contactlistroomdb.databinding.FragmentDisplaycontactsBinding
import com.example.contactlistroomdb.db.ContactDatabase
import com.example.contactlistroomdb.repository.ContactRepository
import com.example.contactlistroomdb.ui.adapter.ContactAdapter
import com.example.contactlistroomdb.ui.viewmodel.ContactViewModel
import com.example.contactlistroomdb.ui.viewmodel.ContactViewModelFactory
import com.example.contactlistroomdb.utils.SwipeToDelete

class DisplayContactsFragment : Fragment() {
    private var _binding: FragmentDisplaycontactsBinding? = null
    private val binding: FragmentDisplaycontactsBinding get() = _binding!!
    private lateinit var contactAdapter: ContactAdapter

    val viewModel: ContactViewModel by viewModels {
        ContactViewModelFactory(
            requireActivity().application,
            ContactRepository(ContactDatabase(requireActivity()))
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDisplaycontactsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        viewModel.contactInfo.observe(viewLifecycleOwner, Observer {
            contactAdapter.differ.submitList(it)
        })

        binding.btnNext.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_displayContactsFragment_to_addContactFragment)
        }

        var itemTouchHelper = ItemTouchHelper(SwipeToDelete(contactAdapter,viewModel,view))
        itemTouchHelper.attachToRecyclerView(binding.rvContacts)


    }


    private fun setupRecyclerView() = binding.rvContacts.apply {
        contactAdapter = ContactAdapter()
        adapter = contactAdapter
        layoutManager = LinearLayoutManager(context)

        addItemDecoration(DividerItemDecoration(context, LinearLayoutManager(context).orientation))

    }

}


