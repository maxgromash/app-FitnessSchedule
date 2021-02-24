package com.mscorp.fitnessschedule

import com.google.gson.annotations.SerializedName

data class Training(
    @SerializedName("description")
    val description: String,
    @SerializedName("endTime")
    val endTime: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("place")
    val place: String,
    @SerializedName("startTime")
    val startTime: String,
    @SerializedName("teacher")
    val teacher: String,
    @SerializedName("weekDay")
    val weekDay: Int
)
