package test.thenewyorktime

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (var context: Context, var arrayList: ArrayList<ItemList> ): BaseAdapter(){


    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return  arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View = View.inflate(context , R.layout.list_item,null)

        var image:ImageView = view.findViewById(R.id.image_list)
        var title:TextView = view.findViewById(R.id.titletxt)
        var desc:TextView = view.findViewById(R.id.desc_txt)
        var aut:TextView = view.findViewById(R.id.by_txt)

        var item:ItemList = arrayList.get(position)

        image.setImageResource(item.image!!)
        title.text = item.title
        desc.text = item.desc
        aut.text = item.author

        return view!!
    }
}