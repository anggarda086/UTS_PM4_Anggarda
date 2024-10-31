package com.example.utsanggarda

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val ivBack = findViewById<ImageView>(R.id.back)
        ivBack.setOnClickListener {
            val intent = Intent(this, Landing::class.java)
            startActivity(intent)
        }

        val classList = listOf(
            Pair("Mathematics I", "09:30 am"),
            Pair("Physics I", "11:00 am"),
            Pair("Computer Science I", "01:00 pm"),
            Pair("Chemistry I", "02:30 pm"),
            Pair("Biology I", "04:00 pm"),
            Pair("English I", "05:30 pm"),
            Pair("History I", "07:00 pm"),
            Pair("Geography I", "08:30 pm"),
            Pair("Economics I", "10:00 pm"),
            Pair("Art I", "11:30 pm"),
        )

        val classListLayout = findViewById<LinearLayout>(R.id.class_list)

        for (classInfo in classList) {
            val cardView = layoutInflater.inflate(R.layout.class_card_item, null) as CardView

            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 24, 0, 24)
            cardView.layoutParams = layoutParams

            val className = cardView.findViewById<TextView>(R.id.class_name)
            val classTime = cardView.findViewById<TextView>(R.id.class_time)
            val classIcon = cardView.findViewById<TextView>(R.id.class_icon)

            className.text = classInfo.first
            classTime.text = classInfo.second
            classIcon.text = classInfo.first.first().toString()

            classListLayout.addView(cardView)
        }
    }
}