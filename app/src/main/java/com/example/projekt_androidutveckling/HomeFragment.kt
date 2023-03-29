package com.example.projekt_androidutveckling

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.projekt_androidutveckling.databinding.FragmentHomeBinding

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

        val btnAbout = binding.btnAbout

        // OnClickListener for about button - goes from home to about
        btnAbout.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_aboutFragment2)
        }

    return view

    }
}