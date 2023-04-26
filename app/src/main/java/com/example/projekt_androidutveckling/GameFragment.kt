package com.example.projekt_androidutveckling

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.projekt_androidutveckling.databinding.FragmentGameBinding

class GameFragment : Fragment()
{
    //Keep track on who's turn it is
    enum class Turn {
        NOUGHT,
        CROSS
    }

    private var firstTurn = Turn.CROSS
    private var currentTurn = Turn.CROSS

    private var crossesScore = 0
    private var noughtsScore = 0

    private var boardList = mutableListOf<Button>()

    private lateinit var binding: FragmentGameBinding

    // TODO - Make ViewModel work to collect scores for players
    // TODO - Initialize ViewModel in THIS fragment
    private lateinit var score: ScoreViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Setup ViewBinding
        binding = FragmentGameBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        initBoard(view)

        return view
    }

    private fun initBoard(view: View) {
        boardList.addAll(listOf(
            binding.a1, binding.a2, binding.a3,
            binding.b1, binding.b2, binding.b3,
            binding.c1, binding.c2, binding.c3))

        boardList.forEach { button ->
            button.setOnClickListener {
                println(currentTurn)
                println("WAS CLICKED ")
                boardTapped(view, button.id)
            }
        }
    }

    private fun boardTapped(view : View, buttonId: Int) {

        println("#1 DEBUG ")
        addToBoard(buttonId)

        // Check if someone won
        if(checkForVictory(NOUGHT)) {
            //add score to scoreboard
            noughtsScore++
            result("Noughts Win!")
        }
        if(checkForVictory(CROSS)) {
            //add score to scoreboard
            crossesScore++
            result("Crosses Win!")
        }

        if(fullBoard()) {
            result("Draw")
        }
    }

    // Check for Victory
    private fun checkForVictory(s: String): Boolean {
        // Horizontal Victory
        if(match(binding.a1,s) && match(binding.a2,s) && match(binding.a3,s))
            return true
        if(match(binding.b1,s) && match(binding.b2,s) && match(binding.b3,s))
            return true
        if(match(binding.c1,s) && match(binding.c2,s) && match(binding.c3,s))
            return true

        // Vertical Victory
        if(match(binding.a1,s) && match(binding.b1,s) && match(binding.c1,s))
            return true
        if(match(binding.a2,s) && match(binding.b2,s) && match(binding.c2,s))
            return true
        if(match(binding.a3,s) && match(binding.b3,s) && match(binding.c3,s))
            return true

        // Diagonal Victory
        if(match(binding.a1,s) && match(binding.b2,s) && match(binding.c3,s))
            return true
        if(match(binding.a3,s) && match(binding.b2,s) && match(binding.c1,s))
            return true

        return false
    }
    private fun match(button: Button, symbol: String) = button.text == symbol
    private fun result(title: String) {
        val message = "\nNoughts $noughtsScore\n\nCrosses $crossesScore"
        AlertDialog.Builder(requireContext())
            .setTitle(title)
            .setPositiveButton("Reset")
            { _,_ ->
                resetBoard()
            }
            .setCancelable(false)
            .show()
    }
    private fun resetBoard() {
        for(button in boardList) {
            button.text = ""
        }
        if(firstTurn == Turn.NOUGHT)
            firstTurn = Turn.CROSS
        else if(firstTurn == Turn.CROSS)
            firstTurn = Turn.NOUGHT

        currentTurn = firstTurn
        setTurnLabel()
    }
    private fun fullBoard(): Boolean {

        for(button in boardList) {
            if(button.text == "")
                return false
        }
        return true
    }
    //When button gets pressed
    private fun addToBoard(buttonId: Int) {
        val button = binding.root.findViewById<Button>(buttonId)

        if(button.text != "") {
            println("#2 DEBUGGING - IF STATEMENT #1")
            return
        }

        if(currentTurn == Turn.NOUGHT) {
            println("#2 DEBUGGING - IF STATEMENT #2")

            button.text = "0"
            currentTurn = Turn.CROSS
        }
        else if(currentTurn == Turn.CROSS) {
            println("#2 DEBUGGING - IF STATEMENT #3")

            button.text = "X"
            currentTurn = Turn.NOUGHT
        }
       setTurnLabel()
    }

    private fun setTurnLabel() {
        var turnText = ""
        if (currentTurn == Turn.CROSS)
            turnText = "Turn $CROSS"
        else if (currentTurn == Turn.NOUGHT)
            turnText = "Turn $NOUGHT"

        binding.tvTurn.text = turnText
    }

    companion object {
        const val NOUGHT = "0"
        const val CROSS = "X"

    }

}