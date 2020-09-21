package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.diceroller.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    lateinit var diceImage: ImageView;
    lateinit var rollButton: Button;
    private val myName: MyName = MyName("Tung Le")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        diceImage = binding.diceImage;
        rollButton = roll_button;
        binding.myName = myName;
        binding.apply {
            myName?.name = "12123123"
            invalidateAll()
        }
        rollButton.setOnClickListener {
            rollDice()
        }
    }
    private fun rollDice() {
        val randomInt = (1..6).random();
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        dice_image.setImageResource(drawableResource)
    }

}