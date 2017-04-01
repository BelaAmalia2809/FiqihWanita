package id.sch.smktelkom_mlg.project2.xirpl204051233.fiqihwanita;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.sch.smktelkom_mlg.project2.xirpl204051233.fiqihwanita.model.Data;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Data data = (Data) getIntent().getSerializableExtra(RecyclerActivity.INTENT_DETAIL);
        setTitle(data.title);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageView);
        ivFoto.setImageResource(data.picture);
        ImageView ivFoto2 = (ImageView) findViewById(R.id.imageView1);
        ivFoto2.setImageResource(data.picture);
        TextView tvDeskripsi = (TextView) findViewById(R.id.textView2);
        tvDeskripsi.setText(data.descripsion);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
