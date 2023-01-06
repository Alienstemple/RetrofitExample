package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.retrofitexample.databinding.ActivityMainBinding
import com.example.retrofitexample.myapproach.BlankFragment
import com.example.retrofitexample.myapproach.BlankFragment2
import com.example.retrofitexample.myapproach.DataModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()  // делегат, лямбда, getter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(BlankFragment.newInstance(), R.id.placeholder1)
        openFrag(BlankFragment2.newInstance(), R.id.placeholder2)
        dataModel.messageForActivity.observe(this, {
            binding.textView.text = it
        })
    }

    private fun openFrag(f: Fragment, idHolder: Int) {
        supportFragmentManager.beginTransaction()
            .replace(idHolder, f)
            .commit()
    }

}