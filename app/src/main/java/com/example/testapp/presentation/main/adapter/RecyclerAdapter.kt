package com.example.testapp.presentation.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.data.vo.PeopleVo

class RecyclerAdapter(private val onClickListener: ItemClickListener) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var item: List<PeopleVo> = emptyList()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_recycler_view, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.lastName.text = item[position].lastName
        viewHolder.firstName.text = item[position].firstName
        viewHolder.firstName.setOnClickListener {
            onClickListener.onClicked(item[position].id)
        }
    }

    override fun getItemCount(): Int = item.size

    fun update(list: List<PeopleVo>) {
        item = list
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        val firstName: TextView
        val lastName: TextView

        init {
            firstName = view.findViewById(R.id.item_first_name)
            lastName = view.findViewById(R.id.item_last_name)
        }
    }

}