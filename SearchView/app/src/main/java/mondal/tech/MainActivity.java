package mondal.tech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private ArrayList<String> countryName;
    private ArrayList<String> anotherCountryName=null;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.appToolbar);
        setSupportActionBar(toolbar);


//        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//                if(status==TextToSpeech.SUCCESS)
//                {
//                    int result=textToSpeech.setLanguage(Locale.US);
//                    if(result!=TextToSpeech.LANG_NOT_SUPPORTED || result!=TextToSpeech.LANG_MISSING_DATA)
//                    {
//                        textToSpeech.setSpeechRate(0.9f);
//                        textToSpeech.speak("HELLO NISITH ISS APP MAY UP KA SAWAGAT HAY",TextToSpeech.QUEUE_FLUSH,null);
//                    }
//                }
//            }
//        });



        countryName=new ArrayList<String>();
        String []country=getResources().getStringArray(R.array.country);
        for(String name:country)
        {
            countryName.add(name);
        }
        recyclerView=findViewById(R.id.recyclerview);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        myRecyclerViewAdapter=new MyRecyclerViewAdapter(this,countryName);
        recyclerView.setAdapter(myRecyclerViewAdapter);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.app_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView=(SearchView) menuItem.getActionView();
       searchView.setOnQueryTextListener(new MySearchView());

       menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
           @Override
           public boolean onMenuItemActionExpand(MenuItem item) {
                   anotherCountryName=new ArrayList<String>();
//               Log.e("ABCD","onMenuItemActionExpand IS cALLED");
               return true;
           }

           @Override
           public boolean onMenuItemActionCollapse(MenuItem item) {
               myRecyclerViewAdapter.setDataSource(countryName);
               myRecyclerViewAdapter.notifyDataSetChanged();
               anotherCountryName=null;
//               Log.d("ABCD","onMenuItemActionCollapse IS cALLED");
               return true;
           }
       });


        return true;
    }

    public  class MySearchView implements SearchView.OnQueryTextListener
    {

        @Override
        public boolean onQueryTextSubmit(String s) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String s) {
            if (anotherCountryName!=null)
            {
                anotherCountryName.removeAll(anotherCountryName);
            }
            String inputText=s.toUpperCase();
            if (s.length()>0)
            {
                for (String name:countryName)
                {
                    if (name.contains(inputText))
                    {
                        anotherCountryName.add(name);
                    }
                }
                    myRecyclerViewAdapter.setDataSource(anotherCountryName);
                    myRecyclerViewAdapter.notifyDataSetChanged();
            }
            else
            {
                myRecyclerViewAdapter.setDataSource(countryName);
                myRecyclerViewAdapter.notifyDataSetChanged();
            }
            return true;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(textToSpeech!=null)
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}


















































