package com.boleng.contentprovider;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by boleng on 8/28/17.
 */

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private Cursor mCursor;

    public MyAdapter(Context context, Cursor cursor) {
        this.mContext = context;
        this.mCursor = cursor;
    }


    @Override
    public int getCount() {
        if (mCursor == null) {
            return 0;
        }
        return mCursor.getCount();
    }

    @Override
    public Object getItem(int position) {
        if (mCursor != null) {
            mCursor.moveToPosition(position);
            return mCursor;
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        if (mCursor!=null){
            if(mCursor.moveToPosition(position)){
                return mCursor.getLong(mCursor.getColumnIndex("_id"));
            }else {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item, parent);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.age = (TextView) convertView.findViewById(R.id.txtAge);
            viewHolder.introduce = (TextView) convertView.findViewById(R.id.txtIntroduce);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        mCursor.moveToPosition(position);
        viewHolder.name.setText("name: " + mCursor.getString(mCursor.getColumnIndex("name")));
        viewHolder.age.setText(" age: " + mCursor.getInt(mCursor.getColumnIndex("age")));
        viewHolder.introduce.setText(" introduce: " + mCursor.getString(mCursor.getColumnIndex("introduce")));
        return convertView;
    }

    static class ViewHolder {
        public TextView name;
        public TextView age;
        public TextView introduce;
    }
}
