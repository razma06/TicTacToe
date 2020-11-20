package com.example.tictac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    var playerPosition = true
    var numberOfClicks = 0

    private fun init(){
        button00.setOnClickListener(this)
        button01.setOnClickListener(this)
        button02.setOnClickListener(this)
        button10.setOnClickListener(this)
        button11.setOnClickListener(this)
        button12.setOnClickListener(this)
        button20.setOnClickListener(this)
        button21.setOnClickListener(this)
        button22.setOnClickListener(this)
        restartButton.setOnClickListener{
                playAgain()
            }
        }


    override fun onClick(v: View?) {
        val buttonName : Button  = v as Button
        when (playerPosition){
            true -> {
                buttonName.text = "X"
                first_player.setBackgroundResource(R.drawable.ic_baseline_looks_one_24)
                second_player.setBackgroundResource(R.drawable.ic_baseline_looks_two_2_24)
            }
            false ->{
                first_player.setBackgroundResource(R.drawable.ic_baseline_looks_one_2_24)
                second_player.setBackgroundResource(R.drawable.ic_baseline_looks_two_24)
                buttonName.text = "0"
            }
        }
        numberOfClicks += 1
        checkWinner()
        buttonName.isClickable = false
        playerPosition = !playerPosition
    }


    private fun checkWinner() {
        if (button00.text.toString() == button01.text.toString() && button01.text.toString() == button02.text.toString() && button01.text.toString().isNotEmpty()) {
            massages(button00.text.toString())
            disabler()
        } else if(button10.text.toString() == button11.text.toString() && button11.text.toString() == button12.text.toString() && button11.text.toString().isNotEmpty()){
            massages(button10.text.toString())
            disabler()
        }else if(button20.text.toString() == button21.text.toString() && button21.text.toString() == button22.text.toString() && button21.text.toString().isNotEmpty()){
            massages(button20.text.toString())
            disabler()
        }else if(button00.text.toString() == button10.text.toString() && button10.text.toString() == button20.text.toString() && button00.text.toString().isNotEmpty()){
            massages(button00.text.toString())
            disabler()
        }else if(button01.text.toString() == button11.text.toString() && button11.text.toString() == button21.text.toString() && button01.text.toString().isNotEmpty()){
            massages(button01.text.toString())
            disabler()
        }else if(button02.text.toString() == button12.text.toString() && button12.text.toString() == button22.text.toString() && button02.text.toString().isNotEmpty()){
            massages(button02.text.toString())
            disabler()
        }else if(button00.text.toString() == button11.text.toString() && button11.text.toString() == button22.text.toString() && button00.text.toString().isNotEmpty()){
            massages(button00.text.toString())
            disabler()
        }else if(button02.text.toString() == button11.text.toString() && button11.text.toString() == button20.text.toString() && button02.text.toString().isNotEmpty()){
            massages(button02.text.toString())
            disabler()
        }else{
            if(numberOfClicks == 9){
                Toast.makeText(this, "Tie", Toast.LENGTH_SHORT).show()
            }
        }


    }



    private fun massages(massage:String){
        Toast.makeText(this, "$massage won", Toast.LENGTH_SHORT).show()
    }
    private fun disabler(){
        button00.isClickable = false; button01.isClickable = false; button02.isClickable = false
        button10.isClickable = false; button11.isClickable = false; button12.isClickable = false
        button20.isClickable = false; button21.isClickable = false; button22.isClickable = false
    }

    private fun playAgain(){
        playerPosition = true
        numberOfClicks = 0
        button00.text = ""; button01.text = ""; button02.text = ""
        button10.text = ""; button11.text = ""; button12.text = ""
        button20.text = ""; button21.text = ""; button22.text = ""
        first_player.setBackgroundResource(R.drawable.ic_baseline_looks_one_2_24)
        second_player.setBackgroundResource(R.drawable.ic_baseline_looks_two_24)
        button00.isClickable = true; button01.isClickable = true; button02.isClickable = true
        button10.isClickable = true; button11.isClickable = true; button12.isClickable = true
        button20.isClickable = true; button21.isClickable = true; button22.isClickable = true
    }


}