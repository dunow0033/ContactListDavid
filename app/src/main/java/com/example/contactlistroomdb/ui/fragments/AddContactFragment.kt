package com.example.contactlistroomdb.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.contactlistroomdb.R
import com.example.contactlistroomdb.databinding.FragmentAddcontactsBinding
import com.example.contactlistroomdb.db.ContactDatabase
import com.example.contactlistroomdb.model.Contact
import com.example.contactlistroomdb.repository.ContactRepository
import com.example.contactlistroomdb.ui.viewmodel.ContactViewModel
import com.example.contactlistroomdb.ui.viewmodel.ContactViewModelFactory

class AddContactFragment : Fragment() {


    private var _binding: FragmentAddcontactsBinding? = null
    private val binding: FragmentAddcontactsBinding get() = _binding!!

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
        _binding = FragmentAddcontactsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding) {
            btnAdd.setOnClickListener {
                var name = etName.text.toString()
                var eMail = etEmail.text.toString()
                var phoneNumber = etPhone.text.toString()
                viewModel.addContact(Contact(name = name, email = eMail, phoneNumber = phoneNumber))
                Toast.makeText(context, "Contact added", Toast.LENGTH_SHORT).show()
                etName.setText("")
                etEmail.setText("")
                etPhone.setText("")
            }
        }
    }
}