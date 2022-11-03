package org.cream.udemshoppingproject.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.cream.udemshoppingproject.databinding.ItemCategoryBinding
import org.cream.udemshoppingproject.model.Category
import org.cream.udemshoppingproject.ui.common.CategoryDiffCallback

class CategoryAdapter(private val viewModel: CategoryViewModel) : ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(
    CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.viewModel = viewModel
            binding.category = category
            binding.executePendingBindings()
        }
    }

}