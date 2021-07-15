package sg.rp.edu.c346.id20040896.ndp_song;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    EditText etTitle, etSinger, etYear;
    RadioGroup RadioGrp;
    Button btnUpdate, btnDelete, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        etTitle = findViewById(R.id.etTitle1);
        etSinger = findViewById(R.id.etSinger1);
        etYear = findViewById(R.id.etYear1);
        RadioGrp = findViewById(R.id.RGStar5);
        btnCancel = findViewById(R.id.buttonCancel);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);
        Intent i = getIntent();
        Song data;
        data = (Song) i.getSerializableExtra("id");
        etTitle.setText(data.getTitle());
        etSinger.setText(data.getSinger());
        etYear.setText(data.getYear());
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String songs = etTitle.getText().toString();
                String singer = etSinger.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int star = getStars();




                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setTitle(songs);
                data.setSinger(singer);
                data.setYear(year);
                data.setStar(star);
                dbh.updateSong(data);
                dbh.close();

                    Toast.makeText(EditActivity.this, "Insert successful", Toast.LENGTH_LONG).show();

            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                int id = Integer.parseInt(i.getStringExtra("id"));
                dbh.deleteSong(id);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public int getStars(){
        int star = 0;
        if(RadioGrp.getCheckedRadioButtonId() == R.id.radioButton1){
            star = 1;
        }
        else if(RadioGrp.getCheckedRadioButtonId() == R.id.radioButton2) {
            star = 2;
        }
        else if(RadioGrp.getCheckedRadioButtonId() == R.id.radioButton3){
            star = 3;


        }
        else if(RadioGrp.getCheckedRadioButtonId() == R.id.radioButton4){
            star = 4;

        }
        else{
            star = 5 ;

        }
        return star;
    }

    }
