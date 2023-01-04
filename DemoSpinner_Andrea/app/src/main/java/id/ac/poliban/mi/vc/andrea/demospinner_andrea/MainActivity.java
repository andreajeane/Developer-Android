package id.ac.poliban.mi.vc.andrea.demospinner_andrea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.asian_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.South, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String item = adapterView.getAdapter().getItem(i).toString();

                Toast.makeText(MainActivity.this, "Anda Memilih " + item,
                        Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Item Belum di Klik!",
                        Toast.LENGTH_SHORT).show();

            }
        });


        ConstraintLayout layout = findViewById(R.id.constraint_layout);
        registerForContextMenu(layout);


        Button btShowDialog = findViewById(R.id.show_dialog);
        btShowDialog.setOnClickListener(this::showDialog);
    }

    private void showDialog(View view) {
        new  AlertDialog.Builder(this)
                .setTitle("Black Coffe")
                .setIcon(R.drawable.ic_coffe)
                .setMessage("Anda ingin Pesan?")
                .setNeutralButton("Binging", (dialogInterface, i)->
                        displayToast("Saya binung"))
                .setNegativeButton("Ogah", (dialogInterface, i)->
                        displayToast("Saya ogah pesan"))
                .setPositiveButton("pesan", (dialogInterface, i)->
                        displayToast("Saya pesan 2"))
                .show();
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_edit:
                displayToast("edit clicked!");
                return true;
            case R.id.context_share:
                displayToast("share clicked!");
                return true;
            case R.id.context_delete:
                displayToast("delete clicked!");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menempelkan object option
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_breakfast:
                displayToast("I'm in breakfast!");
                break;

            case R.id.action_dinner:
                displayToast("I'm in dinner!");
                break;
            case R.id.action_lunch:
                displayToast("I'm in luch!");
                break;
            case R.id.action_meeting:
                displayToast("I'm in meeting!");
                break;
            case R.id.action_party:
                displayToast("I'm in party!");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displayToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }

    public void onClickShowAlert(View view) {

    }
}