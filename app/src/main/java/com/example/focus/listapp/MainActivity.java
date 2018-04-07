package com.example.focus.listapp;

import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private SearchFragment searchFragment;
    private CreateFragment createFragment;
    private BookmarksFragment bookmarksFragment;
    private ProfileFragment profileFragment;


    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Contact> list = new ArrayList<Contact>();

    int[] image_id = {R.drawable.road, R.drawable.tracks, R.drawable.beach, R.drawable.icemashine};
    String[] name, shortDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //------adding frames stuff
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame = findViewById(R.id.main_frame);
        mMainNav = findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        searchFragment = new SearchFragment();
        createFragment = new CreateFragment();
        bookmarksFragment = new BookmarksFragment();
        profileFragment = new ProfileFragment();

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home :
                        setFragment(homeFragment);
                        return true;
                    case R.id.nav_search:
                        setFragment(searchFragment);
                        return true;
                    case R.id.nav_create:
                        setFragment(createFragment);
                        return true;
                    case R.id.nav_bookmarks:
                        setFragment(bookmarksFragment);
                        return true;
                    case R.id.nav_profile:
                        setFragment(profileFragment);
                        return true;
                        default:
                            return false;

                }
            }
        });

        //------end of adding frames stuff

        name = getResources().getStringArray(R.array.project_names);
        shortDescription = getResources().getStringArray(R.array.project_short_description);
        int i = 0;
        for (String name: name) {
            Contact contact = new Contact(image_id[i],name, shortDescription[i]);
            i++;
            list.add(contact);
        }
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new ContactAdapter(list);
        recyclerView.setAdapter(adapter);

    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
}
