package com.example.a20230220_ganeshvadlakonda_nycschools.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.a20230220_ganeshvadlakonda_nycschools.R
import com.example.a20230220_ganeshvadlakonda_nycschools.SchoolsViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SchoolDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SchoolDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewModel: SchoolsViewModel
    private var textSchoolDtails: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_school_details, container, false)
        textSchoolDtails = view.findViewById(R.id.txtSchoolDetails)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SchoolsViewModel::class.java)
        GlobalScope.launch {
            var schoolDetails = viewModel.getSchoolDetails()
            textSchoolDtails?.text = schoolDetails
        }
    }

}