package com.ivankljun.pekautomotive.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ivankljun.pekautomotive.data.ApiService
import com.ivankljun.pekautomotive.data.RetrofitModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newCoroutineContext
import kotlinx.coroutines.withContext
import java.net.ConnectException

class FormViewModel : ViewModel() {
    private val apiService: ApiService = RetrofitModule.getInstance().create(ApiService::class.java)

    fun postString(inputString: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                apiService.saveString(inputString)
            } catch (e: ConnectException) {
                Log.d("Error: ", e.localizedMessage)
            }
        }
    }
}