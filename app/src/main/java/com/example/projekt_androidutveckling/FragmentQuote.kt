package com.example.projekt_androidutveckling

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.projekt_androidutveckling.api.API
import com.example.projekt_androidutveckling.api.JokeApi
import com.example.projekt_androidutveckling.databinding.FragmentQuoteBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class FragmentJoke : Fragment() {

    // Setup ViewBinding
    private lateinit var binding: FragmentQuoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate setup
        binding = FragmentQuoteBinding.inflate(layoutInflater, container, false)

        val view = binding.root
        val tvQuote = binding.tvQuote
        val btnQuote = binding.btnQuote

        btnQuote.setOnClickListener(){

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.goprogram.ai")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val jokeApi : JokeApi = retrofit.create(JokeApi::class.java)
            val call : retrofit2.Call<API> = jokeApi.getInspiration()

            call.enqueue(object : Callback<API> {
                // If SUCCESS
                override fun onResponse(call: retrofit2.Call<API>, response: Response<API>) {

                    if (response.isSuccessful) {
                        val api = response.body()

                        println(api)

                        if (api !=null) { // Will not be NULL
                            tvQuote.text = api.quote
                        }

                    } else {
                        println("ERROR")
                    }
                }
                // If ERROR
                override fun onFailure(call: Call<API>, t: Throwable) {
                    Toast.makeText(
                        activity,
                        t.localizedMessage,
                        Toast.LENGTH_LONG
                    ) .show()
                }

            })

        }

        return view
    }

    }


