package com.example.bottom


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class DrillsAdapter(var context: Context, var data:ArrayList<Drills>):BaseAdapter() {
    private class ViewHolder(row:View?){
        var mTxtTitle:TextView
        var mTxtDrill:TextView
        init {
            this.mTxtTitle = row?.findViewById(R.id.mTvTitle) as TextView
            this.mTxtDrill = row?.findViewById(R.id.mTvDrill) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.list_view,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:Drills = getItem(position) as Drills
        viewHolder.mTxtTitle.text = item.title
        viewHolder.mTxtDrill.text = item.drill
        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}