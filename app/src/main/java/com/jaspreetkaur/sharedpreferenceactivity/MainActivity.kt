package com.jaspreetkaur.sharedpreferenceactivity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jaspreetkaur.sharedpreferenceactivity.databinding.ActivityMainBinding
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        sharedPreferences =getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        if(sharedPreferences.contains("Data")){
            binding.etData.setText(sharedPreferences.getString("Data",""))
            }

    binding.btnSave.setOnClickListener {
        if (binding.etData.text.isNullOrEmpty() == false) {
        editor.putString("Data",binding.etData.text.toString())
            editor.apply()
        }else{
            Toast.makeText(this,"enter Value to Save",Toast.LENGTH_LONG).show()
        }
    }
        binding.btnRemove.setOnClickListener {
            editor.clear()
            editor.apply()
        }
    }
}