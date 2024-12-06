package com.rida.laboratoire_1

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Spinner
import android.widget.TextView
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ColoringFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ColoringFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mListener: OnColoringFragmentInteractionListener
    private lateinit var coloringFragmentLayout: View
    private val TAG = ColoringFragment::class.java.canonicalName
    private lateinit var colorSpinner: Spinner
    private lateinit var thankYouMessage: TextView
    private lateinit var btnReplace: Button


    interface OnColoringFragmentInteractionListener {
        fun onSendColorFragmentInteraction(color: Int)
        fun onChangeFragment()
        }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(TAG, "${javaClass.simpleName}: entered ${object{}.javaClass.enclosingMethod.name}")
        try {
            mListener = context as OnColoringFragmentInteractionListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnColoringFragmentInteractionListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate: ${this::class.java.simpleName}")
    }

    override fun onCreateView( inflater:
                               LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?
    ): View? {

        coloringFragmentLayout = inflater.inflate(R.layout.fragment_coloring, container, false)
        btnReplace = coloringFragmentLayout.findViewById<Button>(R.id.btnReplaceFragment)
        btnReplace.setOnClickListener { mListener.onChangeFragment() }
        thankYouMessage = coloringFragmentLayout.findViewById<TextView>(R.id.thankYouMessage)
        colorSpinner = coloringFragmentLayout.findViewById(R.id.colorSpinner)
        val colors = arrayOf("Red", "Green", "Blue", "Yellow", "Cyan", "Magenta", "Black")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, colors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        colorSpinner.adapter = adapter
        colorSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedColor = when (colors[position]) {
                    "Red" -> Color.RED
                    "Green" -> Color.GREEN
                    "Blue" -> Color.BLUE
                    "Yellow" -> Color.YELLOW
                    "Cyan" -> Color.CYAN
                    "Magenta" -> Color.MAGENTA
                    "Black" -> Color.BLACK
                    else -> Color.WHITE }
                mListener.onSendColorFragmentInteraction(selectedColor) }
            override fun onNothingSelected(parent: AdapterView<*>) {} }
        coloringFragmentLayout.setOnClickListener {
            mListener.onSendColorFragmentInteraction(Random.nextInt())
        }

        return coloringFragmentLayout }

    fun displayThankYouMessage(message: String) { thankYouMessage.setText(message) }
    fun enableReplaceFragmentButton() {
        btnReplace.visibility = View.VISIBLE }
    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: ${this::class.java.simpleName}")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ${this::class.java.simpleName}")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: ${this::class.java.simpleName}")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: ${this::class.java.simpleName}")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ColoringFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ColoringFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}