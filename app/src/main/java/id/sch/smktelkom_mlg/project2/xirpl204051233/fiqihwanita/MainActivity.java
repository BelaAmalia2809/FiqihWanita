package id.sch.smktelkom_mlg.project2.xirpl204051233.fiqihwanita;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String JUDUL = "judul";
    public static final String ID = "id";
    Button btnKewajiban;
    Button btnSunnah;
    Button btnLarangan;
    Button btnAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKewajiban = (Button) findViewById(R.id.button1);
        btnSunnah = (Button) findViewById(R.id.button2);
        btnLarangan = (Button) findViewById(R.id.button3);
        btnAbout = (Button) findViewById(R.id.button4);

        btnKewajiban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doIntent();
            }
        });

        btnSunnah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doIntent2();
            }
        });

        btnLarangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doIntent3();
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doIntent4();
            }
        });
    }

    private void doIntent() {
        Intent intent = new Intent(this, RecyclerActivity.class);
        String judul = "Kewajiban Wanita";
        intent.putExtra(JUDUL, judul);
        intent.putExtra(ID, 1);
        startActivity(intent);
    }

    private void doIntent2() {
        Intent intent = new Intent(this, RecyclerActivity.class);
        String judul = "Sunnah Wanita";
        intent.putExtra(JUDUL, judul);
        intent.putExtra(ID, 2);
        startActivity(intent);
    }

    private void doIntent3() {
        Intent intent = new Intent(this, RecyclerActivity.class);
        String judul = "Larangan Wanita";
        intent.putExtra(JUDUL, judul);
        intent.putExtra(ID, 3);
        startActivity(intent);
    }

    private void doIntent4() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}
