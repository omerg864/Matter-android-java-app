package com.og.matter;

import android.content.Intent;
import android.os.Bundle;

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
import android.widget.EditText;
import android.widget.TextView;

public class Periodic_Table extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodic__table);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    public void table(View view) {
        Element first = new Element();
        TextView nameText = (TextView) findViewById(R.id.name);
        TextView groupText = (TextView) findViewById(R.id.group);
        TextView molarText = (TextView) findViewById(R.id.molar);
        TextView protonText = (TextView) findViewById(R.id.protons);
        TextView categoryText = (TextView) findViewById(R.id.category);
        TextView electronText = (TextView) findViewById(R.id.electrons);
        TextView atomicText = (TextView) findViewById(R.id.atomic);
        EditText e = (EditText) findViewById(R.id.element);
        String element = e.getText().toString();
        if (element.length() != 0) {
            String temp = "";
            for (int k = 0; k < element.length(); k++) {
                char tav = element.charAt(k);
                if (tav != ' ') {
                    temp = temp + tav;
                }
            }
            element = temp;
            e.setText(element);
            nameText.setText("");
            groupText.setText("");
            molarText.setText("");
            protonText.setText("");
            categoryText.setText("");
            electronText.setText("");
            atomicText.setText("");
            first.setSymbol(element);
            if (first.atomicNumber()) {
                first.Atomic();
                e.setText(first.getSymbol());
            } else {
                if (typeError(first.getSymbol())) {
                    first.reset();
                } else {
                    first.Symbol();
                }
            }
            if (first.getAtomic() != 0) {
                atomicText.append("מספר אטומי: " + first.getAtomic());
                electronText.append("מספר אלקטרונים: " + first.getElectrons());
                if (first.getMetalic() == 1) {
                    categoryText.append("קטגוריה: מתכת");
                } else {
                    categoryText.append("קטגוריה: אל-מתכת");
                }
                protonText.append("מספר פרוטונים: " + first.getProtons());
                molarText.append("מסה מולרית: " + first.getMolar());
                nameText.append("שם: " + first.getName());
                groupText.append("סדרה כימית: " + first.getGroup());
                return;
            }
            nameText.setText(R.string.not_Found);
            groupText.setText("");
            molarText.setText("");
            protonText.setText("");
            categoryText.setText("");
            electronText.setText("");
            atomicText.setText("");
        }
    }


    public boolean typeError(String symbol) {
        int countA = 0;
        int i = 0;
        char tav;
        while (i < symbol.length()) {
            tav = symbol.charAt(i);
            if (tav >= 'A' && tav <= 'Z') {
                countA++;
            }
            if ((tav < 'a' || tav > 'z') && ((tav < 'A' || tav > 'Z') && ((tav < '0' || tav > '9') && tav != '-' && tav != '+' && tav != '{' && tav != '}'))) {
                return true;
            }
            if (tav >= 'a' && tav <= 'z' && (i - 1 <= -1 || symbol.charAt(i - 1) < 'A' || symbol.charAt(i - 1) > 'Z')) {
                return true;
            }
            i++;
        }
        if (symbol.length() == 1) {
            tav = symbol.charAt(0);
            if (tav < 'A' || tav > 'Z') {
                return true;
            }
        }
        if ((countA == 0 && symbol.length() == 1) || countA > 1) {
            return true;
        }
        int countB = 0;
        int countC = 0;
        for (i = 0; i < symbol.length(); i++) {
            tav = symbol.charAt(i);
            if (tav == '{') {
                countB++;
            }
            if (tav == '}') {
                countC++;
            }
        }
        if (countB != 0) {
            for (i = symbol.indexOf(123); i < symbol.length(); i++) {
                tav = symbol.charAt(i);
                if (tav >= 'a' && tav <= 'z') {
                    return true;
                }
                if (tav >= 'A' && tav <= 'Z') {
                    return true;
                }
            }
            if ((countB == 1 && countC == 0) || countB > 1) {
                return true;
            }
        }
        if (countC != 0) {
            if (symbol.charAt(symbol.length() - 1) != '}') {
                return true;
            }
            if ((countC == 1 && countB == 0) || countC > 1) {
                return true;
            }
        }
        countB = 0;
        countC = 0;
        for (i = 0; i < symbol.length(); i++) {
            tav = symbol.charAt(i);
            if (tav == '+') {
                countB++;
            }
            if (tav == '-') {
                countC++;
            }
        }
        if ((countB == 1 && countC == 1) || countB > 1 || countC > 1) {
            return true;
        }
        if (countB == 1 || countC == 1) {
            countA = 0;
            for (i = 0; i < symbol.length(); i++) {
                tav = symbol.charAt(i);
                if (tav >= '0' && tav <= '9') {
                    countA++;
                }
            }
            if (countA > 1) {
                return true;
            }
        }
        if (countB == 0 && countC == 0) {
            countA = 0;
            for (i = 0; i < symbol.length(); i++) {
                tav = symbol.charAt(i);
                if (tav >= '0' && tav <= '9') {
                    countA++;
                }
            }
            if (countA > 0) {
                return true;
            }
        }
        return false;
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
            //Already At Periodic Table
        } else if(id == R.id.nav_base_acid){
            NavUtils.navigateUpFromSameTask(this);
            startActivity(new Intent(getApplicationContext(), Base_Acid.class));
        } else if(id == R.id.nav_dissolving){
            NavUtils.navigateUpFromSameTask(this);
            startActivity(new Intent(getApplicationContext(), Dissolving.class));
        } else if(id == R.id.nav_fatty_acid){
            NavUtils.navigateUpFromSameTask(this);
            startActivity(new Intent(getApplicationContext(), Fatty_Acid.class));
        } else if(id == R.id.nav_equation_balancer){
            NavUtils.navigateUpFromSameTask(this);
            startActivity(new Intent(getApplicationContext(), Equation_Balancer.class));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
