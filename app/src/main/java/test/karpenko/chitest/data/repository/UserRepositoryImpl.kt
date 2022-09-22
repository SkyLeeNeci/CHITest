package test.karpenko.chitest.data.repository

import androidx.lifecycle.LiveData
import test.karpenko.chitest.data.database.UserDao
import test.karpenko.chitest.domain.models.UserItem
import test.karpenko.chitest.domain.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) : UserRepository {

    override suspend fun addUser(user: UserItem) {
        userDao.addUser(user)
    }

    override suspend fun deleteUser(user: UserItem) {
        userDao.deleteUser(user)
    }

    override suspend fun updateUserStudentStatus(user: UserItem) {
        userDao.updateStudentStatus(user)
    }

    override fun getUserById(id: Int): UserItem {
        return userDao.getUserById(id)
    }

    override fun getUsersList(): LiveData<List<UserItem>> {
        return userDao.getUsers()
    }

    override fun getSortedUsersByName(): LiveData<List<UserItem>> {
        return userDao.getUsersSortedByName()
    }

    override fun getSortedUsersByAge(): LiveData<List<UserItem>> {
        return userDao.getUsersSortedByAge()
    }

    override fun getSortedUsersByStatus(): LiveData<List<UserItem>> {
        TODO()
    }

    override fun getSortedUsersByDescription(): LiveData<List<UserItem>> {
        TODO()
    }


}