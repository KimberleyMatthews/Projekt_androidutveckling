package com.example.projekt_androidutveckling

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannedString
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.projekt_androidutveckling.databinding.FragmentSignInBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInFragment : Fragment() {

    // SetUp Binding
    private lateinit var binding: FragmentSignInBinding
    // Initialize Database reference
    private lateinit var db: DatabaseReference
    // Initiate UIState
    private val viewModelUser: ViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // SetUp ViewBinding
        binding = FragmentSignInBinding.inflate(layoutInflater, container, false)

        val view = binding.root

        db = FirebaseDatabase
            .getInstance("https://android-project-51387-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("users")

        // ID's
        val etUserName = binding.etUsername
        val etUserPassword = binding.etUserpassword
        val btnSignIn = binding.btnSignIn
        val btnCreateAccount = binding.btnCreateAccount

        var listOfUsers = arrayListOf<Users>()

        // On SignIn - Check name and password
        btnSignIn.setOnClickListener(){

            val userName = etUserName.text.toString()
            val userPassword = etUserPassword.text.toString()

            // Creates a new user
            val newUser = Users(userName, userPassword, true)

            // Getter for ViewModel
            //viewModelUser.inloggedUser(userName)

            // Navigates from SignInFragment to GameFragment
            Navigation.findNavController(view)
                .navigate(R.id.action_signInFragment_to_gameFragment)

        }

        // On Create Account
        btnCreateAccount.setOnClickListener(){
            findNavController()
                .navigate(R.id.action_signInFragment_to_createAccountFragment)
        }

        return view
    }

}
