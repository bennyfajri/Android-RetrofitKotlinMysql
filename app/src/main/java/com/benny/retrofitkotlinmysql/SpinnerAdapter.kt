package com.benny.retrofitkotlinmysql

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView

class SpinnerAdapter(val context: Context, var arrayItem: Array<Int>) : BaseAdapter(), Filterable{
    override fun getCount(): Int {
        if(arrayItem.size == 0){
            return 0
        }else{
            return  arrayItem.size
        }
    }

    override fun getItem(position: Int): Any {
        return arrayItem[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        view = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        val tv1 = view.findViewById<TextView>(android.R.id.text1)
        tv1.text = arrayItem[position].toString()
        return view
    }

    private val filter_that_does_nothing = object : Filter(){
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val result = FilterResults()
            result.values = arrayItem
            result.count = arrayItem.size
            return result
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            notifyDataSetChanged()
        }

    }

    override fun getFilter(): Filter {
        return filter_that_does_nothing
    }

}