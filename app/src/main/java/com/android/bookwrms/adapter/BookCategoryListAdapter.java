/**
 * Created by sancgoel on 8/11/2015.
 * Disclaimer: This is the property of BookWorms Corporation. Any reproduction of the material here in any form is liable to legal action.
 */

package com.android.bookwrms.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.bookwrms.bookwrms.R;
import com.android.bookwrms.model.BookCategoryItem;


public class BookCategoryListAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<BookCategoryItem> bookCategoryItems;

    public BookCategoryListAdapter(Context context, ArrayList<BookCategoryItem> bookCategoryItems){
        this.context = context;
        this.bookCategoryItems = bookCategoryItems;
    }

    @Override
    public int getCount() {
        return bookCategoryItems.size();
    }

    @Override
    public Object getItem(int position) {
        return bookCategoryItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);

        imgIcon.setImageResource(bookCategoryItems.get(position).getIcon());
        txtTitle.setText(bookCategoryItems.get(position).getTitle());

        return convertView;
    }
}
