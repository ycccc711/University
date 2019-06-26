package sg.edu.rp.c346.university;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class hungry extends AppCompatActivity {

    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hungry);

        tvText = findViewById(R.id.textViewText);

        registerForContextMenu(tvText);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.itemBreakfast){
            Log.d("Hungry Menu","Eat breakfast like a king");
            return true;
        }else if (id == R.id.itemLunch){
            Log.e("Hungry Menu","Is there free lunch?");
            return true;
        }

        return super.onContextItemSelected(item);
    }

}
