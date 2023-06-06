package com.example.lr6;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yandex.mapkit.geometry.Point;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ArrayList<Landmark> landmarks;
    private ListView listView;
    private User user;
    private TextView hello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        hello = findViewById(R.id.hello);
        listView = findViewById(R.id.listView);

        helloUser();
        setAdapter();

        listViewListener();
    }

    public void listViewListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this, DescriptionActivity.class);
                Landmark l = (Landmark) listView.getItemAtPosition(position);
                intent.putExtra(Landmark.class.getCanonicalName(), l);
                startActivity(intent);
            }
        });
    }

    public void helloUser(){
        user = getIntent().getExtras().getParcelable(User.class.getCanonicalName());
        hello.setText("Hello, "+user.getName()+"!");
    }

    public void setAdapter(){
        landmarks = new ArrayList<>();
        Landmark mysticGrill = new Landmark("Mystic Grill", R.string.mysticGrill, "11am-9pm", new Point(33.596836f,-83.859907f), R.drawable.landmarks_mystic_grill); landmarks.add(mysticGrill);
        Landmark clockTower = new Landmark("Clock Tower", R.string.clockTower, "1pm-5pm", new Point(33.596851f,-83.860209f), R.drawable.landmarks_clock_tower); landmarks.add(clockTower);
        Landmark egHouse = new Landmark("Elena Gilbert's house", R.string.egHome, new Point(33.596552f, -83.8581473f), R.drawable.landmarks_elenas_house); landmarks.add(egHouse);
        Landmark theLockwoodMansion = new Landmark("the Lockwood mansion", R.string.theLockwoodMansion, new Point(33.5959348f, -83.8540533f), R.drawable.landmarks_lockwood); landmarks.add(theLockwoodMansion);
        Landmark theSalvatoreBoardingHouse = new Landmark("the Salvatore Boarding House", R.string.theSalvatoreMansion, new Point(33.9358963f, -84.3648688f)); landmarks.add(theSalvatoreBoardingHouse);
        ArrayAdapter<Landmark> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,landmarks);
        listView.setAdapter(adapter);
    }
}