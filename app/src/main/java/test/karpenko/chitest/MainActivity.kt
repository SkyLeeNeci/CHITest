package test.karpenko.chitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import test.karpenko.chitest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.increaseCounterBtn.setOnClickListener {
            counter += 1
            binding.counterTV.text = counter.toString()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.run {
            putInt("COUNT", counter)
        }
        super.onSaveInstanceState(outState)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        counter = savedInstanceState.getInt("COUNT")
        binding.counterTV.text = counter.toString()

    }

}