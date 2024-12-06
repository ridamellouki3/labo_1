package com.rida.laboratoire_1

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.rida.laboratoire_1.ColoringFragment.OnColoringFragmentInteractionListener

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ColoredFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ColoredFragment : Fragment(R.layout.fragment_colored) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var coloredFragmentLayout: View
    private lateinit var remerciementsBtn: Button
    private lateinit var mListener: OnSendTextFragmentInteractionListener

    private val TAG = "ColoredFragment"

    interface OnSendTextFragmentInteractionListener {
        fun onSendThankYouMessage(message: String)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(TAG, "${javaClass.simpleName}: entered ${object{}.javaClass.enclosingMethod.name}")
        try {
            mListener = context as OnSendTextFragmentInteractionListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnColoringFragmentInteractionListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate: ${this::class.java.simpleName}")
    }

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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        coloredFragmentLayout = inflater.inflate(R.layout.fragment_colored, container, false)
        remerciementsBtn = coloredFragmentLayout.findViewById(R.id.Remerciements)

        remerciementsBtn.setOnClickListener {
            mListener.onSendThankYouMessage("Merci de m'avoir coloré!")
        }

        return coloredFragmentLayout
    }


    fun setLayoutBackgroundColor(color: Int) {
        coloredFragmentLayout.setBackgroundColor(color)
        remerciementsBtn.isEnabled =true
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ColoredFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ColoredFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}