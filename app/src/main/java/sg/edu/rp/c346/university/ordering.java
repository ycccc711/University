package sg.edu.rp.c346.university;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;

public class ordering extends AppCompatActivity {

    TextView tvCollectionTime,tvRewards;
    CheckBox cbLessOil, cbMoreVegetables;
    TimePicker timePicker1;
    Button btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering);

        cbLessOil = findViewById(R.id.checkBox);
        cbMoreVegetables = findViewById(R.id.checkBox2);
        timePicker1 = findViewById(R.id.timePicker);
        btnNext = findViewById(R.id.buttonNext);
        tvCollectionTime = findViewById(R.id.textViewCollectionTime);
        tvRewards = findViewById(R.id.textViewRewards);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hr=timePicker1.getCurrentHour();
                int mins=timePicker1.getCurrentMinute();
                tvCollectionTime.setText("Your collection time is"+hr+":"+mins);

                int point = 0;

                if(cbLessOil.isChecked() && cbMoreVegetables.isChecked()) {
                    point += 3;
                }
                else if (cbLessOil.isChecked()) {
                    point += 1;
                }else if(cbMoreVegetables.isChecked()){
                    point += 1;
                }
                tvRewards.setText("Reward Points: "+point);
            }
        });


    }
}
