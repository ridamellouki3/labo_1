package com.rida.laboratoire_1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class StaticHostActivity : AppCompatActivity(),ColoringFragment.OnColoringFragmentInteractionListener,ColoredFragment.OnSendTextFragmentInteractionListener {
    private val TAG = "MainActivity"
    private lateinit var coloringFragment: ColoringFragment
    private lateinit var coloredFragment: ColoredFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        coloringFragment = supportFragmentManager.findFragmentById(R.id.coloringFragment) as ColoringFragment
        coloredFragment = supportFragmentManager.findFragmentById(R.id.coloredFragment) as ColoredFragment

        Log.d(TAG, "onCreate: ${this::class.java.simpleName}")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ${this::class.java.simpleName}")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ${this::class.java.simpleName}")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ${this::class.java.simpleName}")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ${this::class.java.simpleName}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ${this::class.java.simpleName}")
    }
    override fun onSendColorFragmentInteraction(bgColor: Int) {
        Log.i(javaClass.simpleName, "onSendColorFragmentInteraction")
        coloredFragment.setLayoutBackgroundColor(bgColor) }

    override fun onSendThankYouMessage(message: String) {
        Log.i(javaClass.simpleName, "onSendThankYouMessage: $message")
        coloringFragment.displayThankYouMessage(message)
    }
    override fun onChangeFragment() {
        // Ici vous pouvez éventuellement ajouter du code pour gérer le remplacement de fragment si nécessaire
    }

}
