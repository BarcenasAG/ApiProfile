package com.example.apiprofile.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.apiprofile.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel.getUserInformation()
        observeError()
        observeUseInfo()
    }

    private fun observeUseInfo() {
        userViewModel.userInfo.observe(this){
            val userName = it.results[0].name.first
            val userAge = it.results[0].dob.age
            val userDate = it.results[0].dob.date
            val userCell = it.results[0].cell
            val userGender = it.results[0].gender
            val userEmail = it.results[0].email

            binding.textViewNameUser.text = "Nombre: $userName"
            binding.textViewAgeUser.text = "Edad: $userAge"
            binding.textViewDateUser.text = "Fecha: $userDate"
            binding.textViewCellUser.text = "Celular: $userCell"
            binding.textViewGenderUser.text = "Genero: $userGender"
            binding.textViewEmailUser.text = "Correo: $userEmail"
        }
    }

    private fun observeError() {
        userViewModel.messageError.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
    }
}
