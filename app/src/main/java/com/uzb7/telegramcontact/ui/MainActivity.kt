package com.uzb7.telegramcontact.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uzb7.telegramcontact.R
import com.uzb7.telegramcontact.adapter.ContactAdapter
import com.uzb7.telegramcontact.model.Contact

class MainActivity : AppCompatActivity() {
    lateinit var list: ArrayList<Contact>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        list=loadList()
        val rvContact=findViewById<RecyclerView>(R.id.rv_contact)
        val contactAdapter=ContactAdapter(this,list)
        rvContact.adapter=contactAdapter
        val layoutManager=GridLayoutManager(this,1)
        rvContact.layoutManager=layoutManager
    }

    private fun loadList(): ArrayList<Contact> {
        val mylist=ArrayList<Contact>()
        mylist.add(Contact(
            "https://upload.wikimedia.org/wikipedia/commons/f/fe/Maybach_symbol.jpg",
            "Mansurbek",
            "online"
        ))
        mylist.add(Contact(
            "https://storage.googleapis.com/afs-prod/media/74de9fbee99547ab9cc94aef39e50083/2000.jpeg",
            "Vladimir Putin",
            "2 minut ego"
        ))
        mylist.add(Contact(
            "https://etimg.etb2bimg.com/photo/96207057.cms",
            "Sunay Pichai",
            "5 minut ego"
        ))
        mylist.add(Contact(
            "https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTc5OTk2ODUyMTMxNzM0ODcy/gettyimages-1229892983-square.jpg",
            "Elon Musk",
            "online"
        ))
        mylist.add(Contact(
            "https://imageio.forbes.com/specials-images/imageserve/63a10cda05f6db21230c44d1/Bill-Gates/1960x0.jpg",
            "Bill Gates",
            "30 minut ego"
        ))
        mylist.add(Contact(
            "https://stimg.cardekho.com/images/carexteriorimages/930x620/Mercedes-Benz/AMG-G-63/8591/1630666326351/front-left-side-47.jpg",
            "Abror",
            "long time no entry"
        ))
        return mylist
    }
}