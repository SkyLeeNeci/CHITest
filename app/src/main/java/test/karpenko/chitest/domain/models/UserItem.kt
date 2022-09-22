package test.karpenko.chitest.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class UserItem(
    val name: String?,
    val age: Int?,
    val birthday: String?,
    val isStudent: Boolean? = false,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
