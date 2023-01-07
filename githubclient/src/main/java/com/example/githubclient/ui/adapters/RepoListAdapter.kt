package com.example.githubclient.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclient.R
import com.example.githubclient.data.RepositoryModel
import com.example.githubclient.databinding.ItemListReposBinding

class RepoListAdapter(val repos: List<RepositoryModel>): RecyclerView.Adapter<RepoListAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(repo: RepositoryModel) {
            val viewBinding = ItemListReposBinding.bind(itemView)

            viewBinding.repoName.text = repo.name
            viewBinding.repoDescription.text = repo.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_repos, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun getItemCount() = repos.size
}