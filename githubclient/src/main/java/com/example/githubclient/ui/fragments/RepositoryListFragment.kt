package com.example.githubclient.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.githubclient.R
import com.example.githubclient.data.RepositoryModel
import com.example.githubclient.databinding.FragmentRepositoryListBinding
import com.example.githubclient.databinding.FragmentSearchUserBinding
import com.example.githubclient.ui.adapters.RepoListAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.githubclient.ui.vm.MainViewModel

private const val ARG_PARAM1 = "Username"

class RepositoryListFragment : Fragment() {
    private var userName: String? = null
    private val reposViewModel: MainViewModel by viewModels()  // FragmentViewModelLazy

    lateinit var binding: FragmentRepositoryListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRepositoryListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val repoList: List<RepositoryModel>
        val adapter: RepoListAdapter

        binding.repositoryList.layoutManager = LinearLayoutManager(requireContext())

//        val reposViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        userName?.let {
            reposViewModel.getUserRepos(it)
        }
        reposViewModel.repoList.observe(viewLifecycleOwner, Observer { repoList ->
            repoList?.let {
                binding.repositoryList.adapter = RepoListAdapter(it)
            }

        })

    }
}