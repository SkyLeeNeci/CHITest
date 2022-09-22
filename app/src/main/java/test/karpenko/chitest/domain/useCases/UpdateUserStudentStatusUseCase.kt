package test.karpenko.chitest.domain.useCases

import test.karpenko.chitest.domain.UserRepository
import test.karpenko.chitest.domain.models.UserItem

class UpdateUserStudentStatusUseCase(private val repository: UserRepository) {

    suspend fun updateUserStudentStatus(user: UserItem){
        repository.updateUserStudentStatus(user)
    }
}