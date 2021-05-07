package comp.kwork.moapplication.data.model

import comp.kwork.moapplication.model.Repo

interface DbService {

    suspend fun getGitResponse(): List<Repo>

}