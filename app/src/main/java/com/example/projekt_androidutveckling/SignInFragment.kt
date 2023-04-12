package com.example.projekt_androidutveckling

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.projekt_androidutveckling.databinding.FragmentSignInBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInFragment : Fragment() {

    // SetUp Binding
    private lateinit var binding: FragmentSignInBinding
    // Initialize Database reference
    private lateinit var db: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
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

        var listOfUsers = arrayListOf<Users>()

        // On SignIn - Check name and password
        btnSignIn.setOnClickListener(){

            val userName = etUserName.text.toString()
            val userPassword = etUserPassword.text.toString()

            // Creates a new user
            val newUser = Users(userName, userPassword, true)

            //
            db.push()
                .setValue(newUser)
                .addOnSuccessListener {
                    Toast.makeText(
                        requireContext(),
                        "Success: $newUser was inserted",
                        Toast.LENGTH_LONG
                    ).show()

                    // Navigates from SignInFragment to GameFragment
                    btnSignIn.setOnClickListener {    Navigation.findNavController(view)
                        .navigate(R.id.action_signInFragment_to_gameFragment)
                    }

                }.addOnFailureListener{
                    Toast.makeText(
                        requireContext(),
                        "Failure: Something went wrong $it",
                        Toast.LENGTH_LONG
                    ).show()
                }
        }
        return view
    }
}
