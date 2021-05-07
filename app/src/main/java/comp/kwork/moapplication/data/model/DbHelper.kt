package comp.kwork.moapplication.data.model

import comp.kwork.moapplication.model.Repo

interface DbHelper {

    suspend fun getGitResponse(): List<Repo>

}