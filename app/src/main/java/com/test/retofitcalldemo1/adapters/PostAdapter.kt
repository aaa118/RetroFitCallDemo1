package com.test.retofitcalldemo1.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.test.retofitcalldemo1.R
import com.test.retofitcalldemo1.model.Data
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(val list: List<Data>, val context: Context) : RecyclerView.Adapter<PostAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_post, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val post = list[position]

        holder.itemView.tv_text.text = post.last_name
        holder.itemView.tv_title.text = post.first_name
        val imageView = holder.itemView.iv_holder
        Picasso.with(holder.itemView.context).load(post.avatar).into(imageView)

    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}