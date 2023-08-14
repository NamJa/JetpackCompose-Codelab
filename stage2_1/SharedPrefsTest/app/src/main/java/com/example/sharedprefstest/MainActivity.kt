package com.example.sharedprefstest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prefs = getSharedPreferences("test", Context.MODE_PRIVATE)

        for(i in 0..1000) {
            prefs.edit(commit = true) {
                putString(i.toString(), i.toString())
            }
        }
    }

    override fun onResume() {
        super.onResume()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, BlankFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }
}