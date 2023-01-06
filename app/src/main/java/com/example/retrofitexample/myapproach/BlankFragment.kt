package com.example.retrofitexample.myapproach

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.retrofitexample.databinding.Fragment1Binding

class BlankFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding){
        dataModel.messageForFrag1.observe(activity as LifecycleOwner, {   // MainActivity
            binding.textView2.text = it
        })
        bSendToFrag2.setOnClickListener {
            dataModel.messageForFrag2.value = "Hello from fragment 1!"  // setValue
        }
        bSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Activity, hello from fragment 1!"  // setValue
        }
    }

    companion object {  // Singleton
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}