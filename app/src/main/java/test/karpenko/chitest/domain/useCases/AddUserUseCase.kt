package test.karpenko.chitest.domain.useCases

import test.karpenko.chitest.domain.models.UserItem
import test.karpenko.chitest.domain.UserRepository

class AddUserUseCase( private val repository: UserRepository) {

    suspend fun addUser(user: UserItem){
        repository.addUser(user)
    }

}