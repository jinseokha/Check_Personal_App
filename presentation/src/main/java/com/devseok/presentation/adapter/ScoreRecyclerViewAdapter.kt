package com.devseok.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.devseok.domain.model.DomainScore
import com.devseok.presentation.R
import com.devseok.presentation.databinding.ScoreRecyclerItemBinding
import com.devseok.presentation.viewmodel.MainViewModel

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-20
 * @desc
 */
class ScoreRecyclerViewAdapter (
    private val viewModel : MainViewModel
) : RecyclerView.Adapter<ScoreRecyclerViewAdapter.ScoreRecyclerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ScoreRecyclerItemBinding>(
            layoutInflater,
            R.layout.score_recycler_item,
            parent,
            false
        )

        return ScoreRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScoreRecyclerViewHolder, position: Int) {
        holder.bind(viewModel.scoreList[position])
    }

    override fun getItemCount(): Int {
        return viewModel.scoreList.size
    }

    inner class ScoreRecyclerViewHolder(val binding : ScoreRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DomainScore) {
            binding.data = data
            binding.executePendingBindings()
        }
    }
}