package com.nacer.customlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView maListViewPerso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        maListViewPerso = findViewById(R.id.listviewperso);

        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();
        HashMap<String, String> map;

        map = new HashMap<>();
        map.put("title", "word");
        map.put("description", "Editeur de texte");
        map.put("img", String.valueOf(R.drawable.word));
        listItem.add(map);


        map = new HashMap<>();
        map.put("title", "excel");
        map.put("description", "tableur");
        map.put("img", String.valueOf(R.drawable.excel));
        listItem.add(map);


        map = new HashMap<>();
        map.put("title", "outlook");
        map.put("description", "courier electronique");
        map.put("img", String.valueOf(R.drawable.outlook));
        listItem.add(map);


        map = new HashMap<>();
        map.put("title", "powerpoint");
        map.put("description", "logiciel de presentation");
        map.put("img", String.valueOf(R.drawable.powerpoint));
        listItem.add(map);


        SimpleAdapter adapter = new SimpleAdapter(this.getBaseContext(),
                listItem,
                R.layout.activity_list_item,
                new String[]{"img", "title", "description"},
                new int[]{R.id.img, R.id.titre, R.id.description});

        maListViewPerso.setAdapter(adapter);

      maListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              HashMap<String,String>map = (HashMap <String,String>) maListViewPerso.getItemAtPosition(position);
              Toast.makeText(MainActivity.this,map.get("title"), Toast.LENGTH_SHORT).show();
          }
      });
        maListViewPerso.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,String>map = (HashMap <String,String>) maListViewPerso.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,map.get("description"), Toast.LENGTH_SHORT).show();

                AlertDialog.Builder adb= new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Selection Item");
                adb.setMessage("votre choix : " + map.get("title"));
                adb.setPositiveButton("OK",null);
                adb.show();
                return true;


            }
        });


    }
}