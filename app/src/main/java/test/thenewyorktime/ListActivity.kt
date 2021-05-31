package test.thenewyorktime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.photo_layout.view.*

class ListActivity : AppCompatActivity(),OnClickListener  {
    private var recyclerView: RecyclerView? = null
    private var dataItem: ArrayList<DataModel>? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var photoAdapters: PhotoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list
        )

        val searchBtn = findViewById<ImageView>(R.id.seachbtn)
        searchBtn.setOnClickListener {
            val intent = Intent(this,SearchActivity::class.java)
            startActivity(intent)
        }
        recyclerView = findViewById(R.id.recycler_view)
        gridLayoutManager =
            GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)

        dataItem = ArrayList()
        dataItem = setData()
        photoAdapters = PhotoAdapter(applicationContext, dataItem!!,this)
        recyclerView?.adapter = photoAdapters
    }
    private fun setData(): ArrayList<DataModel> {

        var arrayList: ArrayList<DataModel> = ArrayList()

        arrayList.add(
            DataModel(
                R.drawable.image_3,
                "As the Georgia Runoffs Arrive, a New Book Says the Senate Is Broken"
            )
        )
        arrayList.add(
            DataModel(
                R.drawable.image_2,
                "How Politics, Protests and the Pandemic Shaped a Year in Books",
            )
        )
        arrayList.add(
            DataModel(
                R.drawable.image_4,
                "Nearly a Century Later, We’re Still Reading — and Changing Our Minds About — Gatsby",
            )
        )
        arrayList.add(
            DataModel(
                R.drawable.image_5,
                "Robert Jones Jr. Is Son of Baldwin, and More",
            )
        )
        arrayList.add(
            DataModel(
                R.drawable.image_2,
                "As the Georgia Runoffs Arrive, a New Book Says the Senate Is Broken"
            )
        )
        return arrayList
    }
    override fun onItemClicked(position: Int) {
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra("image",dataItem!![position].image)
        intent.putExtra("title",dataItem!![position].title)
        startActivity(intent)
    }
}