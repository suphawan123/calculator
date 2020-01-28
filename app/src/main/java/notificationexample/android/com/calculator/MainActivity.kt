package notificationexample.android.com.calculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable
import java.io.Serializable


class MainActivity : AppCompatActivity() {

//    val history = History();
//    //var history: ArrayList<History> = ArrayList<History>()
    var process: String? = null
//    lateinit var historyAdapter: CalculatorAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val intent = Intent(this@MainActivity, Test::class.java)
//        btn_0.setOnClickListener {
//            val intent = Intent(this@MainActivity, Test::class.java)
//
//            val student = Student()
//            intent.putExtra("studentData", student)
//            startActivity(intent)
//        }
//
//        btn_equals!!.setOnClickListener(View.OnClickListener {
//            onEqual()
//        })

    }


    fun setNumber(view: View) {
        process = formula.append((view as Button).text).toString()
    }

    fun onClear(view: View) {
        this.formula.text = ""
        this.result.text = ""

    }

    fun btnClick_delete(view: View?) {
        if (formula.getText().equals("")) {
            formula.setText(null)
        } else {
            val len: Int = formula.getText().length
            val s: String = formula.getText().toString()
            if (s[len - 1] == '.') {
                formula.setText(formula.getText().subSequence(0, formula.getText().length - 1))
            } else {
                formula.setText(formula.getText().subSequence(0, formula.getText().length - 1))
            }
        }
    }

    fun onEqual(view: View) {

        process = formula.getText().toString()
        process = process!!.replace("%".toRegex(), "/100")

//        var model = History()

        val rhino: Context = Context.enter()
        rhino.setOptimizationLevel(-1)
        var finalResult = ""
        finalResult = try {
            val scriptable: Scriptable = rhino.initStandardObjects()
            rhino.evaluateString(scriptable, process, "AndroidStudio", 1, null).toString()
        } catch (e: Exception) {
            "0"
        }
        result.setText(finalResult)
//            model.output.add(finalResult)
//            model.input.add(process.toString())
//            history.add(model)
    }

//    Log.e("newh", history.size.toString())
//    return history

//}



//    fun onEqual() {
//
////        historyAdapter = CalculatorAdapter()
////        historyAdapter.listItem = total()
//
//        history.input.add("TEST01")
//
////        Log.e("new2", historyAdapter.listItem.size.toString())
//    }


}

