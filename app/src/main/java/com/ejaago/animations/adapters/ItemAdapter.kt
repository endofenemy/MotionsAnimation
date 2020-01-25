package com.ejaago.animations.adapters

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ejaago.animations.R
import com.ejaago.animations.activity.DetailActivity
import kotlinx.android.synthetic.main.list_item.view.*

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.Holder>() {
    lateinit var context: Context

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.image_view
        val relativeLayout = itemView.relative_layout
        val button = itemView.button

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        run {
            this.context = parent.context
            Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
        }

    override fun getItemCount() = 3

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.button.setOnClickListener {
            holder.relativeLayout.performClick()
        }
        holder.relativeLayout.setOnClickListener {

            val pairs: Array<Pair<View, String>?> =
                arrayOfNulls(2)
            pairs[0] = Pair(holder.imageView, "imageTransition")
            pairs[1] = Pair<View, String>(holder.button, "buttonTransition")

            val options =
                ActivityOptions.makeSceneTransitionAnimation(context as Activity?, *pairs)

            val intent = Intent(context, DetailActivity::class.java)
            context.startActivity(intent, options.toBundle())
        }
    }

}
