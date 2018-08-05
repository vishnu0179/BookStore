 package com.example.vishnu.bookstore;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vishnu.bookstore.Common.Common;
import com.example.vishnu.bookstore.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

 public class SignIn extends AppCompatActivity {

    EditText PhnNo,Password;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        PhnNo=(MaterialEditText)findViewById(R.id.phnNo);
        Password= (MaterialEditText)findViewById(R.id.password);
        btnSignIn =(Button) findViewById(R.id.btnSignIn);

        //Init Firebase

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please Wait..");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if(dataSnapshot.child(PhnNo.getText().toString()).exists())
                        {
                            mDialog.dismiss();
                            //Get User Information
                            User user = dataSnapshot.child(PhnNo.getText().toString()).getValue(User.class);
                            if(user.getPassword().equals(Password.getText().toString()))
                            {
                                Toast.makeText(SignIn.this,"Sign In Successfully",Toast.LENGTH_SHORT).show();
                                Intent homeIntent = new Intent(SignIn.this,Home.class);
                                Common.currentUser = user;
                                startActivity(homeIntent);
                                finish();
                            }
                            else {
                                Toast.makeText(SignIn.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            mDialog.dismiss();
                           Toast.makeText(SignIn.this,"User does not exist",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}
