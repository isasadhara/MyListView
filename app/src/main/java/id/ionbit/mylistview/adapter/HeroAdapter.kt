package id.ionbit.mylistview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import id.ionbit.mylistview.R
import id.ionbit.mylistview.model.Hero

class HeroAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var heroes = arrayListOf<Hero>()

    //untuk mengetahui berapa banyak item yang ditampilkan
    override fun getCount(): Int = heroes.size

    override fun getItem(i: Int): Any = heroes[i]

    override fun getItemId(i: Int): Long = i.toLong()

    //untuk memanggil layout item xml yang sudah dibuat dan melakukan proses manipulasi setiap komponennya seperti textview dan imageview melalui kelas ViewHolder
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)
        internal fun bind(hero: Hero) {
            txtName.text = hero.name
            txtDescription.text = hero.description
            imgPhoto.setImageResource(hero.photo)
        }
    }
}