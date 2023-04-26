package com.example.projekt_androidutveckling

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projekt_androidutveckling.api.API
import com.example.projekt_androidutveckling.api.JokeApi
import com.example.projekt_androidutveckling.databinding.FragmentGameBinding
import com.example.projekt_androidutveckling.databinding.FragmentJokeBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class FragmentJoke : Fragment() {

    // Setup ViewBinding
    private lateinit var binding: FragmentJokeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate setup
        binding = FragmentJokeBinding.inflate(layoutInflater, container, false)

        val view = binding.root


        val retrofit = Retrofit.Builder()
            .baseUrl("https://geek-jokes.sameerkumar.website")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val jokeApi = retrofit.create<JokeApi>().getJoke()

        jokeApi.enqueue(object : Callback<API> {
            // If SUCCESS
            override fun onResponse(call: Call<API>, response: Response<API>) {

                if (response.isSuccessful) {
                    val api = response.body()

                    if (api !=null) { // Will not be NULL
                        btnJoke.text = api.link
                    }

                } else {
                    println("ERROR")
                }
            }
            // If ERROR
            override fun onFailure(call: Call<API>, t: Throwable) {
                println(t.printStackTrace())
            }

        })
        return view
    }

    }

// TODO - ID for btnJoke
