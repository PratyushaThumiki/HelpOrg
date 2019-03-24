package com.example.thumikipratyusha.capstone_stage2;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.thumikipratyusha.capstone_stage2.utils.AppExecutors;

import com.example.thumikipratyusha.capstone_stage2.database.AppDatabase;
import com.example.thumikipratyusha.capstone_stage2.database.ImportantModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImportantActivity extends AppCompatActivity {

    @BindView(R.id.root)
    LinearLayout linearLayout;
    @BindView(R.id.scheme1)CardView cardView;
    @BindView(R.id.imp_title)
    TextView title;
    @BindView(R.id.fav)
    Button button;
    private AppDatabase db;
    boolean isImportant;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important);
        ButterKnife.bind(this);
        db=AppDatabase.getInstance(this);
        Intent intent=new Intent();
        String schemetitle=intent.getStringExtra("title");
        boolean fav= intent.getBooleanExtra("liked",true);
        title.setText(schemetitle);



        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isImportant){
                isImportant=false;
                button.setBackground(ContextCompat.getDrawable(ImportantActivity.this, R.drawable.ic_favorite_red_24dp));

            }
            else {
                isImportant =true;
                deletefromdatabase();
                button.setBackground(ContextCompat.getDrawable(ImportantActivity.this,R.drawable.ic_favorite_border_black_24dp));
                finish();
            }
        }
    });
    }

        private void deletefromdatabase() {
            Intent intent = getIntent();

            final String impId = intent.getStringExtra("impid");
            AppExecutors.getInstance().diskIO().execute(new Runnable() {

                @Override
                public void run() {
                    db.impDao().deleteImp(impId);


                }
            });
        }
}
