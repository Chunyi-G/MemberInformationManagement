package com.example.asus.membermanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerInformationActivity extends AppCompatActivity {
    private Button mButtonView;
    private Button mButtonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonView = (Button)findViewById(R.id.btnView);
        mButtonView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewActivity();
            }
        }));

        mButtonAdd = (Button)findViewById(R.id.btnAdd);
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddNewActivity();
            }
        });
    }

    protected void openViewActivity() {
        Intent intent = new Intent(this, CustomerInformationListActivity.class);
        startActivity(intent);
    }

    protected void openAddNewActivity() {
        Intent intent = new Intent(this, CustomerInformationNew.class);
        startActivity(intent);
    }
}
