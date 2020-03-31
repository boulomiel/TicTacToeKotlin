package com.rubenmimoun.tictactoekotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.rubenmimoun.tictactoekotlin.R.id.btn3
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main.view.btn1
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var player : Boolean = false
    var count : Int = 0
    var cellId :Int = 0

    var playerOneBtns = ArrayList<Int>()
    var playerTwoBtns = ArrayList<Int>()



    lateinit var turnText : TextView
    lateinit var btn1 : Button
    lateinit var btn2 : Button
    lateinit var btn3 : Button
    lateinit var btn4 : Button
    lateinit var btn5 : Button
    lateinit var btn6 : Button
    lateinit var btn7 : Button
    lateinit var btn8 : Button
    lateinit var btn9 : Button
    lateinit var btnGame :Button
    lateinit var buttonList: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBtn()

        turnText = findViewById(R.id.turnText)
        turnText.text = "Player One"

        btnGame.setOnClickListener(View.OnClickListener { newGame() })


    }

    override fun onClick(v: View?) {



            when(v?.id ){

                R.id.btn1 -> turnChange(v, 1)
                R.id.btn2 -> turnChange(v ,2)
                R.id.btn3 -> turnChange(v, 3)
                R.id.btn4 -> turnChange(v, 4)
                R.id.btn5 -> turnChange(v, 5)
                R.id.btn6 -> turnChange(v, 6)
                R.id.btn7 -> turnChange(v, 7)
                R.id.btn8 -> turnChange(v, 8)
                R.id.btn9 -> turnChange(v, 9)

            }

        checkVictory()




    }

    private fun turnChange(v : View, cellId : Int){
        count ++
        val btn = v as Button
        if(checkPlayerTurn()){
            turnText.text = "Player Two"
            btn.setText("X")

            playerOneBtns.add(cellId)
        }else{
            turnText.text ="Player One"
            btn.setText("O")

            playerTwoBtns.add(cellId)

        }

        btn.isEnabled = false

    }

      private fun checkPlayerTurn() : Boolean{

          player = count % 2 == 0

          return player
    }


    private fun checkVictory() {

        var winner = -1

        when{
            playerOneBtns.contains(1) && playerOneBtns.contains(2) && playerOneBtns.contains(3) -> winner = 2
            playerOneBtns.contains(4) && playerOneBtns.contains(5) && playerOneBtns.contains(6) -> winner = 2
            playerOneBtns.contains(7) && playerOneBtns.contains(8) && playerOneBtns.contains(9) -> winner = 2
            playerOneBtns.contains(1) && playerOneBtns.contains(4) && playerOneBtns.contains(7) -> winner = 2
            playerOneBtns.contains(2) && playerOneBtns.contains(5) && playerOneBtns.contains(8) -> winner = 2
            playerOneBtns.contains(6) && playerOneBtns.contains(6) && playerOneBtns.contains(9) -> winner = 2
            playerOneBtns.contains(1) && playerOneBtns.contains(5) && playerOneBtns.contains(9) -> winner = 2
            playerOneBtns.contains(3) && playerOneBtns.contains(5) && playerOneBtns.contains(7) -> winner = 2

        }

        when{
            playerTwoBtns.contains(1) && playerTwoBtns.contains(2) && playerTwoBtns.contains(3) -> winner = 1
            playerTwoBtns.contains(4) && playerTwoBtns.contains(5) && playerTwoBtns.contains(6) -> winner = 1
            playerTwoBtns.contains(7) && playerTwoBtns.contains(8) && playerTwoBtns.contains(9) -> winner = 1
            playerTwoBtns.contains(1) && playerTwoBtns.contains(4) && playerTwoBtns.contains(7) -> winner = 1
            playerTwoBtns.contains(2) && playerTwoBtns.contains(5) && playerTwoBtns.contains(8) -> winner = 1
            playerTwoBtns.contains(6) && playerTwoBtns.contains(6) && playerTwoBtns.contains(9) -> winner = 1
            playerTwoBtns.contains(1) && playerTwoBtns.contains(5) && playerTwoBtns.contains(9) -> winner = 1
            playerTwoBtns.contains(3) && playerTwoBtns.contains(5) && playerTwoBtns.contains(7) -> winner = 1
        }


        if(winner == 1){
            turnText.text = "Winner is player one"
            stopGame()

        }else if(winner == 2){
            turnText.text = "Winner is player two"
            stopGame()
        }

    }


    private fun newGame(){
        for (button in buttonList){
            button.setText("")

          if(!button.isEnabled) button.isEnabled = true
        }

        playerOneBtns.clear()
        playerTwoBtns.clear()
    }


    private fun stopGame(){
        btnGame.isEnabled = true

        for ( button in buttonList){
            button.isEnabled = false
        }
    }

    private fun initBtn(){
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnGame = findViewById(R.id.newGame)

        buttonList = listOf(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btnGame.isEnabled = false

    }


}

