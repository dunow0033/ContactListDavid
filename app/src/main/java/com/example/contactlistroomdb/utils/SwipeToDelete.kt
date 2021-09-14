package com.example.contactlistroomdb.utils

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlistroomdb.ui.adapter.ContactAdapter
import com.example.contactlistroomdb.ui.viewmodel.ContactViewModel
import com.google.android.material.snackbar.Snackbar

class SwipeToDelete(var adapter: ContactAdapter, var viewModel: ContactViewModel, var view: View) :
    ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        var position = viewHolder.absoluteAdapterPosition
        val contact = adapter.differ.currentList[position]
        viewModel.deleteContact(contact)
        Snackbar.make(view, "Contact Deleted", Snackbar.LENGTH_LONG).apply {
            setAction("Undo") {
                viewModel.addContact(contact)
            }
            show()
        }

    }
}