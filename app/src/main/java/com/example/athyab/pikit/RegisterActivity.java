package com.example.athyab.pikit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = RegisterActivity.class.getSimpleName();
    private Button btn_Register;
    private Button btn_Login;
    private EditText inputFullName;
    private EditText inputEmail;
    private EditText inputPassword;
    private ProgressDialog pDialog;
    DBHelper userDB;
    User user;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userDB= new DBHelper(this);
        user= new User();

        inputFullName = (EditText) findViewById(R.id.name);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        btn_Register = (Button) findViewById(R.id.btnRegister);

        btn_Login = (Button) findViewById(R.id.btnLinkToLoginScreen);
        AddRegisterData();
        DirectToLogin();




        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);


        // Register Button Click event
       /* btn_Register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputFullName.getText().toString().trim();
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    registerUser(name, email, password);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });*/





    }

    // Link to Login Screen
    public void DirectToLogin() {
        btn_Login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    /**
     * Function to store user in MySQL database will post params(tag, name,
     * email, password) to register url
     */
    private void registerUser(final String name, final String email,
                              final String password) {
        // Tag used to cancel the request
        String tag_string_req = "req_register";

        pDialog.setMessage("Registering ...");
        showDialog();
    }


    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    // Register Button Click event
    public void AddRegisterData(){
        btn_Register.setOnClickListener(
                new View.OnClickListener(){
                    String name = inputFullName.getText().toString().trim();
                    String email = inputEmail.getText().toString().trim();
                    String password = inputPassword.getText().toString().trim();

                    @Override
                    public void onClick(View view) {

                       // if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
                            //if (!(name.isEmpty() || name.isEmpty() || name.isEmpty()) )
                        //if (!name.equals("") && !email.equals("") && !password.equals("")){

                            boolean isInserted = userDB.insertRegisterData(user);


                            if (isInserted = true) {
                                Toast.makeText(RegisterActivity.this, "You are successfully registered", Toast.LENGTH_LONG).show();

                            } else
                                Toast.makeText(RegisterActivity.this, "Registration unsuccessful. Please try again!", Toast.LENGTH_LONG).show();

                        //} else {
                            //Toast.makeText(RegisterActivity.this, "All fields are required", Toast.LENGTH_LONG).show();
                        //}
                    }
                }
        );
    }


}
