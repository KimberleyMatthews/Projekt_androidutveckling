package com.example.projekt_androidutveckling

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.projekt_androidutveckling.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate setup
        binding = FragmentAboutBinding.inflate(layoutInflater, container, false)

        val view = binding.root

        val btnHome = binding.btnHome

        // OnClickListener for home button - goes from about to home
        btnHome.setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_aboutFragment_to_homeFragment)
        }

        return view
    }

}