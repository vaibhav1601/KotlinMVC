package comp.kwork.moapplication.model
data class RepoSearchResponse(

    val total: Int = 0,
    val items: List<Repo> = emptyList(),
    val nextPage: Int? = null
)