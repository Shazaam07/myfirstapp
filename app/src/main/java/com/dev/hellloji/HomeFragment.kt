package com.dev.hellloji // DHYAN RAHE: Yahan apna khud ka package name likhna jo sabse upar likha hota hai!

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Yeh line tumhari layout file ko is channel se jodti hai
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}