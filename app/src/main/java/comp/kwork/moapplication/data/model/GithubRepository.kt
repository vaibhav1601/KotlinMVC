
package comp.kwork.moapplication.data.model


import androidx.paging.Pager
import androidx.paging.PagingConfig

import comp.kwork.moapplication.api.Api
import javax.inject.Inject


class GithubRepository @Inject constructor(private val api: Api) {

    fun getSearchResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { GithubPagingSource(api, query) }
        )
}