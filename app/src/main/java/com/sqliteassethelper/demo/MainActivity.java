package com.sqliteassethelper.demo;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MyDatabase myDatabase;
    private ArrayList<Poses> t1;
    private ArrayList<Poses> t2;
    private ArrayList<Poses> t3;
    private ArrayList<Poses> t4;
    private ArrayList<Poses> t5;
    private ArrayList<Poses> t6;
    private ArrayList<Poses> t7;
    private ArrayList<Poses> t8;

   // ArrayList<Sectionsub_method> actorsList;
   // SectionsubAdapter adapter;
   // ListView listview;

    ViewPager viewPager;
    PagerAdapter adapter;
    String[] text1;
    String[] text2;
    String[] text3;
    String[] text4;
    String[] text5;

    Timer timer;
    int page = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabase=new MyDatabase(MainActivity.this);

        t1=myDatabase.getPoses();
        t2=myDatabase.getPoses();
        t3=myDatabase.getPoses();
        t4=myDatabase.getPoses();
        t5=myDatabase.getPoses();
        t6=myDatabase.getPoses();
        t7=myDatabase.getPoses();
        t8=myDatabase.getPoses();

        text1 = new String[t1.size()];
        text2 = new String[t1.size()];
        text3 = new String[t1.size()];
        text4 = new String[t1.size()];
        text5 = new String[t1.size()];
       // actorsList = new ArrayList<Sectionsub_method>();
       // listview = (ListView)findViewById(R.id.listsection);

        for(int i=0;i<t1.size();i++)
        {

            text1[i]=t1.get(i).t1+"";
            text2[i]=t2.get(i).t2+"";
            text3[i]=t3.get(i).t3+"";
            text4[i]=t4.get(i).t4+"";
            text5[i]=t5.get(i).t5+"";
            Log.e(" category filter",t1.get(i).t1+"");
            Log.e(" category filter",t5.get(i).t5+"");
            // actorsList.add(new Sectionsub_method(t1.get(i).t1.toString(),t2.get(i).t2.toString(),t3.get(i).t3.toString(),t4.get(i).t4.toString(),t5.get(i).t5.toString(),t6.get(i).t6.toString(),t7.get(i).t7.toString(),t8.get(i).t8.toString()));

        }

         viewPager = (ViewPager) findViewById(R.id.pager);
         adapter = new ViewPagerAdapter(MainActivity.this, text1, text2, text3, text4,text5);
         viewPager.setAdapter(adapter);
        pageSwitcher(1);


        //adapter = new SectionsubAdapter(getApplication(),actorsList);
        //listview.setAdapter(adapter);
        //adapter.notifyDataSetChanged();


    }
    class RemindTask extends TimerTask {

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {

                    if (page > 12)
                    { // In my case the number of pages are 5
                        timer.cancel();
                        // Showing a toast for just testing purpose
                        Toast.makeText(getApplicationContext(), "Timer stoped", Toast.LENGTH_LONG).show();
                    } else {
                        viewPager.setCurrentItem(page++);
                    }
                }
            });

        }
    }

    public void pageSwitcher(int seconds) {
        timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay
        // in
        // milliseconds
    }
}
