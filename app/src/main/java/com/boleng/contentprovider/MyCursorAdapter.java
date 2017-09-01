package com.boleng.contentprovider;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by boleng on 8/28/17.
 */

public class MyCursorAdapter extends CursorAdapter {

    public MyCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        ViewHolder viewHolder=new ViewHolder();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE );
        View convertView=inflater.inflate(R.layout.item ,parent,false);
        viewHolder.name= (TextView) convertView.findViewById(R.id.txtName);
        viewHolder.age= (TextView) convertView.findViewById(R.id.txtAge);
        viewHolder.introduce= (TextView) convertView.findViewById(R.id.txtIntroduce);
        convertView.setTag(viewHolder);
        return convertView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder= (ViewHolder) view.getTag();
        viewHolder.name.setText("name : "+cursor.getString(cursor.getColumnIndex("name")));
        viewHolder.age.setText(" age : "+cursor.getInt(cursor.getColumnIndex("age"))+"");
        viewHolder.introduce.setText(" introduce : "+cursor.getString(cursor.getColumnIndex("introduce")));
    }

    @Override
    public void changeCursor(Cursor cursor) {
        super.changeCursor(cursor);
    }


    static class ViewHolder
    {
        public TextView name;
        public TextView age;
        public TextView introduce;
    }
}
