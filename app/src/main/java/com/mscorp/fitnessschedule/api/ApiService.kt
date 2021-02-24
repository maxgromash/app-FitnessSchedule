package com.mscorp.fitnessschedule.api

import com.mscorp.fitnessschedule.Training
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("schedule/get_group_lessons_v2/1/")
    suspend fun getData(): Response<List<Training>>
}