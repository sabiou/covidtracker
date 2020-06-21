package dev.farouk.covidtracker.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Farouk on 21/06/20.
 */
data class CovidData(
    @SerializedName("confirmed")
    val confirmed: Int,
    @SerializedName("recovered")
    val recovered: Int,
    @SerializedName("deaths")
    val deaths: Int
)