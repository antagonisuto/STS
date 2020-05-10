package com.example.soultosoul.CudiQ.Fragments.OtherFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.soultosoul.R
import kotlinx.android.synthetic.main.fragment_marfa2.*

class Marfa2Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_marfa2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        samle(view)
    }

    private fun samle(view: View) {
        text12.text = " KUKA"
        val text13: TextView = view.findViewById(R.id.text12)
    }

}
