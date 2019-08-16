package takahashi.kazuyoshi.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)

        val text1: String = editText1.getText().toString()
        val text2: String = editText2.getText().toString()

        val num1: Float = text1.toFloat()
        val num2: Float = text2.toFloat()

        fun addition(a: Float, b: Float): Float {
            return a + b
        }

        fun subtraction(a: Float, b: Float): Float {
            return a - b
        }

        fun multiplication(a: Float, b: Float): Float {
            return  a * b
        }

        fun division(a: Float, b: Float): Float {
            return a / b
        }

        val result: Float = when (v?.id) {
            R.id.button1 -> addition(num1, num2)
            R.id.button2 -> subtraction(num1, num2)
            R.id.button3 -> multiplication(num1, num2)
            R.id.button4 -> division(num1, num2)
            else -> 0f
        }

        intent.putExtra("VALUE", result)

    }
}
