package test.thenewyorktime

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SearchActivity : AppCompatActivity(),AdapterView.OnItemClickListener{
    private var listView: ListView? = null
    private var arraylistItem: ArrayList<ItemList>? = null
    private var itemAdapters: ItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val backBtn = findViewById<ImageView>(R.id.backbtn)
        backBtn.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

        listView = findViewById(R.id.card_listview)
        arraylistItem = ArrayList()
        arraylistItem = setDataItem()
        itemAdapters = ItemAdapter(applicationContext,arraylistItem!!)
        listView?.adapter = itemAdapters
        listView?.onItemClickListener = this

    }
    private  fun setDataItem():ArrayList<ItemList>{
        var listItem:ArrayList<ItemList> = ArrayList()
        listItem.add(
            ItemList(
                R.drawable.image_2,
                "As the Georgia Runoffs Arrive, a New Book Says the Senate Is Broken",
                "In “Kill Switch,” Adam Jentleson explains how the Senate has become a place where ambitious legislation goes to die.",
                "By Jennifer Szalai"
            )
        )
        listItem.add(
            ItemList(
                R.drawable.image_3,
                "How Politics, Protests and the Pandemic Shaped a Year in Books",
                "From “American Dirt” to “Apropos of Nothing” to “A Promised Land,” here is what happened in the literary and publishing world’s unforgettable 2020.",
                "By John Williams"
            )
        )
        listItem.add(
            ItemList(
                R.drawable.image_4,
                "Nearly a Century Later, We’re Still Reading — and Changing Our Minds About — Gatsby",
                "Our critic considers why F. Scott Fitzgerald’s classic inspires and withstands so much interpretation.",
                "By Parul Sehgal"
            )
        )
        listItem.add(
            ItemList(
                R.drawable.image_5,
                "Robert Jones Jr. Is Son of Baldwin, and More",
                "The writer’s debut novel, “The Prophets,” is the Black queer love story he longed to read.",
                "By Lauren Christensen"
            )
        )
        return listItem
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        var items:ItemList = arraylistItem?.get(position)!!
        val intent = Intent(this,DetailActivity::class.java)
//        intent.putExtra("image",items!![position].image)
//        intent.putExtra("title",items!![position].title)
//        intent.putExtra("desc",items!![position].desc)
        startActivity(intent)
    }
}