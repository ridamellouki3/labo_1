package com.rida.laboratoire_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DynamicHostActivity : AppCompatActivity(),
    ColoringFragment.OnColoringFragmentInteractionListener,ColoredFragment.OnSendTextFragmentInteractionListener{
    private lateinit var dynamicColoredFragment: ColoredFragment
    private lateinit var dynamicColoringFragment: ColoringFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_host)
        dynamicColoringFragment = ColoringFragment.newInstance("", "")
        dynamicColoredFragment = ColoredFragment.newInstance("", "")

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.topLinearLayout, dynamicColoringFragment)
        fragmentTransaction.add(R.id.bottomLinearLayout, dynamicColoredFragment)
        fragmentTransaction.commit()

    }
    override fun onSendColorFragmentInteraction(color: Int) {
        dynamicColoredFragment.setLayoutBackgroundColor(color)
    }
    override fun onSendThankYouMessage(message: String) {
        dynamicColoringFragment.displayThankYouMessage(message)
    }
    override fun onChangeFragment() {
        val replacingFragment = ReplacingFragment.newInstance("", "")
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.bottomLinearLayout, replacingFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    override fun onResume() { super.onResume()
        dynamicColoringFragment.enableReplaceFragmentButton()
    }

}