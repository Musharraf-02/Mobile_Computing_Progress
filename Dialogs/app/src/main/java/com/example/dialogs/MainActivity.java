package com.example.dialogs;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayAlertDialog(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert Dialog");
        builder.setMessage("This is message for the dialog box.");
        builder.setCancelable(false);
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"You pressed No button.", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"You pressed Yes button.", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    public void displayCustomizedAlertDialog(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setView(R.layout.login);
        builder.setCancelable(false);
        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Login was cancelled.", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    public void displayListAlertDialog(View view) {
        String[] colors= {"Red","Green","Blue","Yellow","Purple"};
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert Dialog Box with List").setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,colors[which], Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    public void displayMultipleChoiceAlertDialog(View view) {
        String[] colors= {"Red","Green","Blue","Yellow","Purple"};
        ArrayList<Integer> selectedColors= new ArrayList<>();
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert Dialog Box with Multiple Choice");
        builder.setCancelable(false);
        builder.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    selectedColors.add(which);
                }
                else if(selectedColors.contains(which)){
                    selectedColors.remove(which);
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Cancelled", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String msg="";
                for(int i=0; i<selectedColors.size();i++){

                    msg=msg+colors[selectedColors.get(i)]+"\n";
                }
                if(!selectedColors.isEmpty()) {
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "No color was selected.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
        }
    }
