/**
 * Created by sancgoel on 8/11/2015.
 * Disclaimer: This is the property of BookWorms Corporation. Any reproduction of the material here in any form is liable to legal action.
 */

package com.android.bookwrms.model;

public class BookCategoryItem {
    private String title;
    private int icon;

    public BookCategoryItem(){}

    public BookCategoryItem(String title, int icon){
        this.title = title;
        this.icon = icon;
    }


    public String getTitle(){
        return this.title;
    }

    public int getIcon(){
        return this.icon;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setIcon(int icon){
        this.icon = icon;
    }
}
