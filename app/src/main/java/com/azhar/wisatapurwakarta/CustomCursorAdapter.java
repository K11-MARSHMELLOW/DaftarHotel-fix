package com.azhar.wisatapurwakarta;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


public class CustomCursorAdapter extends CursorAdapter {

    private LayoutInflater layoutInflater;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CustomCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v = layoutInflater.inflate(R.layout.row_data, viewGroup, false);
        MyHolder holder = new MyHolder();
        holder.ListID = (TextView)v.findViewById(R.id.listID);
        holder.ListNama = (TextView)v.findViewById(R.id.listNama);
        v.setTag(holder);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        MyHolder holder = (MyHolder)view.getTag();

        holder.ListID.setText(cursor.getString(cursor.getColumnIndex(com.azhar.wisatapurwakarta.DBHelper.row_id)));
        holder.ListNama.setText(cursor.getString(cursor.getColumnIndex(com.azhar.wisatapurwakarta.DBHelper.row_nama)));
    }

    class MyHolder{
        TextView ListID;
        TextView ListNama;
    }
}
