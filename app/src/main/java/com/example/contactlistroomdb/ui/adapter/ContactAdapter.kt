package com.example.contactlistroomdb.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlistroomdb.R
import com.example.contactlistroomdb.databinding.ItemContactBinding
import com.example.contactlistroomdb.model.Contact

class ContactAdapter() : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {


    inner class ContactViewHolder(val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root)


    private val differCallback = object : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.phoneNumber == newItem.phoneNumber
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer<Contact>(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            ItemContactBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = differ.currentList[position]
        holder.binding.apply {
            tvName.text = contact.name
            tvEmail.text = contact.email
            tvNumber.text = contact.phoneNumber
        }
    }


}