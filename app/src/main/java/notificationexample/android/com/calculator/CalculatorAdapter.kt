package notificationexample.android.com.calculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CalculatorAdapter : RecyclerView.Adapter<CalculatorAdapter.ViewHolder>() {

    var listItem:ArrayList<History> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalculatorAdapter.ViewHolder {

        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.view_calculator, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return listItem.size
    }

    override fun onBindViewHolder(holder: CalculatorAdapter.ViewHolder, position: Int) {
        val itemvh = holder
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textView_input: TextView
        var textView_output: TextView

        init {
            textView_input = itemView.findViewById(R.id.textView_input)
            textView_output = itemView.findViewById(R.id.textView_output)
        }
    }

}