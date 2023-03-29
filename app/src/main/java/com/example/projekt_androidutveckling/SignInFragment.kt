package com.example.projekt_androidutveckling

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projekt_androidutveckling.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    // SetUp Binding
    private lateinit var binding: FragmentSignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate SetUp
        binding = FragmentSignInBinding.inflate(layoutInflater, container, false)

        val view = binding.root

        val btnSignIn = binding.btnSignIn

        return view

    }

}