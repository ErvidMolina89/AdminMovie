package com.example.exampleretrofitrxmvvmmovies.Models

import java.io.Serializable

data class Movie (
    val id: Int?,
    val name: String?,
    val release_date: String?,
    val runtime: String?,
    val description: String?,
    val image: imag?,
    val deck: String?,
    val total_revenue: String?,
): Serializable

data class imag (
    val icon_url: String?,
    val medium_url: String?,
    val small_url: String?,
    val thumb_url: String?,
    val original_url: String?,
)