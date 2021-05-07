package comp.kwork.moapplication.api
import com.google.gson.JsonObject

import comp.kwork.moapplication.model.RepoSearchResponse


import retrofit2.Call
import retrofit2.http.*


interface Api {
    @Headers("Content-Type: application/json")
    @POST("BuildConfig.BASE_URL")
    fun userReg(@Body body: JsonObject): Call<String>

    @GET("search/repositories?sort=stars")
    suspend fun getGitRepos(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): RepoSearchResponse




}