package notificationexample.android.com.calculator

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {

    lateinit var historyAdapter:CalculatorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(R.layout.fragment_history, container, false)


        return view


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }



    private fun setUpRecyclerView() {
        historyAdapter = CalculatorAdapter()


//        listUsersAdapter.setAdapterListener { position, sectionIndex ->
//            callback อีกแบบ
//        }

//        recycerView.setHasFixedSize(true)
//        recycerView.apply {
//            historyAdapter.listItem = setData()
//            layoutManager = LinearLayoutManager(context)
//            adapter = historyAdapter
//
//        }
    }

    private fun setData():ArrayList<History>{

        val grup:ArrayList<History> = ArrayList()


        for (i in 0..5){

            val  item = History()

            grup.add(item)

        }

        return grup

    }

}
