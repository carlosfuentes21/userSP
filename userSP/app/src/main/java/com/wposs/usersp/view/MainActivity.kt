package com.wposs.usersp.view

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.wposs.usersp.Adapter.UserAdapter
import com.wposs.usersp.OnClickListener
import com.wposs.usersp.R
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
        val username = preferences.getString(getString(R.string.sp_username), "")
        Log.i("SP", "${getString(R.string.sp_firs_time)} = $isFirsTime")

        if (isFirsTime){
            val dialogView = layoutInflater.inflate(R.layout.dialog_register, null)
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialo_title)
                .setView(dialogView)
                .setCancelable(false)
                .setPositiveButton(R.string.dialo_confirm, DialogInterface.OnClickListener { dialogInterface, i ->
                    val username = dialogView.findViewById<TextInputEditText>(R.id.tvUserName)
                        .text.toString()
                    with(preferences.edit()){
                        putBoolean(getString(R.string.sp_firs_time), false).commit()
                        putString(getString(R.string.sp_username), username)
                            .apply()
                    }
                    Toast.makeText(this, R.string.registre_success, Toast.LENGTH_SHORT).show()
                })
                .show()
        }else{
            val username = preferences.getString(getString(R.string.sp_username), getString(R.string.hind_username));
            Toast.makeText(this, "Bienvenido $username", Toast.LENGTH_SHORT).show()
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