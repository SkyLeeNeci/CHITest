package test.karpenko.chitest.domain

import androidx.lifecycle.LiveData
import test.karpenko.chitest.domain.models.UserItem

interface UserRepository {

    suspend fun addUser(user: UserItem)

    suspend fun deleteUser(user: UserItem)

    suspend fun updateUserStudentStatus(user: UserItem)

    fun getUserById(id: Int): UserItem

    fun getUsersList(): LiveData<List<UserItem>>

    fun getSortedUsersByName(): LiveData<List<UserItem>>

    fun getSortedUsersByAge(): LiveData<List<UserItem>>

    fun getSortedUsersByStatus(): LiveData<List<UserItem>>

    fun getSortedUsersByDescription(): LiveData<List<UserItem>>

}