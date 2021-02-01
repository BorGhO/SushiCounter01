package com.keepon.sushicounter01

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class OrdineAdapter (data:ArrayList<PiattoClass>, var context: Context) : RecyclerView.Adapter<OrdineAdapter.ViewHolder>(){


        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){   //qui si estende la proprità ViewHolder di Recy, che è il contenitore degli elementi

            internal var title: TextView
            internal var image: ImageView
            internal var desc: TextView
            internal var freccia: ImageView
            internal var categoria: String
            internal var descSelected: Boolean


            init{

                title = itemView.findViewById(R.id.piattoTitleText01)
                image = itemView.findViewById(R.id.piattoImage01)
                desc = itemView.findViewById(R.id.piattoDescText01)
                freccia = itemView.findViewById(R.id.openDesc01)
                categoria = ""
                descSelected = false
            }
        }




        internal var data:List<PiattoClass>

        init{

            this.data = data
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {     //va fatto l'override di tutti i metodi di RecyclerView.Adapter

            val layout = LayoutInflater.from(parent.context).inflate(R.layout.piatto_layout, parent, false)

            return ViewHolder(layout)
        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            holder.title.text = data[position].nome
            holder.desc.text = data[position].desc
            holder.image.setImageResource(data[position].img)
            holder.categoria = data[position].categ
            holder.descSelected = data[position].descSelected
/*

            if (position % 2 == 0)
                holder.desc.setBackgroundColor(ContextCompat.getColor(context, R.color.purple_500))
*/
            holder.title.setOnClickListener {
                println("cliccato titolo")
            }

            holder.freccia.setOnClickListener{

                println("cliccata freccia")
                holder.descSelected = !holder.descSelected
                descClick(holder)
            }


        }

        private fun descClick(holded: ViewHolder){

            if(holded.descSelected)
                holded.freccia.background = context.getDrawable(R.drawable.up_chevron)
            else
                holded.freccia.background = context.getDrawable(R.drawable.down_chevron)
        }

        override fun getItemCount(): Int{

            return data.size
        }


    }