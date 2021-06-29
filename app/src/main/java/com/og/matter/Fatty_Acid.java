package com.og.matter;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.core.app.NavUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.core.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Fatty_Acid extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String FCT;
    String SCT;
    Spinner f;
    Spinner s;
    ArrayAdapter<CharSequence> adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatty__acid);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        adapter= ArrayAdapter.createFromResource(this,R.array.fattyE,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        f=(Spinner) findViewById(R.id.spinner);
        f.setAdapter(adapter);
        f.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                FCT=f.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
        s=(Spinner) findViewById(R.id.spinner2);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                SCT=s.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clearFatty(View view) {
        EditText f = (EditText) findViewById(R.id.editText3);
        EditText s = (EditText) findViewById(R.id.editText5);
        EditText o1 = (EditText) findViewById(R.id.editText4);
        EditText o2 = (EditText) findViewById(R.id.editText7);
        TextView description = (TextView) findViewById(R.id.textView35);
        description.setText("");
        f.setText("");
        s.setText("");
        o1.setText("");
        o2.setText("");
    }

    public void fatty(View view) {
        String language = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("language", "Heb");
        String f = ((EditText) findViewById(R.id.editText3)).getText().toString();
        String s = ((EditText) findViewById(R.id.editText5)).getText().toString();
        TextView textView = (TextView) findViewById(R.id.textView33);
        TextView description = (TextView) findViewById(R.id.textView35);
        if (s.length() > 0 && f.length() > 0) {
            s = remove(s);
            f = remove(f);
            if (!typeError(s) && !typeError(f)) {
                Matter first = new Matter();
                first.setName(f);
                int FC = first.CNumber();
                int FB = first.Bonds();
                Matter second = new Matter();
                second.setName(s);
                String[] resault = first.Resault(FC, FB, second.CNumber(), second.Bonds(), FCT, SCT, language);
                textView.setText(resault[0]);
                description.setText(resault[1]);
            }
            else{
                description.setText(R.string.type_Error);
            }
        }
    }

    public String remove(String matter) {
        int i;
        int countC = 0;
        for (i = 0; i < matter.length(); i++) {
            if (matter.charAt(i) == 'C') {
                countC++;
            }
        }
        String temp = "";
        for (i = 0; i < matter.length(); i++) {
            char tav = matter.charAt(i);
            if (tav != ' ') {
                temp = temp + tav;
            }
        }
        matter = temp;
        if (countC <= 0) {
            return matter;
        }
        temp = "";
        int j = 0;
        while (matter.charAt(j) != 'C' && j < matter.length()) {
            j++;
        }
        for (i = j; i < matter.length(); i++) {
            temp = temp + matter.charAt(i);
        }
        return temp;
    }

    public boolean typeError(String matter) {
        int i = 0;
        char tav;
        for(int j=0;j<matter.length();j++){
            tav=matter.charAt(j);
            if(tav!='C'&&tav!=':'&&(tav<'0'||tav>'9'))
                return true;
        }
        while (i < matter.length()) {
            if (matter.charAt(i) == 'C' && i == 0 && i + 1 < matter.length() && matter.charAt(i + 1) >= '0' && matter.charAt(i + 1) <= '9' && i + 2 < matter.length()) {
                if (matter.charAt(i + 2) < '0' || matter.charAt(i + 2) > '9') {
                    if (matter.charAt(i + 2) == ':' && i + 3 < matter.length() && matter.charAt(i + 3) >= '0' && matter.charAt(i + 3) <= '9' && matter.length() == 4) {
                        return false;
                    }
                } else if (i + 3 < matter.length() && matter.charAt(i + 3) == ':' && i + 4 < matter.length() && matter.charAt(i + 4) >= '0' && matter.charAt(i + 4) <= '9' && matter.length() == 5) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            NavUtils.navigateUpFromSameTask(this);
        } else if (id == R.id.nav_precipitation) {
            NavUtils.navigateUpFromSameTask(this);
            startActivity(new Intent(getApplicationContext(), Precipitation.class));
        } else if(id == R.id.nav_stoichiometry){
            NavUtils.navigateUpFromSameTask(this);
            startActivity(new Intent(getApplicationContext(), Stoichiometry.class));
        } else if (id == R.id.nav_periodic_table){
            NavUtils.navigateUpFromSameTask(this);
            startActivity(new Intent(getApplicationContext(), Periodic_Table.class));
        } else if(id == R.id.nav_base_acid){
            NavUtils.navigateUpFromSameTask(this);
            startActivity(new Intent(getApplicationContext(), Base_Acid.class));
        } else if(id == R.id.nav_dissolving){
            NavUtils.navigateUpFromSameTask(this);
            startActivity(new Intent(getApplicationContext(), Dissolving.class));
        } else if(id == R.id.nav_fatty_acid){
            //Already At Fatty Acid
        } else if(id == R.id.nav_equation_balancer){
            NavUtils.navigateUpFromSameTask(this);
            startActivity(new Intent(getApplicationContext(), Equation_Balancer.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
