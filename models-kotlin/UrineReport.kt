package com.healthtracker.models

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class UrineReport(
    val id: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("test_date")
    val testDate: LocalDateTime,
    val color: String,
    val appearance: String,
    val protein: String,
    val sugar: String,
    @SerializedName("specific_gravity")
    val specificGravity: Double,
    @SerializedName("image_url")
    val imageUrl: String? = null
) {
    companion object {
        private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

        fun fromJson(json: Map<String, Any?>): UrineReport {
            return UrineReport(
                id = json["id"] as Int,
                userId = json["user_id"] as Int,
                testDate = LocalDateTime.parse(json["test_date"] as String, dateFormatter),
                color = json["color"] as String,
                appearance = json["appearance"] as String,
                protein = json["protein"] as String,
                sugar = json["sugar"] as String,
                specificGravity = json["specific_gravity"] as Double,
                imageUrl = json["image_url"] as String?
            )
        }
    }

    fun toJson(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "user_id" to userId,
            "test_date" to testDate.format(dateFormatter),
            "color" to color,
            "appearance" to appearance,
            "protein" to protein,
            "sugar" to sugar,
            "specific_gravity" to specificGravity,
            "image_url" to imageUrl
        )
    }
}