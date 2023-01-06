package com.example.retrofitexample.myapproach

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.retrofitexample.databinding.Fragment2Binding

class BlankFragment2 : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        dataModel.messageForFrag2.observe(activity as LifecycleOwner, {   // MainActivity
            binding.textView2.text = it
        })
        bSendToFrag1.setOnClickListener {
            dataModel.messageForFrag1.value = "Hello from fragment 2!"  // setValue
        }
        bSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Activity, hello from fragment 2!"  // setValue
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}