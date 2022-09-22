package test.karpenko.chitest.domain.useCases

import androidx.lifecycle.LiveData
import test.karpenko.chitest.domain.models.UserItem
import test.karpenko.chitest.domain.UserRepository

class GetUsersListUseCase(private val repository: UserRepository) {

    fun getUsersList(): LiveData<List<UserItem>> {
        return repository.getUsersList()
    }

}