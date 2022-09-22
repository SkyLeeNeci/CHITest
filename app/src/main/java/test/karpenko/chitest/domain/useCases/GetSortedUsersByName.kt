package test.karpenko.chitest.domain.useCases

import androidx.lifecycle.LiveData
import test.karpenko.chitest.domain.models.UserItem
import test.karpenko.chitest.domain.UserRepository

class GetSortedUsersByName(private val repository: UserRepository) {

    fun sortUsersByName(): LiveData<List<UserItem>> {
        return repository.getSortedUsersByName()
    }
}