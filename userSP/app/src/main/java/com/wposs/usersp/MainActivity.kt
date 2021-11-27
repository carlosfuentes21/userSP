package com.wposs.usersp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wposs.usersp.Adapter.UserAdapter
import com.wposs.usersp.VO.User
import com.wposs.usersp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter(getUsers())
        linearLayoutManager = LinearLayoutManager(this)

        binding.recicler.apply {
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }

    private fun getUsers():MutableList<User>{
        val users = mutableListOf<User>()
        val carlos = User(1, "carlos", "andres", "")
        val jhoan = User(1, "jhoan", "moncada", "")
        val enyer = User(1, "enyerson", "camero", "")
        val nataly = User(1, "nataly", "suarez", "")

        users.add(carlos)
        users.add(jhoan)
        users.add(enyer)
        users.add(nataly)

        return users
    }

}