package test.karpenko.chitest.domain.useCases

import test.karpenko.chitest.domain.models.UserItem
import test.karpenko.chitest.domain.UserRepository

class DeleteUserUseCase(private val repository: UserRepository) {

    suspend fun deleteUser(user: UserItem){
        repository.deleteUser(user)
    }

}