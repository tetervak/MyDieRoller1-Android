package sheridan.tetervak.mydieroller1

import androidx.lifecycle.ViewModel
import sheridan.tetervak.mydieroller1.model.Die

class MainViewModel: ViewModel() {

    val die: Die = Die()
}