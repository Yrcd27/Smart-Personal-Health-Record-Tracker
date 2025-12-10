package com.healthtracker.models

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class LipidProfile(
    val id: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("test_date")
    val testDate: LocalDateTime,
    @SerializedName("total_cholesterol")
    val totalCholesterol: Double,
    val hdl: Double,
    val ldl: Double,
    val vldl: Double,
    val triglycerides: Double,
    @SerializedName("image_url")
    val imageUrl: String? = null
) {
    companion object {
        private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

        fun fromJson(json: Map<String, Any?>): LipidProfile {
            return LipidProfile(
                id = json["id"] as Int,
                userId = json["user_id"] as Int,
                testDate = LocalDateTime.parse(json["test_date"] as String, dateFormatter),
                totalCholesterol = json["total_cholesterol"] as Double,
                hdl = json["hdl"] as Double,
                ldl = json["ldl"] as Double,
                vldl = json["vldl"] as Double,
                triglycerides = json["triglycerides"] as Double,
                imageUrl = json["image_url"] as String?
            )
        }
    }

    fun toJson(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "user_id" to userId,
            "test_date" to testDate.format(dateFormatter),
            "total_cholesterol" to totalCholesterol,
            "hdl" to hdl,
            "ldl" to ldl,
            "vldl" to vldl,
            "triglycerides" to triglycerides,
            "image_url" to imageUrl
        )
    }
}