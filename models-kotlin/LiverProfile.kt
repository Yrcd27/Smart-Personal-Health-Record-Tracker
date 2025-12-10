package com.healthtracker.models

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class LiverProfile(
    val id: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("test_date")
    val testDate: LocalDateTime,
    @SerializedName("protein_total_serum")
    val proteinTotalSerum: Double,
    @SerializedName("albumin_serum")
    val albuminSerum: Double,
    @SerializedName("bilirubin_total_serum")
    val bilirubinTotalSerum: Double,
    val sgpt: Double,
    @SerializedName("image_url")
    val imageUrl: String? = null
) {
    companion object {
        private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

        fun fromJson(json: Map<String, Any?>): LiverProfile {
            return LiverProfile(
                id = json["id"] as Int,
                userId = json["user_id"] as Int,
                testDate = LocalDateTime.parse(json["test_date"] as String, dateFormatter),
                proteinTotalSerum = json["protein_total_serum"] as Double,
                albuminSerum = json["albumin_serum"] as Double,
                bilirubinTotalSerum = json["bilirubin_total_serum"] as Double,
                sgpt = json["sgpt"] as Double,
                imageUrl = json["image_url"] as String?
            )
        }
    }

    fun toJson(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "user_id" to userId,
            "test_date" to testDate.format(dateFormatter),
            "protein_total_serum" to proteinTotalSerum,
            "albumin_serum" to albuminSerum,
            "bilirubin_total_serum" to bilirubinTotalSerum,
            "sgpt" to sgpt,
            "image_url" to imageUrl
        )
    }
}