package test.karpenko.chitest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import test.karpenko.chitest.databinding.ActivityMainBinding


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    lateinit var usersAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        observeViewModel()
        viewModel.getUsersList()



    }


    private fun observeViewModel(){
        viewModel.getUsersList().observe(this){
            usersAdapter.differ.submitList(it)
        }
    }

    private fun initAdapter() {
        usersAdapter = UsersAdapter()
        binding.usersRecyclerView.apply {
            adapter = usersAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

}