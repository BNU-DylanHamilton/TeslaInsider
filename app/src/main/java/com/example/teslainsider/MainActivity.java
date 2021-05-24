package com.example.teslainsider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    public String email, question;
    EditText emailInput;
    EditText questionInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }

    /** The method below allows the user to be able to navigate from each of the main pages within the application **/
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment fragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.news:
                            fragment = new NewsFragment();
                            break;

                        case R.id.home:
                            fragment = new HomeFragment();
                            break;

                        case R.id.car:
                            fragment = new ProductsFragment();
                            break;

                        case R.id.help:
                            fragment = new HelpFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

                    return true;
                }
            };


    /** The next 8 methods are for the buttons on the news page to redirect the user to the articles on the official Tesla website. **/
    public void Open1(View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tesla.com/en_GB/blog/model-3-lowest-probability-injury-any-vehicle-ever-tested-nhtsa#:~:text=Based%20on%20the%20advanced%20architecture,the%20safest%20car%20ever%20built."));
        startActivity(browserIntent);
    }

    public void Open2(View view) {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tesla.com/en_GB/blog/model-y-achieves-5-star-overall-safety-rating-nhtsa"));
        startActivity(browserIntent);
    }

    public void Open3(View view) {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tesla.com/en_GB/blog/accelerating-teslas-safety-culture"));
        startActivity(browserIntent);
    }

    public void Open4(View view) {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tesla.com/en_GB/blog/model-s-long-range-plus-building-first-400-mile-electric-vehicle"));
        startActivity(browserIntent);
    }

    public void Open5(View view) {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tesla.com/en_GB/blog/introducing-software-version-10-0"));
        startActivity(browserIntent);
    }

    public void Open6(View view) {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tesla.com/en_GB/blog/model-x-earns-5-star-safety-rating-euro-ncap"));
        startActivity(browserIntent);
    }

    public void Open7(View view) {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tesla.com/en_GB/blog/model-3-earns-2019-iihs-top-safety-pick-award"));
        startActivity(browserIntent);
    }

    public void Open8(View view) {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tesla.com/en_GB/blog"));
        startActivity(browserIntent);
    }

    /** The code below is for the button on the help section to send an email to the 'creator' or the application **/
    public void send(View view) {
        EditText subject = (EditText) findViewById(R.id.editTextTextEmailAddress);
        EditText email = (EditText) findViewById(R.id.editTextTextMultiLine);


        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","dylan.hamilton123@hotmail.com", null));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText());
        intent.putExtra(Intent.EXTRA_TEXT, email.getText());
        startActivity(Intent.createChooser(intent, "Choose an email client: "));
    }
}