package sg.edu.rp.c346.university;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class email extends AppCompatActivity {

    ListView emailList;
    ArrayList<String> emails;
    ArrayAdapter<String> emailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);


        emailList = findViewById(R.id.emailList);

        //populate the arraylist!!!
        emails = new ArrayList<>();
        emails.add("annie@gmail.com");
        emails.add("jeff@gmail.com");

        emailAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,emails);
        emailList.setAdapter(emailAdapter);

        emailList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String subject = "Test Email";
                String content = "This is a test";
                String [] recipients = new String[1];
                recipients[0] = emails.get(position);

                Intent intentEmail = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
                intentEmail.putExtra(Intent.EXTRA_EMAIL,recipients);
                intentEmail.putExtra(Intent.EXTRA_SUBJECT,subject);
                intentEmail.putExtra(Intent.EXTRA_TEXT,content);

                intentEmail.setType("text/plain");
                startActivity(intentEmail);
                //
            }
        });

    }
}
