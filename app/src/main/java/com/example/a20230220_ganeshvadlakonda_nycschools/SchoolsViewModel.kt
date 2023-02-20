package com.example.a20230220_ganeshvadlakonda_nycschools

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20230220_ganeshvadlakonda_nycschools.models.School
import com.example.a20230220_ganeshvadlakonda_nycschools.network.SchoolsApi
import kotlinx.coroutines.*

class SchoolsViewModel : ViewModel() {

    val schoolsList: LiveData<List<School>?> = MutableLiveData()

    init {
        viewModelScope.launch {
            schoolsList as MutableLiveData
            val schools = async {
                getSchoolsList()
            }
        }
    }

    suspend fun getSchoolsList() : List<School>?{
        return withContext(Dispatchers.IO){
            SchoolsApi().getSchoolsList().body()
        }
    }

    suspend fun getSchoolDetails() : String? {
        return withContext(Dispatchers.IO){
            SchoolsApi().getSchoolDetails().body()
        }
    }
}