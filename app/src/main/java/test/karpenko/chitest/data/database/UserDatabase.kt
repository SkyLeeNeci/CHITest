package test.karpenko.chitest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import test.karpenko.chitest.domain.models.UserItem

@Database(entities = [UserItem::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

}