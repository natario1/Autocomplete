package com.otaliastudios.sample;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class MaleFemalePresenter extends UserPresenter implements TabLayout.OnTabSelectedListener {

    private boolean females;
    private CharSequence lastQuery;

    @SuppressWarnings("WeakerAccess")
    public MaleFemalePresenter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    protected ViewGroup getView() {
        // RecyclerViewPresenter returns a RecyclerView. We inflate it in a bigger container.
        ViewGroup rv = super.getView();
        ViewGroup container = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.male_female_popup, null);
        // Add RecyclerView to our container
        ViewGroup rvContainer = container.findViewById(R.id.recycler_view_container);
        rvContainer.addView(rv, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        // Set up bar that reacts to clicks and syncs with 'females' boolean
        TabLayout tabLayout = container.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Males"));
        tabLayout.addTab(tabLayout.newTab().setText("Females"));
        //noinspection ConstantConditions
        tabLayout.getTabAt(females ? 1 : 0).select();
        tabLayout.addOnTabSelectedListener(this);
        return container;
    }

    @Override
    protected void onQuery(@Nullable CharSequence query) {
        lastQuery = query;

        // First select males/females.
        List<User> all = new ArrayList<>();
        for (User u : User.USERS) {
            if (u.isFemale() == females) all.add(u);
        }

        // Then filter based on query.
        if (TextUtils.isEmpty(query)) {
            adapter.setData(all);
        } else {
            query = query.toString().toLowerCase();
            List<User> list = new ArrayList<>();
            for (User u : all) {
                if (u.getFullname().toLowerCase().contains(query) ||
                        u.getUsername().toLowerCase().contains(query)) {
                    list.add(u);
                }
            }
            adapter.setData(list);
            Log.e("MaleFemalePresenter", "found "+list.size()+" users for query "+query);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        females = !females;
        onQuery(lastQuery);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {}

    @Override
    public void onTabReselected(TabLayout.Tab tab) {}
}
