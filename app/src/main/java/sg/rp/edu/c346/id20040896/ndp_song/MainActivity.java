package sg.rp.edu.c346.id20040896.ndp_song;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnShow;
    RadioGroup RGStar;
    RadioButton rb1,rb2,rb3,rb4,rb5;
    EditText etYear, etSong, etSinger;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.buttonInsert);
        btnShow = findViewById(R.id.buttonShowList);

        RGStar = findViewById(R.id.RGStar);
        etSinger = findViewById(R.id.etSinger);
        etSong = findViewById(R.id.etTitle);
        etYear = findViewById(R.id.etYear);



        btnInsert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String songs = etSong.getText().toString();
                String singer = etSinger.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int star = getStars();



                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(songs, singer, year,star);

                if (inserted_id != -1){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i  = new Intent(MainActivity.this, Show_activity.class);
                startActivity(i);

            }
        });

    }
    private int getStars(){
        int star = 0;
        if(RGStar.getCheckedRadioButtonId() == R.id.radioButton1){
            star = 1;
        }
        else if(RGStar.getCheckedRadioButtonId() == R.id.radioButton2) {
            star = 2;
        }
        else if(RGStar.getCheckedRadioButtonId() == R.id.radioButton3){
            star = 3;


        }
        else if(RGStar.getCheckedRadioButtonId() == R.id.radioButton4){
            star = 4;

        }
        else{
            star = 5 ;

        }
        return star;
    }
}