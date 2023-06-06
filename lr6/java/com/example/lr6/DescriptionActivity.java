package com.example.lr6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.mapkit.geometry.Point;

public class DescriptionActivity extends AppCompatActivity {
    private TextView description;
    private Landmark landmark;
    private MapView map;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_description);

        map = findViewById(R.id.mapview);
        description = findViewById(R.id.description);
        img = findViewById(R.id.landmarkImage);

        getDescription();
        setTitle(landmark.getName());
        getLandmarkOnMap();
    }

    public void getDescription(){
        landmark = getIntent().getParcelableExtra(Landmark.class.getCanonicalName());
        description.setText(landmark.getDescription());
        img.setImageResource(landmark.getImg());
    }

    @Override
    protected void onStop() {
        map.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        map.onStart();
    }

    public void getLandmarkOnMap(){
        map.getMap().move(
                new CameraPosition(landmark.getPoint(), 13.5f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 5),
                null);
        map.getMap().getMapObjects().addPlacemark(landmark.getPoint());
    }
}