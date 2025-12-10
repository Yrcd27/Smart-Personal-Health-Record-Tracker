package com.healthtracker.models

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class FBC(
    val id: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("test_date")
    val testDate: LocalDateTime,
    val haemoglobin: Double,
    @SerializedName("total_leucocyte_count")
    val totalLeucocyteCount: Double,
    @SerializedName("platelet_count")
    val plateletCount: Double,
    @SerializedName("image_url")
    val imageUrl: String? = null
) {
    companion object {
        private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

        fun fromJson(json: Map<String, Any?>): FBC {
            return FBC(
                id = json["id"] as Int,
                userId = json["user_id"] as Int,
                testDate = LocalDateTime.parse(json["test_date"] as String, dateFormatter),
                haemoglobin = json["haemoglobin"] as Double,
                totalLeucocyteCount = json["total_leucocyte_count"] as Double,
                plateletCount = json["platelet_count"] as Double,
                imageUrl = json["image_url"] as String?
            )
        }
    }

    fun toJson(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "user_id" to userId,
            "test_date" to testDate.format(dateFormatter),
            "haemoglobin" to haemoglobin,
            "total_leucocyte_count" to totalLeucocyteCount,
            "platelet_count" to plateletCount,
            "image_url" to imageUrl
        )
    }
}