package com.example.tarsaidzezatiashvili

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.starter


class ProfileFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val button = view.findViewById<Button>(R.id.logout)
        button.setOnClickListener {
            val intent10 = Intent(activity,starter::class.java)
            startActivity(intent10)
        }

        val buttonkalk = view.findViewById<Button>(R.id.button2)
        buttonkalk.setOnClickListener{
            val intent11 = Intent(activity,MainActivity::class.java)
            startActivity((intent11))
        }
        return view



    }



    }

