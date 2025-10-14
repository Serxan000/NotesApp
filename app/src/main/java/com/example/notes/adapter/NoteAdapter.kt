package com.example.notes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.databinding.NoteLayoutBinding
import com.example.notes.fragment.HomeFragment
import com.example.notes.fragment.HomeFragmentDirections
import com.example.notes.model.Note

class NoteAdapter:RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    inner class ViewHolder( val binding: NoteLayoutBinding):RecyclerView.ViewHolder(binding.root)

    val differCallBack = object :DiffUtil.ItemCallback<Note>(){
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return newItem == oldItem
        }

    }
    val differ = AsyncListDiffer(this,differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NoteLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = differ.currentList.size


    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        val item  = differ.currentList[position]

        holder.binding.apply {
            noteTitle.text = item.noteTitle
            noteDesc.text = item.noteDesc
        }
        holder.itemView.setOnClickListener {
                val direction = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(item)
                it.findNavController().navigate(direction)
        }
    }
}