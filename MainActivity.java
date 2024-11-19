spackage com.example.colorselectionapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView colorListView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to UI elements
        colorListView = findViewById(R.id.colorListView);
        frameLayout = findViewById(R.id.frameLayout);

        // List of color names
        String[] colorNames = {"Red", "Green", "Blue", "Yellow", "Cyan", "Magenta", "Black", "White"};
        
        // Array of corresponding color values
        final String[] colorValues = {"#FF0000", "#00FF00", "#0000FF", "#FFFF00", "#00FFFF", "#FF00FF", "#000000", "#FFFFFF"};
        
        // Create an adapter to display color names
        ArrayAdapter<String> colorAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, colorNames);
        colorListView.setAdapter(colorAdapter);

        // Set item click listener for ListView
        colorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected color
                String selectedColor = colorValues[position];
                
                // Change the background color of the FrameLayout
                frameLayout.setBackgroundColor(Color.parseColor(selectedColor));
            }
        });
    }
}
