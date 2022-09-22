package test.karpenko.chitest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import test.karpenko.chitest.data.repository.UserRepositoryImpl
import test.karpenko.chitest.domain.models.UserItem
import test.karpenko.chitest.domain.useCases.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repositoryImpl: UserRepositoryImpl): ViewModel() {

    private val getUsersUseCase = GetUsersListUseCase(repositoryImpl)
    private val deleteUserUseCase = DeleteUserUseCase(repositoryImpl)
    private val addUserUseCase = AddUserUseCase(repositoryImpl)
    private val getSortedUsersByName = GetSortedUsersByName(repositoryImpl)
    private val getSortedUsersByAge = GetSortedUsersByAge(repositoryImpl)
    private val updateUserStudentStatus = UpdateUserStudentStatusUseCase(repositoryImpl)

    fun getUsersList() = getUsersUseCase.getUsersList()

    fun addUser(userItem: UserItem) = viewModelScope.launch(Dispatchers.IO) {
        addUserUseCase.addUser(userItem)
    }

    fun deleteUser(userItem: UserItem) = viewModelScope.launch(Dispatchers.IO) {
        deleteUserUseCase.deleteUser(userItem)
    }

    fun updateUserStudentStatus(userItem: UserItem) = viewModelScope.launch(Dispatchers.IO) {
        updateUserStudentStatus.updateUserStudentStatus(userItem)
    }

    fun getSortedUsersByName() = getSortedUsersByName.sortUsersByName()

    fun getSortedUsersByAge() = getSortedUsersByAge.getSortedUsersByAge()
}