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

public class Precipitation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precipitation);
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
    public void clearPre(View view) {
        ((TextView) findViewById(R.id.compound1)).setText("");
        ((EditText) findViewById(R.id.kation1)).setText("");
        ((EditText) findViewById(R.id.anion1)).setText("");
        ((TextView) findViewById(R.id.textView6)).setText("");
    }

    public void pre(View v){
        TextView textView = (TextView) findViewById(R.id.compound1);
        String kation2 = (EditText) findViewById(R.id.kation1).getText().toString();
        String anion2 = (EditText) findViewById(R.id.anion1).getText().toString();
        TextView s = (TextView) findViewById(R.id.textView6);
        Element anion = new Element();
        Element kation = new Element();
        boolean rev = false;
        int count = 0;
        String compound = "";
        String newK = "";
        String newA = "";
        if (kation2.length() != 0 && anion2.length() != 0) {
            int k;
            char tav3;
            String temp = "";
            for (k = 0; k < kation2.length(); k++) {
                tav3 = kation2.charAt(k);
                if (tav3 != ' ') {
                    temp = temp + tav3;
                }
            }
            kation2 = temp;
            temp = "";
            for (k = 0; k < anion2.length(); k++) {
                tav3 = anion2.charAt(k);
                if (tav3 != ' ') {
                    temp = temp + tav3;
                }
            }
            anion2 = temp;
            if (typeError(kation2) || typeError(anion2) || same(kation2, anion2)) {
                textView.setText(R.string.type_Error);
                s.setText("");
                return;
            }
            boolean sink = false;
            kation.setSymbol(kation2);
            kation.remove();
            String matter1 = kation.element();
            int kationnum = kation.ion();
            anion.setSymbol(anion2);
            anion.remove();
            String matter2 = anion.element();
            int anionnum = anion.ion();
            for (int i = 0; i < kation.getSymbol().length(); i++) {
                if (kation.getSymbol().charAt(i) == '-') {
                    count++;
                }
            }
            if (count == 1) {
                rev = true;
            }
            if (rev) {
                if (anion.countCapital() == 1) {
                    anion.setSymbol(anion.element());
                    anion.Symbol();
                    anion.setSymbol(anion2);
                    anion.remove();
                }
                compound = kation.compound(matter2, matter1, kationnum, anionnum);
                if (kation.isASinkable() || anion.isKSinkable()) {
                    sink = true;
                }
            } else {
                if (kation.countCapital() == 1) {
                    kation.setSymbol(kation.element());
                    kation.Symbol();
                    kation.setSymbol(kation2);
                    kation.remove();
                }
                compound = kation.compound(matter1, matter2, anionnum, kationnum);
                if (kation.isKSinkable() || anion.isASinkable()) {
                    sink = true;
                }
            }
            if (sink) {
                textView.setText("אין תגובת שיקוע");
                ((TextView) findViewById(R.id.textView5)).setText("");
                ((TextView) findViewById(R.id.textView3)).setText("");
                s.setText("");
                return;
            }
                if ((anionnum == 1 && kationnum == 1) || anionnum == kationnum) {
                    newK = kation.getSymbol();
                    newA = anion.getSymbol();
                } else if (anionnum == 1 || kationnum % anionnum == 0) {
                    newK = kation.getSymbol();
                    if (anionnum != 1) {
                        kationnum /= anionnum;
                    }
                    newA = kationnum + "" + anion.getSymbol();
                } else if (kationnum == 1 || anionnum % kationnum == 0) {
                    if (kationnum != 1) {
                        anionnum /= kationnum;
                    }
                    newK = anionnum + "" + kation.getSymbol();
                    newA = anion.getSymbol();
                } else {
                    newK = anionnum + "" + kation.getSymbol();
                    newA = kationnum + "" + anion.getSymbol();
                }
                textView.setText(compound);
                (EditText) findViewById(R.id.kation1).setText(newK);
                (EditText) findViewById(R.id.anion1).setText(newA);
                s.setText("(s)");
        }
    }
    public String remove(String symbol) {
        String temp = "";
        char tav;
        boolean br = false;
        int index = 0;
        int i = 0;
        while (i < symbol.length()) {
            tav = symbol.charAt(i);
            if ((tav < '0' || tav > '9') && tav != '.') {
                index = i;
                i = symbol.length();
            }
            i++;
        }
        symbol = symbol.substring(index);
        i = 0;
        while (i < symbol.length()) {
            tav = symbol.charAt(i);
            if (tav == '(' && i + 2 < symbol.length() && ((symbol.charAt(i + 1) == 's' || symbol.charAt(i + 1) == 'l' || symbol.charAt(i + 1) == 'g') && symbol.charAt(i + 2) == ')')) {
                br = true;
            }
            if (tav == '(' && i + 3 < symbol.length() && symbol.charAt(i + 1) == 'a' && symbol.charAt(i + 2) == 'q' && symbol.charAt(i + 3) == ')') {
                br = true;
            }
            if (!br) {
                temp = temp + tav;
            }
            if (tav == ')') {
                br = false;
            }
            i++;
        }
        return temp;
    }

    public boolean typeError(String matter) {
        matter = remove(matter);
        int count = 0;
        char tav;
        if (matter.length() == 1) {
            return true;
        }
        int i;
        for (i = 0; i < matter.length(); i++) {
            tav = matter.charAt(i);
            if (tav == '+' || tav == '-') {
                count++;
            }
        }
        if (count != 1) {
            return true;
        }
        count = 0;
        for (i = 0; i < matter.length(); i++) {
            tav = matter.charAt(i);
            if (tav >= 'A' && tav <= 'Z') {
                count++;
            }
        }
        if (count == 0) {
            return true;
        }
        int index;
        if (matter.indexOf(43) == -1) {
            index = matter.indexOf(45);
        } else {
            index = matter.indexOf(43);
        }
        for (i = index; i < matter.length(); i++) {
            tav = matter.charAt(i);
            if (tav >= 'a' && tav <= 'z') {
                return true;
            }
            if ((tav >= 'A' && tav <= 'Z') || tav == '{') {
                return true;
            }
        }
        int countB = 0;
        int countC = 0;
        for (i = 0; i < matter.length(); i++) {
            tav = matter.charAt(i);
            if (tav == '{') {
                countB++;
            }
            if (tav == '}') {
                countC++;
            }
        }
        if (countB != 0) {
            for (i = matter.indexOf(123); i < matter.length(); i++) {
                tav = matter.charAt(i);
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
            if (matter.charAt(matter.length() - 1) != '}') {
                return true;
            }
            if ((countC == 1 && countB == 0) || countC > 1) {
                return true;
            }
        }
        countB = 0;
        countC = 0;
        for (i = 0; i < matter.length(); i++) {
            tav = matter.charAt(i);
            if (tav == '+') {
                countB++;
            }
            if (tav == '-') {
                countC++;
            }
        }
        if ((countB == 0 && countC == 0) || countB > 1 || countC > 1) {
            return true;
        }
        countB = 0;
        if (matter.charAt(0) >= 'a' && matter.charAt(0) <= 'z') {
            return true;
        }
        i = 0;
        while (i < matter.length()) {
            tav = matter.charAt(i);
            if (tav >= 'a' && tav <= 'z' && i + 1 < matter.length() && matter.charAt(i + 1) >= 'a' && matter.charAt(i + 1) <= 'z') {
                return true;
            }
            if (tav >= 'a' && tav <= 'z' && (i - 1 <= -1 || matter.charAt(i - 1) < 'A' || matter.charAt(i - 1) > 'Z')) {
                return true;
            }
            i++;
        }
        for (i = 0; i < matter.length(); i++) {
            tav = matter.charAt(i);
            if ((tav < 'a' || tav > 'z') && ((tav < 'A' || tav > 'Z') && ((tav < '0' || tav > '9') && tav != '-' && tav != '+' && tav != '{' && tav != '}'))) {
                return true;
            }
        }
        if (matter.length() == 1) {
            tav = matter.charAt(0);
            if (tav == '-' || tav == '+' || tav == '.' || tav == '(' || tav == ')' || tav == '{' || tav == '}') {
                return true;
            }
        }
        for (i = 0; i < matter.length(); i++) {
            tav = matter.charAt(i);
            if (tav == '(' || tav == ')') {
                countB++;
            }
        }
        return !(countB == 0 || countB % 2 == 0);
    }

    public boolean same(String k, String a) {
        a = remove(a);
        k = remove(k);
        if (!(typeError(k) || typeError(a))) {
            if (k.charAt(k.length() - 1) == '+' && a.charAt(a.length() - 1) == '+') {
                return true;
            }
            if (k.charAt(k.length() - 1) == '-' && a.charAt(a.length() - 1) == '-') {
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
            //Already At Precipitation
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
