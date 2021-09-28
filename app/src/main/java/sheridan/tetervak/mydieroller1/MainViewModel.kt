package sheridan.tetervak.mydieroller1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sheridan.tetervak.mydieroller1.model.Die

class MainViewModel: ViewModel() {

    private val die: Die = Die()

    private val _dieValue: MutableLiveData<Int> = MutableLiveData<Int>(die.value)
    val dieValue: LiveData<Int> = _dieValue

    fun roll(){
        viewModelScope.launch {
            die.roll()
            _dieValue.value = die.value
        }
    }
}