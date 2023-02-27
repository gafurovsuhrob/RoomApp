package com.seros.roomapp.fragments.list

import android.text.Layout.Directions
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.seros.roomapp.R
import com.seros.roomapp.databinding.ActivityMainBinding.bind
import com.seros.roomapp.databinding.CustomRowBinding
import com.seros.roomapp.model.User

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        private var binding = itemView
//
//        fun bind(user: User){
//            binding.idTxt.text = user.id.toString()
//            binding.idTxt.text = user.id.toString()
//            binding.idTxt.text = user.id.toString()
//            binding.idTxt.text = user.id.toString()
//        }

        var id_txt: TextView = itemView.findViewById(R.id.id_txt)
        var firstName_txt: TextView = itemView.findViewById(R.id.firstName_txt)
        var lastName_txt: TextView = itemView.findViewById(R.id.lastName_txt)
        var age_txt: TextView = itemView.findViewById(R.id.age_txt)
        var rowLayout: ConstraintLayout = itemView.findViewById(R.id.rowLayout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val binding = CustomRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return MyViewHolder(binding)
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.id_txt.text = currentItem.id.toString()
        holder.firstName_txt.text = currentItem.firstname
        holder.lastName_txt.text = currentItem.lastName
        holder.age_txt.text = currentItem.age.toString()

        holder.rowLayout.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}