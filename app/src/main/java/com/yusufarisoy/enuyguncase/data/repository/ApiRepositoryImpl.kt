package com.yusufarisoy.enuyguncase.data.repository

import android.content.Context
import com.google.gson.Gson
import com.yusufarisoy.enuyguncase.data.entity.Data
import com.yusufarisoy.enuyguncase.data.entity.Response
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ApiRepository {

    // Mock response with local file
    override suspend fun search(): Data {
        val jsonString = context.assets.open(MOCK_FILE_NAME).bufferedReader().use { it.readText() }
        val gson = Gson()
        val response = gson.fromJson(jsonString, Response::class.java)

        return response.data
    }

    companion object {
        private const val MOCK_FILE_NAME = "enuygun_flight_search.json"
    }
}
