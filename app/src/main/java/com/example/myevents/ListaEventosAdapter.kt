package com.example.myevents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class ListaEventosAdapter (context: Context,dataArrayList: ArrayList<ListaData?>?):
    ArrayAdapter<ListaData?>(context, R.layout.list_item,
        dataArrayList!!) {

    override fun getView(position: Int, view: View?, parent:
    ViewGroup): View {

        var view = view
        val listData = getItem(position)
        if (view == null) {
            view =

                LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }
        val listImg = view!!.findViewById<ImageView>(R.id.listImg)
        val listTitle = view.findViewById<TextView>(R.id.listTitle)
        val listDescricao = view.findViewById<TextView>(R.id.listdescricao)

        listImg.setImageResource(listData!!.image)
        listTitle.text = listData.title
        listDescricao.text = listData.desc
        return view

    }


}