package com.aire.codigo

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aire.codigo.databinding.ActivityLoginBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity(),TextWatcher {

    fun login(){
        navigateToMain()
    }

    fun navigateToMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun isCorrect(email : String, password : String)  = email.isNotEmpty() && password.isNotEmpty()

    fun setButtonEnable(email: String, password: String){
        binding.btnClick.isEnabled = isCorrect(email, password)
    }


    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        binding.btnClick.isEnabled = false

        /*btnClick.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {

            }
        }) */


        binding.btnClick.setOnClickListener {
            login()
        }

        //Forma simple
        binding.tiePassword.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                setButtonEnable(binding.tieEmail.text.toString(), s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        //Forma simple
        binding.tieEmail.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tvEmail.text = s
                setButtonEnable(s.toString(), binding.tiePassword.text.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        //Forma compleja
        //tieEmail.addTextChangedListener(this)

        //Programación avanzada y limpia
        /*tieEmail.addTextChangedListener(CustomTextWatcher{ text ->
            tvEmail.text = text
        }) */

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        TODO("Not yet implemented")
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        binding.tvEmail.text = p0
    }

    override fun afterTextChanged(p0: Editable?) {
        TODO("Not yet implemented")
    }
}

class CustomTextWatcher(private val onTextChanged : (String) -> Unit) : TextWatcher{
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        onTextChanged(p0.toString())
    }

    override fun afterTextChanged(p0: Editable?) {

    }

}