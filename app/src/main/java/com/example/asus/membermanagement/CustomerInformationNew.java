package com.example.asus.membermanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomerInformationNew extends AppCompatActivity {
    private CustomerInformation mCustomerInformation;
    private Button mSaveButtom;

    EditText txtFName, txtLName, txtContact, txtEmail, txtMemberType, txtAdd;
    DatabaseHelper mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_bs_new);
        mDatabase = new DatabaseHelper(this);

        txtFName = (EditText)findViewById(R.id.firstNameInput);
        txtLName = (EditText)findViewById(R.id.lastNameInput);
        txtContact = (EditText)findViewById(R.id.contactNoInput);
        txtEmail = (EditText)findViewById(R.id.emailInput);
        txtMemberType = (EditText)findViewById(R.id.memberTypeInput);
        txtAdd = (EditText)findViewById(R.id.addressInput);
        mSaveButtom = (Button)findViewById(R.id.btnSave);

        AddData();
    }

    public void AddData() {
        mSaveButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = mDatabase.insertData(txtFName.getText().toString(),
                        txtLName.getText().toString(),
                        txtContact.getText().toString(),
                        txtEmail.getText().toString(),
                        txtMemberType.getText().toString(),
                        txtAdd.getText().toString());

                if (isInserted == true) {
                    Toast.makeText(CustomerInformationNew.this, "Data inserted successfully", Toast.LENGTH_LONG).show();
                    MainMenu();
                }
                else {
                    Toast.makeText(CustomerInformationNew.this, "Data inserted unsuccessfully", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    protected void MainMenu() {
        Intent intent = new Intent(this, CustomerInformationActivity.class);
        startActivity(intent);
    }
}
