package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         EditText To = (EditText) findViewById(R.id.to);
         EditText Subject = (EditText) findViewById(R.id.sub);
         EditText Message = (EditText) findViewById(R.id.msg);
         Button Send = (Button) findViewById(R.id.send);


         
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(!Message.getText().toString().isEmpty() && !Subject.getText().toString().isEmpty()
                && !To.getText().toString().isEmpty())
                {

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[]{To.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT,Subject.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT,Message.getText().toString());
                    intent.setData(Uri.parse("mailto:"));
                    if (intent.resolveActivity(getPackageManager()) != null ){
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this,"There is no Application Support",
                                Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(MainActivity.this,"Please Fill this First",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}