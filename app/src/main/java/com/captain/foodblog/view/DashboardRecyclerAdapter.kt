package com.captain.foodblog.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.captain.foodblog.R
import com.captain.foodblog.models.BlogResponseModel
import com.captain.foodblog.models.Card
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.dashboard_recycler_single.view.*

class DashboardRecyclerAdapter(val context:Context):RecyclerView.Adapter<DashboardRecyclerAdapter.ViewHolder>() {

    private var cardList:List<Card>? = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.dashboard_recycler_single,parent,false))


    }

    override fun getItemCount(): Int {

        return cardList?.size?:0

    }

    fun showAllBlogs(list:List<Card>)
    {
        cardList = list
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Picasso.get().load(cardList?.get(position)?.img).into(holder.itemView.imageView)
        holder.itemView.foodTitle.text = cardList?.get(position)?.title
        holder.itemView.foodDesc.text = cardList?.get(position)?.desc


    }


    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
}