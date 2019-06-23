package sg.edu.rp.c346.university;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> alUni = new ArrayList<String>();
    ArrayAdapter<String> aaUni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvUni);

        alUni.add("NUS");
        alUni.add("NTU");

        aaUni = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alUni);
        lv.setAdapter(aaUni);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(aaUni.getItem(0).equals("NUS")){
                    String nuss = getResources().getString((R.string.nus_website));
                    Intent nus = new Intent(Intent.ACTION_VIEW, Uri.parse(nuss));
                    aaUni.notifyDataSetChanged();
                    startActivity(nus);

                }
                else if(aaUni.getItem(1).equals("NTU")){
                    String ntuu = getResources().getString((R.string.ntu_website));
                    Intent ntu = new Intent(Intent.ACTION_VIEW, Uri.parse(ntuu));
                    aaUni.notifyDataSetChanged();
                    startActivity(ntu);

                }
                else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
