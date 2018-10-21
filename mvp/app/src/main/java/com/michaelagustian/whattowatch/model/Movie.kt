package com.michaelagustian.whattowatch.model

import com.google.gson.annotations.SerializedName
import com.michaelagustian.whattowatch.Constant
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Michael Agustian on 21/10/18.
 */

open class Movie : RealmObject() {

    @PrimaryKey
    @SerializedName("id")
    var id: Int? = 0

    @SerializedName("vote_average")
    var voteAverage: Double? = 0.0

    @SerializedName("title")
    var title: String? = ""

    @SerializedName("original_title")
    var originalTitle: String? = ""

    @SerializedName("genre_ids")
    var genreIds: RealmList<Int>? = null

    @SerializedName("poster_path")
    var posterPath: String? = ""

    @SerializedName("backdrop_path")
    var backdropPath: String? = ""

    @SerializedName("overview")
    var overview: String? = ""

    @SerializedName("release_date")
    var releaseDate: String? = ""

    fun getPoster(): String = Constant.BASE_IMAGE_URL + posterPath

    fun getBackdrop(): String = Constant.BASE_IMAGE_URL + backdropPath
}