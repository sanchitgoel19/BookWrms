/**
 * Created by jaiswal on 08/08/15.
 * Disclaimer: This is the property of BookWorms Corporation. Any reproduction of the material here in any form is liable to legal action.
 */

package com.android.bookwrms.bookwrms;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
