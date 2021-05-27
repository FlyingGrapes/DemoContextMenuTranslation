package sg.edu.rp.c346.id20018621.democontextmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText, tvTranslatedText2;
    String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);

        //to register TextView to the context menu should be associated by calling registerForContextMenu(),
        //pass in TextView variable
        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);
    }

    //create Context Menu (long click event)
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"English");
        menu.add(0,1,1,"Italian");
        if(v==tvTranslatedText){
            wordClicked = "1st";
        }else if(v == tvTranslatedText2){
            wordClicked = "bye";
        }
    }

    //menu selection
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.d("OnContextItemsSelected", "detected menuitem click");
        //for "1st (hello)
        if(wordClicked.equalsIgnoreCase("1st")){
            Log.d("OnContextItemsSelected", "detected action on 1st TextView");
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                tvTranslatedText.setText("Hello");
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                tvTranslatedText.setText("Ciao");
                return true;  //menu item successfully handled
            }
        }
        //for "bye"
        if(wordClicked.equalsIgnoreCase("bye")){
            Log.d("OnContextItemsSelected", "detected action on 2nd TextView");
            //for 'bye'
            if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                tvTranslatedText2.setText("Bye");
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //check if the selected menu item ID is 1
                //code for action
                tvTranslatedText2.setText("Addio");
                return true;  //menu item successfully handled
            }
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}