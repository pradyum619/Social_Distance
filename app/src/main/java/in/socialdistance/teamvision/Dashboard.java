package in.socialdistance.teamvision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gr.escsoft.michaelprimez.searchablespinner.SearchableSpinner;

public class Dashboard extends AppCompatActivity {

    private SearchableSpinner state_spinner, city_spinner;
    private TextView state_tv, city_tv;
    private ListView area_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // make full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //hanndling system UI hide unhide
        Window w = getWindow();
        w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        hideSystemUI();

        setContentView(R.layout.activity_dashboard);

        //link layout components
        state_spinner = findViewById(R.id.state_spinner);
        city_spinner = findViewById(R.id.city_spinner);
        area_list = findViewById(R.id.area_list);

        //load lists for each
        ArrayList<String> state_list = new ArrayList<String>
                (Arrays.asList(getResources().getStringArray(R.array.state_array)));
        ArrayList<String> city_list = new ArrayList<String>
                (Arrays.asList(getResources().getStringArray(R.array.city_array)));


        //join adapters
        ArrayAdapter state_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,state_list);
        state_spinner.setAdapter(state_adapter);
        ArrayAdapter city_adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,city_list);
        city_spinner.setAdapter(city_adapter);

        //listview Settings
        String[] testArray = getResources().getStringArray(R.array.area_array);
        List<String> testList = Arrays.asList(testArray);

        // Instanciating Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getBaseContext(),
                android.R.layout.simple_list_item_1, testList);

        // setting adapter on listview
        area_list.setAdapter(adapter);
//
//        //setOnCLickListeners
//        state_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
//                if(position == 0){
//                    Toast.makeText(Dashboard.this, "Select one state", Toast.LENGTH_SHORT).show();
//                } else {
//                    state_tv.setText(parent.getItemAtPosition(position).toString());
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//                Toast.makeText(Dashboard.this, "Select one state", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
//                if(position == 0){
//                    Toast.makeText(Dashboard.this, "Select one state", Toast.LENGTH_SHORT).show();
//                } else {
//                    state_tv.setText(parent.getItemAtPosition(position).toString());
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//                Toast.makeText(Dashboard.this, "Select one state", Toast.LENGTH_SHORT).show();
//            }
//        });

    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        //| View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        //| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        //| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                //| View.SYSTEM_UI_FLAG_FULLSCREEN
        );
    }
}

