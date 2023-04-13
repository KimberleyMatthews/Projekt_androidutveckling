package com.example.projekt_androidutveckling

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.projekt_androidutveckling.databinding.FragmentCreateAccountBinding
import com.example.projekt_androidutveckling.databinding.FragmentSignInBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CreateAccountFragment : Fragment() {
    // SetUp Binding
    private lateinit var binding: FragmentCreateAccountBinding
    // SetUp Database reference
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        // SetUp ViewBinding
        binding = FragmentCreateAccountBinding.inflate(layoutInflater, container, false)

        val view = binding.root

        db = FirebaseDatabase
            .getInstance("https://android-project-51387-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("users")

        // ID's
        val etNewUsername = binding.etNewUsername
        val etNewUserPassword = binding.etNewUserPassword
        val btnCreate = binding.btnCreate

        var listOfUsers = arrayListOf<Users>()

        // On SignIn - Check name and password
        btnCreate.setOnClickListener(){

            val newUsername = etNewUsername.text.toString()
            val newUserPassword = etNewUserPassword.text.toString()

            // Creates a new user
            val newUser = Users(newUsername, newUserPassword, true)

            // Toast for success or failure
            db.push()
                .setValue(newUser)
                .addOnSuccessListener {
                    Toast.makeText(requireContext(), "Success: $newUser was inserted", Toast.LENGTH_LONG).show()

                }.addOnFailureListener{
                    Toast.makeText(requireContext(), "Failure: Something went wrong $it", Toast.LENGTH_LONG).show()
                }

        }

        return view

}}