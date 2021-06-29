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

public class Dissolving extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dissolving);
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

    public void cleandissolving(View view) {
        TextView plus = (TextView) findViewById(R.id.textView25);
        TextView kationText = (TextView) findViewById(R.id.textView24);
        TextView achargeText = (TextView) findViewById(R.id.textView29);
        TextView kchargeText = (TextView) findViewById(R.id.textView27);
        TextView aq1 = (TextView) findViewById(R.id.textView28);
        TextView aq2 = (TextView) findViewById(R.id.textView30);
        TextView anionText = (TextView) findViewById(R.id.textView26);
        EditText i = (EditText) findViewById(R.id.editText2);
        kationText.setText("");
        anionText.setText("");
        i.setText("");
        kchargeText.setText("");
        achargeText.setText("");
        aq1.setText("");
        aq2.setText("");
        plus.setText("");
    }

    public void dissolving(View view) {
        TextView plus = (TextView) findViewById(R.id.textView25);
        TextView kationText = (TextView) findViewById(R.id.textView24);
        TextView achargeText = (TextView) findViewById(R.id.textView29);
        TextView kchargeText = (TextView) findViewById(R.id.textView27);
        TextView aq1 = (TextView) findViewById(R.id.textView28);
        TextView aq2 = (TextView) findViewById(R.id.textView30);
        TextView anionText = (TextView) findViewById(R.id.textView26);
        EditText i = (EditText) findViewById(R.id.editText2);
        String ionField = i.getText().toString();
        Element ion = new Element();
        if (ionField.length() != 0) {
            String temp = "";
            for (int k = 0; k < ionField.length(); k++) {
                char tav = ionField.charAt(k);
                if (tav != ' ') {
                    temp = temp + tav;
                }
            }
            ionField = temp;
            plus.setText(" + ");
            kationText.setText("");
            anionText.setText("");
            kchargeText.setText("");
            achargeText.setText("");
            aq1.setText("");
            aq2.setText("");
            ion.setSymbol(ionField);
            ion.findKation();
            ion.findAnion();
            ion.removeIon();
            String[] ions = ion.Split();
            int kcharge = (int) toFloat(ions[2]);
            int acharge = (int) toFloat(ions[3]);
            if (typeError(ionField)) {
                kationText.setText(R.string.type_Error);
                plus.setText("");
                anionText.setText("");
                kchargeText.setText("");
                achargeText.setText("");
                aq1.setText("");
                aq2.setText("");
                return;
            }
            if (ions[0].charAt(0) == 'א' || ions[0].charAt(0) == 'ל') {
                kationText.setText("");
                anionText.setText("");
                achargeText.setText("");
                aq1.setText("");
                aq2.setText("");
                plus.setText("");
                kationText.setText(ions[0]);
                return;
            }
            ion.setSymbol(ion.getSymbol());
            i.setText(ion.getSymbol());
            if (kcharge > 1) {
                kchargeText.setText(kcharge + "+");
            } else {
                kchargeText.setText("+");
            }
            if (acharge > 1) {
                achargeText.setText(acharge + "-");
            } else {
                achargeText.setText("-");
            }
            aq1.setText(R.string.aq);
            aq2.setText(R.string.aq);
            kationText.setText(ions[0]);
            anionText.setText(ions[1]);
        }
    }

    public float toFloat(String num) {
        return Float.parseFloat(num);
    }

    public String removeIon(String symbol) {
        int i;
        String temp = "";
        int countA = 0;
        int br = 0;
        int cof = 0;
        for (i = 0; i < symbol.length(); i++) {
            char tav = symbol.charAt(i);
            if (tav >= 'A' && tav <= 'Z') {
                countA++;
            }
            if (countA == 0 && tav >= '0' && tav <= '9') {
                cof++;
            }
        }
        if (cof != 0) {
            for (i = cof; i < symbol.length(); i++) {
                temp = temp + symbol.charAt(i);
            }
            symbol = temp;
        }
        if (symbol.charAt(symbol.length() - 1) == ')') {
            i = symbol.length() - 1;
            while (i > -1) {
                if (symbol.charAt(i) == '(') {
                    br = i;
                    i = -1;
                }
                i--;
            }
        }
        if (br == 0) {
            return symbol;
        }
        temp = "";
        for (i = 0; i < br; i++) {
            temp = temp + symbol.charAt(i);
        }
        return temp;
    }

    public boolean typeError(String matter) {
        matter = removeIon(matter);
        int countB = 0;
        char tav;
        if (matter.length() == 1) {
            return true;
        }
        if ((matter.charAt(0) >= 'a' && matter.charAt(0) <= 'z') || matter.charAt(0) == '+' || matter.charAt(0) == '-' || matter.charAt(0) == ')') {
            return true;
        }
        int i = 0;
        while (i < matter.length()) {
            tav = matter.charAt(i);
            if (tav >= 'a' && tav <= 'z' && i + 1 < matter.length() && matter.charAt(i + 1) >= 'a' && matter.charAt(i + 1) <= 'z') {
                return true;
            }
            if (tav >= 'a' && tav <= 'z' && matter.charAt(i - 1) >= '0' && matter.charAt(i - 1) <= '9') {
                return true;
            }
            i++;
        }
        for (i = 0; i < matter.length(); i++) {
            tav = matter.charAt(i);
            if ((tav < 'a' || tav > 'z') && ((tav < 'A' || tav > 'Z') && ((tav < '0' || tav > '9') && tav != '(' && tav != ')'))) {
                return true;
            }
        }
        if (matter.length() == 1) {
            tav = matter.charAt(0);
            if (tav == '-' || tav == '+' || tav == '.' || tav == '(' || tav == ')') {
                return true;
            }
        }
        for (i = 0; i < matter.length(); i++) {
            tav = matter.charAt(i);
            if (tav == '(' || tav == ')') {
                countB++;
            }
        }
        if (countB == 0 || countB % 2 == 0) {
            return false;
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
            //Already At Dissolving
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
