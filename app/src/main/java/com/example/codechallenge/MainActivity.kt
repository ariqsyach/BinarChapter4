package com.example.codechallenge

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CallBack {
    override fun kirimBalik(hasil: Int) {
        tlstengah.setImageResource(hasil)
    }

    @SuppressLint("ResourceAsColor")
    override fun kirimLagi(computer: String) {
        if (computer == "gunting") {
            gunting2.setBackgroundColor(R.color.colorPrimaryDark)
        } else if (computer == "batu") {
            batu2.setBackgroundColor(R.color.colorPrimaryDark)
        } else {
            kertas2.setBackgroundColor(R.color.colorPrimaryDark)
        }
    }


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cpu = mutableListOf<String>("kertas", "gunting", "batu")


        var clicked: Boolean = true
        val listbtn = mutableListOf<ImageView>(gunting1, gunting2, batu1, batu2, kertas1, kertas2)
        var controller = Controller(this)

        gunting1.setOnClickListener {
            if (clicked) {
                var pilcpu = cpu.random()
                controller.operasi("gunting", pilcpu)
                gunting1.setBackgroundColor(R.color.colorPrimaryDark)
                clicked = false

            } else {
                Toast.makeText(this, "Harap Reset Dahulu", Toast.LENGTH_LONG).show()
            }

        }
        batu1.setOnClickListener {
            if (clicked) {
                var pilcpu = cpu.random()
                controller.operasi("batu", pilcpu)
                batu1.setBackgroundColor(R.color.colorPrimaryDark)
                clicked = false
            } else {
                Toast.makeText(this, "Harap Reset Dahulu", Toast.LENGTH_LONG).show()
            }
        }
        kertas1.setOnClickListener {
            if (clicked) {
                var pilcpu = cpu.random()
                controller.operasi("kertas", pilcpu)
                kertas1.setBackgroundColor(R.color.colorPrimaryDark)
                clicked = false

            } else {
                Toast.makeText(this, "Harap Reset Dahulu", Toast.LENGTH_LONG).show()
            }
        }
        refresh.setOnClickListener {
            gunting1.background = getDrawable(android.R.color.transparent)
            gunting2.background = getDrawable(android.R.color.transparent)
            batu1.background = getDrawable(android.R.color.transparent)
            batu2.background = getDrawable(android.R.color.transparent)
            kertas1.background = getDrawable(android.R.color.transparent)
            kertas2.background = getDrawable(android.R.color.transparent)
            tlstengah.setImageResource(R.drawable.vs)
            clicked = true
        }

    }
}