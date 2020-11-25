package com.example.splitwise

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_friends_.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class Friends_Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        btnCircleIconToAdd
        btnCircleIconToAdd.rippleColor=Color.parseColor("#ff407a")
        return inflater.inflate(R.layout.fragment_friends_, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Friends_Fragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Friends_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }


    }
}