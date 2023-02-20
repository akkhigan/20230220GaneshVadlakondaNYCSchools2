package com.example.a20230220_ganeshvadlakonda_nycschools.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.a20230220_ganeshvadlakonda_nycschools.databinding.FragmentSchoolsBinding
import com.example.a20230220_ganeshvadlakonda_nycschools.models.School

class SchoolsRecyclerViewAdapter : RecyclerView.Adapter<SchoolsRecyclerViewAdapter.ViewHolder>() {

    var schools: List<School>? = null
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentSchoolsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = schools?.get(position)
    }

    override fun getItemCount() = schools?.size?: 0

    inner class ViewHolder(binding: FragmentSchoolsBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

}