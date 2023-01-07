package com.example.githubclient.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.githubclient.R
import com.example.githubclient.databinding.FragmentSearchUserBinding

class SearchUserFragment : Fragment() {
    lateinit var binding: FragmentSearchUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchUserBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        buttonSearch.setOnClickListener {
            if (userEditText.text.isNotEmpty()) {

                val bundle = Bundle()
                bundle.putString("Username", userEditText.text.toString())

                Navigation.createNavigateOnClickListener(
                    R.id.action_searchUserFragment_to_repositoryListFragment,
                    bundle
                )
                // FIXME fragment can't launch
            }
        }
    }

}