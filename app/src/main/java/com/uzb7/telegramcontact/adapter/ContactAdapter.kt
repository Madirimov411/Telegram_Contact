package com.uzb7.telegramcontact.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uzb7.telegramcontact.R
import com.uzb7.telegramcontact.model.Contact

class ContactAdapter(val context:Context,val list:ArrayList<Contact>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val OTHER_ITEM=0
    val CONTACT_ITEM=1
    override fun getItemViewType(position: Int): Int {
        if(position == 0) return OTHER_ITEM
        else return CONTACT_ITEM
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==OTHER_ITEM){
            val view=LayoutInflater.from(parent.context).inflate(R.layout.item_other,parent,false)
            return OtherViewHolder(view)
        }else{
            val view=LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
            return ContactViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ContactViewHolder){
            val contact=list[position]
            holder.apply {
                tvName.text=contact.name
                tvLastSeen.text=contact.last_seen
                Glide.with(ivProfile).load(contact.image).placeholder(R.drawable.person).error(R.drawable.ic_launcher_foreground).into(ivProfile)
                llContact.setOnClickListener {
                    Toast.makeText(context,contact.name,Toast.LENGTH_SHORT).show()
                }
            }
        }
        else if(holder is OtherViewHolder){
            holder.apply {
                llInvite.setOnClickListener {
                    Toast.makeText(context,"Invite clicked",Toast.LENGTH_SHORT).show()
                }
                llLocation.setOnClickListener {
                    Toast.makeText(context,"Find clicked",Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
    class ContactViewHolder(view: View):RecyclerView.ViewHolder(view){
        val ivProfile=view.findViewById<ImageView>(R.id.iv_profile)
        val tvName=view.findViewById<TextView>(R.id.tv_name)
        val tvLastSeen=view.findViewById<TextView>(R.id.tv_last_seen)
        val llContact=view.findViewById<LinearLayout>(R.id.ll_contact)
    }
    class OtherViewHolder(view: View):RecyclerView.ViewHolder(view){
        val llLocation=view.findViewById<LinearLayout>(R.id.ll_find)
        val llInvite=view.findViewById<LinearLayout>(R.id.ll_invinite)
    }


}