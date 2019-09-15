package com.test.retofitcalldemo1.model

import com.google.gson.annotations.SerializedName

data class AppPages(
    @field:SerializedName("page")
    val pages: Int,
    @field:SerializedName("per_page")
    val perPage: Int,
    @field:SerializedName("total")
    val total: Int,
    @field:SerializedName("total_pages")
    val totalPages: Int, val data: List<Data>)