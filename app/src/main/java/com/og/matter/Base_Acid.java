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
import android.widget.RadioButton;
import android.widget.TextView;

public class Base_Acid extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private boolean ba;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base__acid);
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

    public void base(View view){
        ba=false;
    }
    public void acid(View view){
        ba=true;
    }

    public void cleanbacid(View view) {
        TextView water = (TextView) findViewById(R.id.textView18);
        TextView kation = (TextView) findViewById(R.id.textView22);
        TextView anion = (TextView) findViewById(R.id.textView20);
        EditText m = (EditText) findViewById(R.id.editText);
        TextView l = (TextView) findViewById(R.id.textView4);
        TextView kcharge = (TextView) findViewById(R.id.textView24);
        TextView acharge = (TextView) findViewById(R.id.textView25);
        TextView aq1 = (TextView) findViewById(R.id.textView16);
        TextView aq2 = (TextView) findViewById(R.id.textView23);
        TextView plus = (TextView) findViewById(R.id.textView21);
        plus.setText("");
        aq1.setText("");
        aq2.setText("");
        kcharge.setText("");
        acharge.setText("");
        kation.setText("");
        anion.setText("");
        m.setText("");
        water.setText("H2O");
        l.setText("(l)");
    }

    public void bacid(View view) {
        int countH = 0;
        int countAZ = 0;
        Matter first = new Matter();
        TextView water = (TextView) findViewById(R.id.textView18);
        TextView kation = (TextView) findViewById(R.id.textView22);
        TextView anion = (TextView) findViewById(R.id.textView20);
        EditText m = (EditText) findViewById(R.id.editText);
        TextView l = (TextView) findViewById(R.id.textView4);
        TextView kcharge = (TextView) findViewById(R.id.textView24);
        TextView acharge = (TextView) findViewById(R.id.textView25);
        TextView aq1 = (TextView) findViewById(R.id.textView16);
        TextView aq2 = (TextView) findViewById(R.id.textView23);
        TextView plus = (TextView) findViewById(R.id.textView21);
        RadioButton a = (RadioButton) findViewById(R.id.radioButton);
        RadioButton b = (RadioButton) findViewById(R.id.radioButton2);
        String matter = m.getText().toString();
        plus.setText("");
        anion.setText("");
        kation.setText("");
        aq1.setText("");
        aq2.setText("");
        acharge.setText("");
        kcharge.setText("");
        water.setText("H2O");
        l.setText("(l)  ");
        if (matter.length() != 0) {
            int i;
            String temp = "";
            for (i = 0; i < matter.length(); i++) {
                char tav = matter.charAt(i);
                if (tav != ' ') {
                    temp = temp + tav;
                }
            }
            matter = temp;
            plus.setText(" + ");
            first.setName(matter);
            first.removeBA();
            m.setText(first.getName());
            String[] ion = first.BaseAcid(ba);
            int num = Matter.exceptionalH(matter);
            for (i = 0; i < first.getName().length(); i++) {
                if (first.getName().charAt(i) >= 'A') {
                    if (first.getName().charAt(i) <= 'Z') {
                        countAZ++;
                    }
                }
            }
            if (num != 0) {
                switch (num) {
                    case 1:
                        b.setChecked(false);
                        a.setChecked(true);
                        anion.setText("SO4");
                        acharge.setText("2-");
                        aq2.setText(R.string.aq);
                        water.setText("2H2O");
                        kation.setText("2H3O");
                        kcharge.setText(R.string.plus);
                        aq1.setText(R.string.aq);
                        return;
                    case 2:
                        a.setChecked(false);
                        b.setChecked(true);
                        kation.setText("H2CO3");
                        plus.setText("");
                        aq1.setText(R.string.aq);
                        return;
                    case 3:
                        a.setChecked(false);
                        b.setChecked(true);
                        kation.setText("H2SO3");
                        plus.setText("");
                        aq1.setText(R.string.aq);
                        return;
                    default:
                        return;
                }
            }
            if (typeError(first.getName())) {
                kation.setText(R.string.type_Error);
                plus.setText("");
                return;
            }
            if (ba) {
                for (i = 0; i < first.getName().length(); i++) {
                    if (first.getName().charAt(i) == 'H') {
                        countH++;
                    }
                }
                if (countH == 0) {
                    kation.setText(R.string.no_Acid);
                    plus.setText("");
                } else if (countH == 1 && countAZ == 1) {
                    kation.setText(R.string.no_Acid);
                    plus.setText("");
                } else {
                    anion.setText(ion[0]);
                    acharge.setText(ion[1]);
                    aq2.setText(R.string.aq);
                    kation.setText(R.string.H3O);
                    aq1.setText(R.string.aq);
                    kcharge.setText(R.string.plus);
                }
            }
            if (!ba) {
                kation.setText(ion[0]);
                kcharge.setText(ion[1]);
                aq1.setText(R.string.aq);
                anion.setText(R.string.OH);
                aq2.setText(R.string.aq);
                acharge.setText(R.string.minus);
            }
        }
    }

    public String removeBA(String symbol) {
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
        if (count > 1) {
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
        int countB = 0;
        matter = removeBA(matter);
        if (matter.charAt(0) >= 'a' && matter.charAt(0) <= 'z') {
            return true;
        }
        i = 0;
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
            if ((tav < 'a' || tav > 'z') && ((tav < 'A' || tav > 'Z') && ((tav < '0' || tav > '9') && tav != '-' && tav != '+' && tav != '.' && tav != '(' && tav != ')' && tav != '{' && tav != '}'))) {
                return true;
            }
        }
        if (matter.length() == 1) {
            tav = matter.charAt(0);
            if (tav == '-' || tav == '+' || tav == '.' || tav == ')') {
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
            //Already At Base/Acid
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
