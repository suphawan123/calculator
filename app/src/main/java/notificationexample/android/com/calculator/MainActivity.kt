package notificationexample.android.com.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable


class MainActivity : AppCompatActivity() {

    var total: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun setNumber(view: View) {
        total = formula.append((view as Button).text).toString()
    }

    fun onClear(view: View) {
        this.formula.text = ""
        this.result_1.text = ""
    }

    fun btnClick_delete(view: View?) {
        if (formula.getText().equals("")) {
            formula.setText(null)
        } else {
            val len: Int = formula.getText().length
            val s: String = formula.getText().toString()
            formula.setText(formula.getText().subSequence(0, formula.getText().length - 1))
        }
    }

    fun onEqual(view: View) {

        total = formula.getText().toString()
        total = total!!.replace("%".toRegex(), "/100")

        val rhino: Context = Context.enter()
        rhino.setOptimizationLevel(-1)
        var finalResult = ""
        finalResult = try {
            val scriptable: Scriptable = rhino.initStandardObjects()
            rhino.evaluateString(scriptable, total, "AndroidStudio", 5, null).toString()
        } catch (e: Exception) {
            "0"
        }
        result_1.setText(finalResult)

    }

}

//            try {
//                val result = expression.evaluate()
//                result_1.text = result.toString()
//            } catch (ex: Expression1) {
//               "ผิดพลาด"
//            }
//        result_1.setText(expression)

//        var model = History()

//        val rhino: Context = Context.enter()
//
//        var finalResult = ""
//        finalResult = try {
//            val scriptable: Scriptable = rhino.initStandardObjects()
//            rhino.evaluateString(scriptable, process, "AndroidStudio", 5, null).toString()
//        } catch (e: Exception) {
//            "0"
//        }
//        result.setText(finalResult)
////            model.output.add(finalResult)
////            model.input.add(process.toString())
////            history.add(model)


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


//    fun btnClick_delete(view: View?) {
//        if (formula.getText().equals("") != null) {
//            formula.setText(formula.getText().subSequence(0, formula.getText().length - 1))
//            return formula.setText("")
//        }
//
//    }
