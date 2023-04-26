package com.example.projekt_androidutveckling

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.projekt_androidutveckling.api.API
import com.example.projekt_androidutveckling.api.JokeApi
import com.example.projekt_androidutveckling.databinding.FragmentHomeBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    //Setup ViewBinding
    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate setup
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        val view = binding.root

        // ID's
        val btnAbout = binding.btnAbout
        val btnLogIn = binding.btnLogIn
        val btnJoke = binding.btnJoke

        // OnClickListener for buttons - goes from home to about or sign in
        btnAbout.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_aboutFragment2)
        }
        btnLogIn.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_signInFragment)
        }
        btnJoke.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_jokeFragment)
        }

    return view

    }
}