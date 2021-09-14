package sheridan.tetervak.mydieroller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG = "MainActivity"
        const val RESULT = "Result"

    }

    private var dieValue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState is Bundle){
            val savedResult: Int = savedInstanceState.getInt(RESULT)
            if(savedResult > 0){
                dieValue = savedResult
                val rollResult: TextView = findViewById(R.id.roll_result)
                rollResult.text = savedResult.toString()
            }
        }


        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Rolled", Toast.LENGTH_LONG).show()
            Log.d(TAG, "The die is rolled")

            dieValue = (1..6).random()
            val rollResult: TextView = findViewById(R.id.roll_result)
            rollResult.text = dieValue.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(dieValue > 0){
            outState.putInt(RESULT, dieValue)
        }

    }
}