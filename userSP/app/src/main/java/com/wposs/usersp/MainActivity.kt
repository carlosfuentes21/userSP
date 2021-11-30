package com.wposs.usersp

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.wposs.usersp.Adapter.UserAdapter
import com.wposs.usersp.VO.User
import com.wposs.usersp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val preferences = getPreferences(MODE_PRIVATE)
        val isFirsTime = preferences.getBoolean(getString(R.string.sp_firs_time), true)
        Log.i("SP", "${getString(R.string.sp_firs_time)} = $isFirsTime")

        if (isFirsTime){
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialo_title)
                .setPositiveButton(R.string.dialo_confirm, DialogInterface.OnClickListener { dialogInterface, i ->
                    preferences.edit().putBoolean(getString(R.string.sp_firs_time), false).commit()
                })
                .setNegativeButton(R.string.cancel, null)
                .show()
        }

        userAdapter = UserAdapter(getUsers(), this)
        linearLayoutManager = LinearLayoutManager(this)

        binding.recicler.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }

    private fun getUsers():MutableList<User>{
        val users = mutableListOf<User>()
        val carlos = User(1, "carlos", "andres", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkehoUmQa3KeI77BkbYpfQMeDgh_vJzi89pfEo2eMtJoaq_6xs7DxcUPTKPDM-XDlWUe4&usqp=CAU")
        val jhoan = User(1, "jhoan", "moncada", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkehoUmQa3KeI77BkbYpfQMeDgh_vJzi89pfEo2eMtJoaq_6xs7DxcUPTKPDM-XDlWUe4&usqp=CAU")
        val enyer = User(1, "enyerson", "camero", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkehoUmQa3KeI77BkbYpfQMeDgh_vJzi89pfEo2eMtJoaq_6xs7DxcUPTKPDM-XDlWUe4&usqp=CAU")
        val nataly = User(1, "nataly", "suarez", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkehoUmQa3KeI77BkbYpfQMeDgh_vJzi89pfEo2eMtJoaq_6xs7DxcUPTKPDM-XDlWUe4&usqp=CAU")

        users.add(carlos)
        users.add(jhoan)
        users.add(enyer)
        users.add(nataly)
        users.add(carlos)
        users.add(jhoan)
        users.add(enyer)
        users.add(nataly)
        users.add(carlos)
        users.add(jhoan)
        users.add(enyer)
        users.add(nataly)
        users.add(carlos)
        users.add(jhoan)
        users.add(enyer)
        users.add(nataly)

        return users
    }

    override fun onClick(user: User, position:Int) {
        Toast.makeText(this, "$position: ${user.getFullName()}", Toast.LENGTH_SHORT).show()
    }

}