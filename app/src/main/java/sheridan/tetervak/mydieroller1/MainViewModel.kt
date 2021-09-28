package sheridan.tetervak.mydieroller1

import androidx.lifecycle.ViewModel
import sheridan.tetervak.mydieroller1.model.Die

class MainViewModel: ViewModel() {

    private val die: Die = Die()

    val dieValue: Int
    get() = die.value

    fun roll(){
        die.roll()
    }

}