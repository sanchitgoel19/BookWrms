/**
 * Created by jaiswal on 08/08/15.
 * Disclaimer: This is the property of BookWorms Corporation. Any reproduction of the material here in any form is liable to legal action.
 */

package com.android.bookwrms.bookwrms;

import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

public class PagerFragmentAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 4;
    private Context context;

    public PagerFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        /**
         * TODO::switch case here to return fragment for the relevant tab after implemented per tab fragment
         */
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    public View getTabView(int i){

        View v;
        switch (i){

            case 0 :
                v = LayoutInflater.from(context).inflate(R.layout.custom_actiontab_home, null);
                break;

            case 1:
                v = LayoutInflater.from(context).inflate(R.layout.custom_actiontab_account, null);
                break;

            case 2:
                v = LayoutInflater.from(context).inflate(R.layout.custom_actiontab_subscriptions, null);
                break;

            case 3:
                v = LayoutInflater.from(context).inflate(R.layout.custom_actiontab_exchange, null);
                break;

            default:
                v = LayoutInflater.from(context).inflate(R.layout.custom_actiontab_home, null);
                break;
        }
        return v;
    }
}
