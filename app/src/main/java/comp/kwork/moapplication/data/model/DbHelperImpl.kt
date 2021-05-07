package comp.kwork.moapplication.data.model

import comp.kwork.moapplication.model.Repo
import javax.inject.Inject

class DbHelperImpl @Inject constructor(private val dbService: DbService) : DbHelper {

    override suspend fun getGitResponse(): List<Repo> = dbService.getGitResponse()

}