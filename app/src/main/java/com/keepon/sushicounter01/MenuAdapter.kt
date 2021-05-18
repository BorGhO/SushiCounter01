package com.keepon.sushicounter01

import android.content.Context

import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.keepon.sushicounter01.ui.ordineFolder.OrdineFragment

class MenuAdapter (data:ArrayList<PiattoClass>, var context: Context) : RecyclerView.Adapter<MenuAdapter.ViewHolder>(){


        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){   //qui si estende la proprità ViewHolder di Recy, che è il contenitore degli elementi

            internal var title: TextView
            internal var image: ImageView
            internal var desc: TextView
            internal var freccia: ImageView
            internal var categoria: String
            internal var descSelected: Boolean
            internal var indice: Int



            init{

                title = itemView.findViewById(R.id.piattoTitleText01)
                image = itemView.findViewById(R.id.piattoImage01)
                desc = itemView.findViewById(R.id.piattoDescText01)
                freccia = itemView.findViewById(R.id.openDesc01)
                indice = -1
                categoria = ""
                descSelected = false
            }

        }



    var data:List<PiattoClass> = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {     //va fatto l'override di tutti i metodi di RecyclerView.Adapter

            val layout = LayoutInflater.from(parent.context).inflate(R.layout.piatto_layout, parent, false)

/*
        var frag : OrdineFragment = OrdineFragment()

        orderVM = ViewModelProvider(frag).get(OrdineViewModel::class.java)*/

            return ViewHolder(layout)
        }



        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            holder.title.text = data[position].nome
            holder.desc.text = data[position].desc
            holder.image.setImageResource(data[position].img)
            holder.categoria = data[position].categ
            holder.descSelected = data[position].descSelected
            holder.indice = position



            descClick(holder)


            holder.title.setOnClickListener {
                println("cliccato titolo")
            }

            holder.freccia.setOnClickListener{


                data[position].descSelected = !data[position].descSelected
                holder.descSelected = data[position].descSelected

                println("cliccata freccia " + holder.descSelected)
                println("desc " + holder.desc.toString())
                descClick(holder)

                var frag : OrdineFragment = OrdineFragment()
                frag.insertInOrder(holder.indice)
            }
        }




        fun descClick(holded: ViewHolder){

            if(holded.descSelected) {
                holded.freccia.background = context.getDrawable(R.drawable.up_chevron)
                holded.desc.visibility = View.VISIBLE





            }else {
                holded.freccia.background = context.getDrawable(R.drawable.down_chevron)

                holded.desc.visibility = View.GONE

            }
        }

        override fun getItemCount(): Int{

            return data.size
        }




    }