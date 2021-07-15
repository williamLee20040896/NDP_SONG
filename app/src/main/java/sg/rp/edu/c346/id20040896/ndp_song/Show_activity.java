package sg.rp.edu.c346.id20040896.ndp_song;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Show_activity extends AppCompatActivity {
    ListView lv;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;
    Button btnAllstar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_activity);
        Intent i = getIntent();
        lv = findViewById(R.id.listView1);
        btnAllstar = findViewById(R.id.buttonAllStar);
        DBHelper dbh = new DBHelper(Show_activity.this);
        al = new ArrayList<Song>();
        al.addAll(dbh.getAllSong());
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);

        lv.setAdapter(aa);


        btnAllstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(Show_activity.this);

                al.addAll(dbh.getAllSong("5"));
                aa.notifyDataSetChanged();

            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song data = al.get(position);
                Intent i = new Intent(Show_activity.this, EditActivity.class);
                i.putExtra("id", data);
                startActivity(i);
            }
        });
    }










    }
