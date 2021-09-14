package sheridan.tetervak.mydieroller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.Toast
import sheridan.tetervak.mydieroller1.databinding.ActivityMainBinding

import sheridan.tetervak.mydieroller1.model.Die

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG = "MainActivity"
        const val RESULT = "Result"

    }

    private lateinit var binding: ActivityMainBinding

    private var die = Die()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState is Bundle){
            val savedResult: Int = savedInstanceState.getInt(RESULT)
            if(savedResult > 0){
                die.value = savedResult
                binding.rollResult.text = savedResult.toString()
            }
        }


        binding.rollButton.setOnClickListener {
            Toast.makeText(this, "Rolled", Toast.LENGTH_LONG).show()
            Log.d(TAG, "The die is rolled")

            die.roll()
            binding.rollResult.text = die.value.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(die.value > 0){
            outState.putInt(RESULT, die.value)
        }

    }
}