package comp.kwork.moapplication.data.model

import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

class ReposDataModel @Inject constructor(private val apiHelper: DbHelper) {

    /*private val currentQuery = "language:Kotlin"

    val repos = repository.getSearchResults(currentQuery)*/

    suspend fun getGitResponse() =  apiHelper.getGitResponse()


}