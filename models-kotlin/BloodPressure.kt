package com.healthtracker.models

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class BloodPressure(
    val id: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("test_date")
    val testDate: LocalDateTime,
    @SerializedName("bp_level")
    val bpLevel: Double,
    @SerializedName("image_url")
    val imageUrl: String? = null
) {
    companion object {
        private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

        fun fromJson(json: Map<String, Any?>): BloodPressure {
            return BloodPressure(
                id = json["id"] as Int,
                userId = json["user_id"] as Int,
                testDate = LocalDateTime.parse(json["test_date"] as String, dateFormatter),
                bpLevel = json["bp_level"] as Double,
                imageUrl = json["image_url"] as String?
            )
        }
    }

    fun toJson(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "user_id" to userId,
            "test_date" to testDate.format(dateFormatter),
            "bp_level" to bpLevel,
            "image_url" to imageUrl
        )
    }
}