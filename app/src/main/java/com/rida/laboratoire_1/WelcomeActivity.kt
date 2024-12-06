package com.rida.laboratoire_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    private lateinit var staticButton: Button ;
    private lateinit var dynamicButton : Button ;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        staticButton = findViewById<Button>(R.id.Static)
        dynamicButton = findViewById<Button>(R.id.Dynamic);

        staticButton.setOnClickListener{
            val intent = Intent(this,StaticHostActivity::class.java)
            startActivity(intent);
        }
        dynamicButton.setOnClickListener{
            val intent = Intent(this,DynamicHostActivity::class.java)
            startActivity(intent);
        };
    }
}