package com.healthtracker.models

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class FBS(
    val id: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("test_date")
    val testDate: LocalDateTime,
    @SerializedName("fbs_level")
    val fbsLevel: Double,
    @SerializedName("image_url")
    val imageUrl: String? = null
) {
    companion object {
        private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

        fun fromJson(json: Map<String, Any?>): FBS {
            return FBS(
                id = json["id"] as Int,
                userId = json["user_id"] as Int,
                testDate = LocalDateTime.parse(json["test_date"] as String, dateFormatter),
                fbsLevel = json["fbs_level"] as Double,
                imageUrl = json["image_url"] as String?
            )
        }
    }

    fun toJson(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "user_id" to userId,
            "test_date" to testDate.format(dateFormatter),
            "fbs_level" to fbsLevel,
            "image_url" to imageUrl
        )
    }
}