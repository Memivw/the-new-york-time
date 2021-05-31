package test.thenewyorktime

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class PhotoAdapter (var context:Context , var arrayList: ArrayList<DataModel>,private val onClickListener: OnClickListener):RecyclerView.Adapter<PhotoAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.photo_layout, parent, false)
        return ItemHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val dataModel: DataModel = arrayList.get(position)

        holder.image.setImageResource(dataModel.image!!)
        holder.titles.text = dataModel.title

        holder.image.setOnClickListener {
            onClickListener.onItemClicked(position)
        }

    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image = itemView.findViewById<ImageView>(R.id.image)
        var titles = itemView.findViewById<TextView>(R.id.titletxt)

    }
}
