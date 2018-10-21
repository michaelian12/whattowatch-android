package com.michaelagustian.whattowatch.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Michael Agustian on 21/10/18.
 */

class ResultList<T> {

    @SerializedName("page")
    var page: Int? = 0

    @SerializedName("total_results")
    var totalResults: Int? = 0

    @SerializedName("total_pages")
    var totalPages: Int? = 0

    @SerializedName("results")
    var results: List<T>? = null
}