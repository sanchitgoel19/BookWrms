/**
 * Created by jaiswal on 08/08/15.
 * Disclaimer: This is the property of BookWorms Corporation. Any reproduction of the material here in any form is liable to legal action.
 */

package com.android.bookwrms.bookwrms;


import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.bookwrms.adapter.BookCategoryListAdapter;
import com.android.bookwrms.model.BookCategoryItem;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private String[] mBookCategories;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private BookCategoryListAdapter mAdapter;
    private ArrayList<BookCategoryItem> mBookCategoryItems;
    private TypedArray mBookCategoryIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        PagerFragmentAdapter pagerAdapter = new PagerFragmentAdapter(getSupportFragmentManager(), MainActivity.this);
        viewPager.setAdapter(pagerAdapter);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        getCustomTabViews(tabLayout, pagerAdapter);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private void getCustomTabViews(TabLayout tabLayout, PagerFragmentAdapter pagerAdapter) {
        for (short itr = 0; itr < tabLayout.getTabCount() ; itr++){
            TabLayout.Tab tab = tabLayout.getTabAt(itr);
            tab.setCustomView(pagerAdapter.getTabView(itr));
        }
        initializeFlyOutDrawer();

    }

    private void initializeFlyOutDrawer (){

        //Load FlyOut Menu Items i.e. Book Categories
        mBookCategories = getResources().getStringArray(R.array.books_categories);
        // Fly out menu icons from resources
        mBookCategoryIcons = getResources().obtainTypedArray(R.array.books_categories_icons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mBookCategoryItems = new ArrayList<BookCategoryItem>();

        // adding Books Category items to array
        // Fiction
        mBookCategoryItems.add(new BookCategoryItem(mBookCategories[0], mBookCategoryIcons.getResourceId(0, -1)));
        // Comics
        mBookCategoryItems.add(new BookCategoryItem(mBookCategories[1], mBookCategoryIcons.getResourceId(1, -1)));
        // Literature
        mBookCategoryItems.add(new BookCategoryItem(mBookCategories[2], mBookCategoryIcons.getResourceId(2, -1)));
        // Romantic
        mBookCategoryItems.add(new BookCategoryItem(mBookCategories[3], mBookCategoryIcons.getResourceId(3, -1)));

        // setting the nav drawer list adapter
        mAdapter = new BookCategoryListAdapter(getApplicationContext(), mBookCategoryItems);
        mDrawerList.setAdapter(mAdapter);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        // Recycle the typed array
        mBookCategoryIcons.recycle();
    }

    /**
     * Displaying fragment view for selected nav drawer list item
     * */
    private void displayView(int position) {

           // update selected item, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            mDrawerLayout.closeDrawer(mDrawerList);

    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {

        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            //Display view for selected Book Category
            displayView(position);
        }
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        return super.onPrepareOptionsMenu(menu);
    }

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        /**
         * TODO::Fix the issue of drawer not opening on app logo click
         */
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()){

            case R.id.action_bar_search:
                break;

            case R.id.action_bar_cart:
                break;

            case R.id.action_bar_alert:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
