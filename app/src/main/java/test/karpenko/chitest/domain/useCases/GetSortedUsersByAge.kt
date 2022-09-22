package test.karpenko.chitest.domain.useCases

import androidx.lifecycle.LiveData
import test.karpenko.chitest.domain.models.UserItem
import test.karpenko.chitest.domain.UserRepository

class GetSortedUsersByAge(private val repository: UserRepository) {

    fun getSortedUsersByAge(): LiveData<List<UserItem>> {
        return repository.getSortedUsersByAge()
    }

}