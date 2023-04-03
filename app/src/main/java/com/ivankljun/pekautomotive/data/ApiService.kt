package com.ivankljun.pekautomotive.data

import com.ivankljun.pekautomotive.model.SavedStringResponse
import retrofit2.Response
import retrofit2.http.Body;
import retrofit2.http.POST;

interface ApiService {
    @POST("/api/save")
    suspend fun saveString(@Body string: String): Response<SavedStringResponse>
}
