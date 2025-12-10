package com.healthtracker.models

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Reports(
    val id: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("fbc_id")
    val fbcId: Int? = null,
    @SerializedName("liver_id")
    val liverId: Int? = null,
    @SerializedName("urine_id")
    val urineId: Int? = null,
    @SerializedName("fbs_id")
    val fbsId: Int? = null,
    @SerializedName("lipid_id")
    val lipidId: Int? = null,
    @SerializedName("bp_id")
    val bpId: Int? = null,
    @SerializedName("report_date")
    val reportDate: LocalDateTime,
    val summary: String,
    @SerializedName("image_url")
    val imageUrl: String? = null
) {
    companion object {
        private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

        fun fromJson(json: Map<String, Any?>): Reports {
            return Reports(
                id = json["id"] as Int,
                userId = json["user_id"] as Int,
                fbcId = json["fbc_id"] as Int?,
                liverId = json["liver_id"] as Int?,
                urineId = json["urine_id"] as Int?,
                fbsId = json["fbs_id"] as Int?,
                lipidId = json["lipid_id"] as Int?,
                bpId = json["bp_id"] as Int?,
                reportDate = LocalDateTime.parse(json["report_date"] as String, dateFormatter),
                summary = json["summary"] as String,
                imageUrl = json["image_url"] as String?
            )
        }
    }

    fun toJson(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "user_id" to userId,
            "fbc_id" to fbcId,
            "liver_id" to liverId,
            "urine_id" to urineId,
            "fbs_id" to fbsId,
            "lipid_id" to lipidId,
            "bp_id" to bpId,
            "report_date" to reportDate.format(dateFormatter),
            "summary" to summary,
            "image_url" to imageUrl
        )
    }
}