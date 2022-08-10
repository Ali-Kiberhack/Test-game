package uz.alidroid.test_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.widget.addTextChangedListener
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var myTextView: TextView
    private lateinit var myEditText: EditText
    private lateinit var myScoreTv:TextView
    private lateinit var myRadioButton1: RadioButton
    private lateinit var myRadioButton2: RadioButton
    private lateinit var myRadioButton3: RadioButton
    private lateinit var myRadioButton4: RadioButton
    private lateinit var myRadioGroup: RadioGroup

    var number1 = 0
    var number2 = 0
    var amal = 0
    var tjavob = 0
    var radio2=0
    var radio3=0
    var radio4=0

    var totalScore=0
    var correctScore=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        myRadioButton1=findViewById(R.id.rad_btn1)
        myRadioButton2=findViewById(R.id.rad_btn2)
        myRadioButton3=findViewById(R.id.rad_btn3)
        myRadioButton4=findViewById(R.id.rad_btn4)
        myEditText = findViewById(R.id.edt_1)
        myTextView = findViewById(R.id.tv_1)
        myScoreTv = findViewById(R.id.tv_ball)
        myRadioGroup=findViewById(R.id.Radiogroup)

        randomMisol()


        myEditText.addTextChangedListener {
            if(tjavob.toString().length==it?.length){
                val javob = myEditText.text.toString().toInt()
                if (javob == tjavob) {
                    correctScore++
                    Toast.makeText(this, "To'g'ri javob", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Noto'g'ri javob", Toast.LENGTH_SHORT).show()
                }
                totalScore++
                totalscore()
            }
        }
    }


    fun totalscore(){
        if (totalScore<=20){
            myEditText.text.clear()
        randomMisol()}
        else{
            myEditText.text.clear()
            totalScore=0
            correctScore=0
            randomMisol()
        }
    }
        fun randomMisol() {

            number1 = Random().nextInt(20)
            number2 = Random().nextInt(20)
            var radio2=Random().nextInt(99)
            var radio3=Random().nextInt(199)
            var radio4=Random().nextInt(120)

            if (number1<number2){
             randomMisol()
                return
            }
            amal = Random().nextInt(4)

            when (amal) {

                0 -> {

                    tjavob = number1 + number2
                    myTextView.text = "$number1+$number2="
                    myRadioButton1.text="$tjavob"
                    myRadioButton2.text="$radio2"
                    myRadioButton3.text="$radio3"
                    myRadioButton4.text="$radio4"
                }
                1 -> {

                    tjavob = number1 - number2
                    myTextView.text = "$number1-$number2="
                    myRadioButton1.text="$tjavob"
                    myRadioButton2.text="$radio2"
                    myRadioButton3.text="$radio3"
                    myRadioButton4.text="$radio4"
                }
                2 -> {

                    tjavob = number1 * number2
                    myTextView.text = "$number1*$number2="
                    myRadioButton1.text="$tjavob"
                    myRadioButton2.text="$radio2"
                    myRadioButton3.text="$radio3"
                    myRadioButton4.text="$radio4"
                }
                3 -> {
                    try {
                       if (number1%number2!=0){
                           randomMisol()
                           return
                       }
                       tjavob=number1/number2
                       myTextView.text="$number1:$number2="
                        myRadioButton1.text="$tjavob"
                        myRadioButton2.text="$radio2"
                        myRadioButton3.text="$radio3"
                        myRadioButton4.text="$radio4"
                    }catch (e:Exception){
                        randomMisol()
                    }
                }
        }

            myScoreTv.text="$correctScore/$totalScore"
    }


}