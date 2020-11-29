package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.text);
        registerForContextMenu(tv);
    }
    public void onCreateContextMenu(ContextMenu cm, View v, ContextMenu.ContextMenuInfo cinfo)
    {
        super.onCreateContextMenu(cm,v,cinfo);
        MenuInflater inf=getMenuInflater();
        inf.inflate(R.menu.main3, cm);
    }
    public boolean onContextItemSelected(MenuItem itm)
    {
 switch (itm.getItemId())
 {
     case R.id.copy:
         Toast.makeText(getApplicationContext(),"You click copy Button",Toast.LENGTH_SHORT).show();
         return true;
     case R.id.bold:
         Toast.makeText(getApplicationContext(),"You click bold Button",Toast.LENGTH_SHORT).show();
         return true;
     case R.id.underline:
         Toast.makeText(getApplicationContext(),"You click underline Button",Toast.LENGTH_SHORT).show();
         return true;

     default:
         return super.onContextItemSelected(itm);
 }
    }
    public boolean onCreateOptionsMenu(Menu me)
    {
        super.onCreateOptionsMenu(me);
        getMenuInflater().inflate(R.menu.main2,me);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.back:
                Toast.makeText(getApplicationContext(),"You click Back Button",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.next:
                Toast.makeText(getApplicationContext(),"You click next Button",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void showmenu(View v)
    {
        PopupMenu pop=new PopupMenu(this,v);
        MenuInflater inf=pop.getMenuInflater();
        inf.inflate(R.menu.main4,pop.getMenu());
        pop.show();
        pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.New:
                        Toast.makeText(getApplicationContext(),"You click New Button",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.add:
                        Toast.makeText(getApplicationContext(),"You click Add Button",Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
               
            }
        });
    }
    public void showm(View v)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to stay here");
        alertDialogBuilder.setPositiveButton("yes",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(getApplicationContext(),"You clicked yes button",Toast.LENGTH_LONG).show();
            }
        });
        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"You clicked yes button",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}