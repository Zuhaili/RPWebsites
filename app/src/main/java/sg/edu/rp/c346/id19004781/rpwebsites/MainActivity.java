package sg.edu.rp.c346.id19004781.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1, spn2;
    Button btnGo;
    ArrayList<String> alRP;
    ArrayAdapter<String> aaRP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.button);

        // Initialise the ArrayList
        alRP = new ArrayList<>();

        //Get the string-array and store as an Array
        String[] strSubCategory = getResources().getStringArray(R.array.sub_category);

        //Convert Array to List and add to the ArrayList
        alRP.addAll(Arrays.asList(strSubCategory));


        // Create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaRP = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alRP);

        // Bind the ArrayAdapter to the Spinner
        spn2.setAdapter(aaRP);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                alRP.clear();

                if (position == 0) {
                    String[] strCategory = getResources().getStringArray(R.array.sub_category);
                    alRP.addAll(Arrays.asList(strCategory));
                } else {
                    String[] strCategory = getResources().getStringArray(R.array.sub_category1);
                    alRP.addAll(Arrays.asList(strCategory));
                }
                aaRP.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int categoryPos = spn1.getSelectedItemPosition();
                int subcategoryPos = spn2.getSelectedItemPosition();

                if (categoryPos == 0 && subcategoryPos == 0) {
                    String url = "https://www.rp.edu.sg/";
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    intent.putExtra("value", url);
                    startActivity(intent);
                } else if (categoryPos == 0 && subcategoryPos == 1){
                    String url = "https://www.rp.edu.sg/student-life";
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    intent.putExtra("value", url);
                    startActivity(intent);
                } else if (categoryPos == 1 && subcategoryPos == 0){
                    String url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    intent.putExtra("value", url);
                    startActivity(intent);
                } else if (categoryPos == 1 && subcategoryPos == 1){
                    String url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    intent.putExtra("value", url);
                    startActivity(intent);
                }

            }
        });
    }
}
