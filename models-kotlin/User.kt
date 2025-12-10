package com.healthtracker.models

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val pwd: String,
    val dob: LocalDateTime,
    val gender: String
) {
    companion object {
        private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

        fun fromJson(json: Map<String, Any?>): User {
            return User(
                id = json["id"] as Int,
                name = json["name"] as String,
                email = json["email"] as String,
                pwd = json["pwd"] as String,
                dob = LocalDateTime.parse(json["dob"] as String, dateFormatter),
                gender = json["gender"] as String
            )
        }
    }

    fun toJson(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "name" to name,
            "email" to email,
            "pwd" to pwd,
            "dob" to dob.format(dateFormatter),
            "gender" to gender
        )
    }
}