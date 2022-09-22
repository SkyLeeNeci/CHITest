package test.karpenko.chitest.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import test.karpenko.chitest.domain.models.UserItem

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(userItem: UserItem)

    @Delete
    suspend fun deleteUser(userItem: UserItem)

    @Update
    suspend fun updateStudentStatus(userItem: UserItem)

    @Query("select * from users")
    fun getUsers(): LiveData<List<UserItem>>

    @Query("select * from users where id = :id")
    fun getUserById(id: Int): UserItem

    @Query("select * from users order by name")
    fun getUsersSortedByName(): LiveData<List<UserItem>>

    @Query("select * from users order by age")
    fun getUsersSortedByAge(): LiveData<List<UserItem>>
}