package sg.edu.rp.c346.id20019648.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDbs, tvOcbc, tvUob;
    String website = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDbs = findViewById(R.id.tvDbs);
        tvOcbc = findViewById(R.id.tvOcbc);
        tvUob = findViewById(R.id.tvUob);

        registerForContextMenu(tvDbs);
        registerForContextMenu(tvOcbc);
        registerForContextMenu(tvUob);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");

        if (v == tvDbs) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
            website = "DBS";

        } else if (v == tvOcbc) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ocbc.com"));
            website = "OCBC";

        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uob.com.sg"));
            website = "UOB";
        }

    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (website.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
                startActivity(intent);
                return true;

            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18001111111"));
                startActivity(intent);
                return true;
            }

        } else if (website.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ocbc.com"));
                startActivity(intent);
                return true;

            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18003633333"));
                startActivity(intent);
                return true;
            }

        } else if (website.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uob.com.sg"));
                startActivity(intent);
                return true;

            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18002222121"));
                startActivity(intent);
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { //translation
        int id = item.getItemId();
        if (id == R.id.englishSelection) {
            tvDbs.setText("DBS");
            tvOcbc.setText("OCBC");
            tvUob.setText("UOB ");
            return true;

        } else if (id == R.id.chineseSelection) {
            tvDbs.setText("星展银行");
            tvOcbc.setText("华侨银行");
            tvUob.setText("大华银行 ");
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}