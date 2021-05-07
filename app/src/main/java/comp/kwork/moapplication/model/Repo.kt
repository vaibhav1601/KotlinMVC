package comp.kwork.moapplication.model

data class Repo(

    val id: Long,
    val name: String,
    val fullName: String,
    val description: String?,
    val url: String,
    val stars: Int,
    val forks: Int,
    val language: String?,
    val watchers: Int,
    val owner: Owner,
    val createDate: String,
    val updateDate: String,
    val openIssues: Int

)
