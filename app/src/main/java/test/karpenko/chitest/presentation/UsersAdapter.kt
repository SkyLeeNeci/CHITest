package test.karpenko.chitest.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import test.karpenko.chitest.databinding.ItemUserBinding
import test.karpenko.chitest.domain.models.UserItem

class UsersAdapter: RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    class UserViewHolder(view: ItemUserBinding) : RecyclerView.ViewHolder(view.root){
        val name = view.userName
        val age = view.userAge
        val isStudent = view.isStudentCheck

    }

    private val callback = object : DiffUtil.ItemCallback<UserItem>() {
        override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = differ.currentList[position]
        holder.age.text = user.age.toString()
        holder.name.text = user.name
        if (user.isStudent == true){
            holder.isStudent.isChecked = true
        }
        
        holder.itemView.setOnClickListener {
            Toast.makeText(it.context, "${user.id} : ${user.name}", Toast.LENGTH_SHORT).show()
        }
        
    }

    override fun getItemCount(): Int = differ.currentList.size

}