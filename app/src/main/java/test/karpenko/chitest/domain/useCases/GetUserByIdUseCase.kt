package test.karpenko.chitest.domain.useCases

import test.karpenko.chitest.domain.models.UserItem
import test.karpenko.chitest.domain.UserRepository

class GetUserByIdUseCase(private val repository: UserRepository) {

    fun getUserById(id: Int) : UserItem {
        return repository.getUserById(id)
    }

}