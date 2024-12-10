package com.aire.codigo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aire.codigo.R
import com.aire.codigo.data.User
import com.aire.codigo.databinding.ItemRowUserBinding

class UserAdapter(private val context: Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var dataList = mutableListOf<User>()

    fun setData(dataList : MutableList<User>){
        this.dataList = dataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if(dataList.size > 0){
            dataList.size
        }else{
            0
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = dataList[position]
        holder.bindView(user)
    }

    inner class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemRowUserBinding.bind(itemView)
        fun bindView(user : User){
            binding.tvName.text = user.name
            binding.tvSurName.text = user.surName
            binding.imageView.setImageResource(user.image)
        }
    }
}