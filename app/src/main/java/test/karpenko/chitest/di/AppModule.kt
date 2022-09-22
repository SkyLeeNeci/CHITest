package test.karpenko.chitest.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import test.karpenko.chitest.data.database.UserDao
import test.karpenko.chitest.data.database.UserDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "users_database"
        ).build()

    @Provides
    fun provideUserDao(userDatabase: UserDatabase): UserDao =
        userDatabase.userDao()
}