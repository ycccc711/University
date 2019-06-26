package sg.edu.rp.c346.university;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MSA extends AppCompatActivity {

    DatePicker dpRegister;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msa);

        dpRegister = findViewById(R.id.datePickerRegister);
        btnSubmit = findViewById(R.id.buttonSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int currentYear = calendar.get(Calendar.YEAR);
                
                int year = dpRegister.getYear();
                
                if(year > currentYear){
                    Toast.makeText(MSA.this, "Error: Future Year is not allowed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
