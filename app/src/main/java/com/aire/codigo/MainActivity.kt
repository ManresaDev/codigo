package com.aire.codigo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aire.codigo.adapter.UserAdapter
import com.aire.codigo.data.User
import com.aire.codigo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : UserAdapter
    private lateinit var rvUser : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initRecycler()


    }

    fun initRecycler(){
        rvUser = binding.rvUser
        adapter = UserAdapter(this)
        rvUser.adapter = adapter
        rvUser.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        setData()
    }

    fun setData(){
        val users = mutableListOf(
            User(
                name = "Manuel",
                surName ="Manresa" ,
                image = R.mipmap.ic_launcher
            ),
            User(
                name = "Manuel",
                surName ="Manresa" ,
                image = R.mipmap.ic_launcher
            ),
            User(
                name = "Manuel",
                surName ="Manresa" ,
                image = R.mipmap.ic_launcher
            ),
            User(
                name = "Manuel",
                surName ="Manresa" ,
                image = R.mipmap.ic_launcher
            ),
            User(
                name = "Manuel",
                surName ="Manresa" ,
                image = R.mipmap.ic_launcher
            ),
            User(
                name = "Manuel",
                surName ="Manresa" ,
                image = R.mipmap.ic_launcher
            ),
            User(
                name = "Manuel",
                surName ="Manresa" ,
                image = R.mipmap.ic_launcher
            ),
            User(
                name = "Manuel",
                surName ="Manresa" ,
                image = R.mipmap.ic_launcher
            ),
            User(
                name = "Manuel",
                surName ="Manresa" ,
                image = R.mipmap.ic_launcher
            ),
            User(
                name = "Manuel",
                surName ="Manresa" ,
                image = R.mipmap.ic_launcher
            ),
            User(
                name = "Manuel",
                surName ="Manresa" ,
                image = R.mipmap.ic_launcher
            ),
            User(
                name = "Manuel",
                surName ="Manresa" ,
                image = R.mipmap.ic_launcher
            ),
            User(
                name = "Manuel",
                surName ="Manresa" ,
                image = R.mipmap.ic_launcher
            ),
            User(
                name = "Manuel",
                surName ="Manresa" ,
                image = R.mipmap.ic_launcher
            ),
        )
        adapter.setData(users)
        adapter.notifyDataSetChanged()
    }
}