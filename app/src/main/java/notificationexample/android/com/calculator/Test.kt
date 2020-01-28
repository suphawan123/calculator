package notificationexample.android.com.calculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*


class Test : AppCompatActivity() {

    lateinit var historyAdapter:CalculatorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_history)
//        val his2 = History2();
//        var str: His = intent.getParcelableArrayExtra("History")
        val intent = intent
        val args = intent.getBundleExtra("BUNDLE")
        val history =
            args.getSerializable("studentData") as Student
        //Log.e("new ***", history.toString())

        setUpRecyclerView()


    }


    private fun setUpRecyclerView() {
        historyAdapter = CalculatorAdapter()
        Log.e("new55",historyAdapter.listItem.size.toString())

//        listUsersAdapter.setAdapterListener { position, sectionIndex ->
//            callback อีกแบบ
//        }

        recycerView.setHasFixedSize(true)
        recycerView.apply {
//            historyAdapter.listItem = setData()
            layoutManager = LinearLayoutManager(context)
            adapter = historyAdapter

        }
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