package com.example.app4;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public  class people extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editSurname, editAge, editId;
    Button buttonadd , buttonviewall, buttonupdate, buttondelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_people );
        myDb = new DatabaseHelper(this);


        editId = findViewById( R.id.editText_id );
        editName = findViewById(R.id.editText_name);
        editSurname = findViewById(R.id.editText_surname);
        editAge = findViewById(R.id.editText_age);
        buttonadd = findViewById( R.id.button_add );
        buttonviewall = findViewById( R.id.button_viewdb);
        buttonupdate = findViewById( R.id.button_update );
        buttondelete = findViewById( R.id.button_delete );


        AddData();
        ViewAll();
        updateData();
        deleteData();
    }

    public void AddData(){
        buttonadd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isInserted =  myDb.insertData(editId.getText().toString(), editName.getText().toString(), editSurname.getText().toString(),editAge.getText().toString() );
                if (isInserted == true) {
                    Toast.makeText(people.this, "Data inserted", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(people.this, "Data NOT inserted", Toast.LENGTH_SHORT).show();
                }
            }
        } );
    }

    public void ViewAll(){
        buttonviewall.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() ==0 )    { showMessage("Error", "No data found in database");
                         return ; }

            StringBuffer buffer = new StringBuffer(  );
            while (res.moveToNext()){
                    buffer.append( "Id: " + res.getString(0) + "\n" );
                    buffer.append( "Name: " + res.getString(1) + "\n" );
                    buffer.append( "Surname: " + res.getString(2) + "\n" );
                    buffer.append( "Age: " + res.getString(3) + "\n\n" );
            }
                showMessage("Data", buffer.toString());
        }} );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder( this);
        builder.setCancelable( true );
        builder.setTitle( title );
        builder.setMessage( Message );
        builder.show();

    }

    public void updateData(){
        buttonupdate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = myDb.updateData( editId.getText().toString(), editName.getText().toString() , editSurname.getText().toString(), editAge.getText().toString());
            if (isUpdated == true) {
                Toast.makeText(people.this, "Data is updated", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(people.this, "Data not updated", Toast.LENGTH_SHORT).show();
            }
            }
        } );
    }

    public void deleteData(){
        buttondelete.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteData( editId.getText().toString() );
                if (deletedRows >0)  { Toast.makeText(people.this, "Data is deleted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(people.this, "Data not deleted", Toast.LENGTH_SHORT).show();
            }
            }
        } );
    }

    }

