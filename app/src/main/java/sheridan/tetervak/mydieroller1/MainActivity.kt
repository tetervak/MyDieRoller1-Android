package sheridan.tetervak.mydieroller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.Toast
import androidx.activity.viewModels
import sheridan.tetervak.mydieroller1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.dieValue.observe(this){
            if(it > 0){
                binding.rollResult.text = it.toString()
            }
        }

        binding.rollButton.setOnClickListener {
            Toast.makeText(this, "Rolled", Toast.LENGTH_LONG).show()
            Log.d(TAG, "The die is rolled")
            viewModel.roll()
        }
    }
}