package com.example.esiea3a

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class LivreAdapter(private val context: Context,
                   private val dataSource: ArrayList<Livre>
) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.view_modele, parent, false)

        val titleTextView = rowView.findViewById(R.id.txt_titre) as TextView
        var itm = dataSource.get(position)
        titleTextView.setText(itm.name);

        val anneeTextView = rowView.findViewById(R.id.txt_annee) as TextView
        anneeTextView.setText("Annee: " + itm.annee.toString());

        return rowView
    }

    override fun getItem(position: Int): Livre {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

}