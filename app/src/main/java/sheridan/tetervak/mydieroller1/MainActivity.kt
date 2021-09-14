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
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            Toast.makeText(this, "Rolled", Toast.LENGTH_LONG).show()
            Log.d(TAG, "The die is rolled")

            val rand = (1..6).random()
            val rollResult: TextView = findViewById(R.id.roll_result)
            rollResult.text = rand.toString()
        }


    }
}