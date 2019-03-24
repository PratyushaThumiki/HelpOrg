package com.example.thumikipratyusha.capstone_stage2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;


public class PhysicallyActivity extends AppCompatActivity {

        CardView schemecv,ngocv,healthcv;
        private FirebaseAuth mAuth = FirebaseAuth.getInstance();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_physical);
            schemecv = (CardView) findViewById(R.id.scheme);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            schemecv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.india.gov.in/spotlight/unique-disability-id"));
                    startActivity(intent);
                    finish();
                }
            });
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            if(id == R.id.action_signout){
                mAuth.signOut();
                Intent intent = new Intent(this,Login.class);
                startActivity(intent);
                finish();
                // finish();
            }
            if(id==R.id.action_imp){
                Intent intent = new Intent(this,ImportantActivity.class);
                startActivity(intent);
                finish();
            }
            return super.onOptionsItemSelected(item);
        }

}
