package com.example.android.myquotes.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.android.myquotes.activities.QuotesActivity
import com.example.android.myquotes.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class QuotesAdapter(var data : List<String>): Adapter<QuotesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view= inflater.inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val context=holder.itemView.context
        holder.category.text = data[position]
        holder.itemView.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val intent= Intent(context, QuotesActivity::class.java)
                intent.putExtra("category", data[position])
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        var category: TextView = itemView.findViewById(R.id.category)
    }

}