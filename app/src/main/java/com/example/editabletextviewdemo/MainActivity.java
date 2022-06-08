package com.example.editabletextviewdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView emailAccountTextView;
    TextView passwordAccountTextView;
    TextView numberAccountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setInitElement();
    }
    private void setInitElement() {
        passwordAccountTextView = findViewById(R.id.passwordAccountTextView);
        emailAccountTextView = findViewById(R.id.emailAccountTextView);
        numberAccountTextView = findViewById(R.id.numberAccountTextView);

        View.OnClickListener handler = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.emailAccountTextView:
                        setEditableTextView(emailAccountTextView, "E-Mail");
                        break;
                    case R.id.passwordAccountTextView:
                        setEditableTextView( passwordAccountTextView, "Password");
                        break;
                    case R.id.numberAccountTextView:
                        setEditableTextView( numberAccountTextView, "Phone Number");
                        break;
                }
            }
        };

        passwordAccountTextView.setOnClickListener(handler);
        emailAccountTextView.setOnClickListener(handler);
        numberAccountTextView.setOnClickListener(handler);
    }
    private void setEditableTextView(TextView emailAccountTextView, String titleDialog) {

        AlertDialog dialog = new AlertDialog.Builder(this).create();
        EditText emailEditText = new EditText(this);
        emailEditText.setInputType(InputType.TYPE_CLASS_TEXT);

        dialog.setTitle("Edit " + titleDialog);
        dialog.setView(emailEditText);

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Save ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                emailAccountTextView.setText(emailEditText.getText());
            }
        });

        emailAccountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailEditText.setText(emailAccountTextView.getText());
                dialog.show();
            }
        });
    }

}