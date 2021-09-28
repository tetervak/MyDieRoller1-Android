package sheridan.tetervak.mydieroller1.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import sheridan.tetervak.mydieroller1.R

@BindingAdapter("dieValue")
fun bindDieValue(textView: TextView, dieValue: Int?){
    if(dieValue is Int){
        textView.text =
            if(dieValue > 0){
                dieValue.toString()
            }else{
                textView.resources.getString(R.string.space)
            }
    }
}