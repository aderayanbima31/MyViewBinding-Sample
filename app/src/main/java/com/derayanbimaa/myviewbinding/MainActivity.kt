package com.derayanbimaa.myviewbinding

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.derayanbimaa.myviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            editext.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    //no-op
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    //no-op
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    button.isEnabled = count != 0
                }

            })

            button.setOnClickListener {
                Toast.makeText(applicationContext, binding.editext.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}