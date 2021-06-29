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

public class Stoichiometry extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoichiometry);
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

    public void clearSto(View view){
        EditText form1=(EditText)findViewById(R.id.f1);
        form1.setText("");
        EditText form2=(EditText)findViewById(R.id.f2);
        form2.setText("");
        EditText molar1=(EditText)findViewById(R.id.molar1);
        molar1.setText("");
        EditText molar2=(EditText)findViewById(R.id.molar2);
        molar2.setText("");
        EditText mol1=(EditText)findViewById(R.id.mol1);
        mol1.setText("");
        EditText mol2=(EditText)findViewById(R.id.mol2);
        mol2.setText("");
        EditText mass1=(EditText)findViewById(R.id.mass1);
        mass1.setText("");
        EditText mass2=(EditText)findViewById(R.id.mass2);
        mass2.setText("");
        EditText volg1=(EditText)findViewById(R.id.volg1);
        volg1.setText("");
        EditText volg2=(EditText)findViewById(R.id.volg2);
        volg2.setText("");
        EditText molvol1=(EditText)findViewById(R.id.molvol1);
        molvol1.setText("");
        EditText molvol2=(EditText)findViewById(R.id.molvol2);
        molvol2.setText("");
        EditText voll1=(EditText)findViewById(R.id.voll1);
        voll1.setText("");
        EditText voll2=(EditText)findViewById(R.id.voll2);
        voll2.setText("");
        EditText con1=(EditText)findViewById(R.id.con1);
        con1.setText("");
        EditText con2=(EditText)findViewById(R.id.con2);
        con2.setText("");
    }

    public void sto(View view){
        int k;
        char tav3;
        Matter first = new Matter();
        Matter second = new Matter();
        EditText f1 = (EditText) findViewById(R.id.f1);
        String formula1 = f1.getText().toString();
        EditText f2 = (EditText) findViewById(R.id.f2);
        String formula2 = f2.getText().toString();
        EditText molars1 = (EditText) findViewById(R.id.molar1);
        EditText molars2 = (EditText) findViewById(R.id.molar2);
        EditText mols1 = (EditText) findViewById(R.id.mol1);
        String mol1 = mols1.getText().toString();
        EditText mols2 = (EditText) findViewById(R.id.mol2);
        EditText masss1 = (EditText) findViewById(R.id.mass1);
        String mass1 = masss1.getText().toString();
        EditText masss2 = (EditText) findViewById(R.id.mass2);
        EditText volgs1 = (EditText) findViewById(R.id.volg1);
        String volg1 = volgs1.getText().toString();
        EditText volgs2 = (EditText) findViewById(R.id.volg2);
        String volg2 = volgs2.getText().toString();
        EditText molvols1 = (EditText) findViewById(R.id.molvol1);
        String molvol1 = molvols1.getText().toString();
        EditText molvols2 = (EditText) findViewById(R.id.molvol2);
        String molvol2 = molvols2.getText().toString();
        EditText volls1 = (EditText) findViewById(R.id.voll1);
        String voll1 = volls1.getText().toString();
        EditText volls2 = (EditText) findViewById(R.id.voll2);
        String voll2 = volls2.getText().toString();
        EditText cons1 = (EditText) findViewById(R.id.con1);
        String con1 = cons1.getText().toString();
        EditText cons2 = (EditText) findViewById(R.id.con2);
        String con2 = cons2.getText().toString();
        if (formula1.length() != 0) {
            String temp2 = "";
            for (k = 0; k < formula1.length(); k++) {
                tav3 = formula1.charAt(k);
                if (tav3 != ' ') {
                    temp2 = temp2 + tav3;
                }
            }
            formula1 = temp2;
            f1.setText(formula1);
            if (typeError(formula1)) {
                molars1.setText(R.string.type_Error);
                mols1.setText("");
                masss1.setText("");
                volgs1.setText("");
                molvols1.setText("");
                volls1.setText("");
                cons1.setText("");
            } else {
                first.setName(formula1);
                first.findMolar();
                molars1.setText(first.getMolar() + "");
                if (mol1.length() != 0) {
                    first.setMol(first.toFloat(mol1));
                    first.findMass();
                    masss1.setText(first.getMass() + "");
                    if (volg1.length() != 0) {
                        first.setVolumeg(first.toFloat(volg1));
                        first.findMolarvol();
                        molvols1.setText(first.getMolarvol() + "");
                    } else if (molvol1.length() != 0) {
                        first.setMolarvol(first.toFloat(molvol1));
                        first.findVolumeg();
                        volgs1.setText(first.getVolumeg() + "");
                    }
                    if (voll1.length() != 0) {
                        first.setVolumel(first.toFloat(voll1));
                        first.findConcentration();
                        cons1.setText(first.getConcentration() + "");
                    } else if (con1.length() != 0) {
                        first.setConcentration(first.toFloat(con1));
                        first.findVolc();
                        volls1.setText(first.getVolumel() + "");
                    }
                } else if (mass1.length() != 0) {
                    first.setMass(first.toFloat(mass1));
                    first.findMolM();
                    mols1.setText(first.getMol() + "");
                    if (volg1.length() != 0) {
                        first.setVolumeg(first.toFloat(volg1));
                        first.findMolarvol();
                        molvols1.setText(first.getMolarvol() + "");
                    } else if (molvol1.length() != 0) {
                        first.setMolarvol(first.toFloat(molvol1));
                        first.findVolumeg();
                        volgs1.setText(first.getVolumeg() + "");
                    }
                    if (con1.length() != 0) {
                        first.setConcentration(first.toFloat(con1));
                        first.findVolc();
                        volls1.setText(first.getVolumel() + "");
                    } else if (voll1.length() != 0) {
                        first.setVolumel(first.toFloat(voll1));
                        first.findConcentration();
                        cons1.setText(first.getConcentration() + "");
                    }
                } else if (volg1.length() != 0) {
                    first.setVolumeg(first.toFloat(volg1));
                    if (molvol1.length() != 0) {
                        first.setMolarvol(first.toFloat(molvol1));
                        first.findMolVG();
                        mols1.setText(first.getMol() + "");
                        first.findMass();
                        masss1.setText(first.getMass() + "");
                    }
                } else if (con1.length() != 0) {
                    first.setConcentration(first.toFloat(con1));
                    if (voll1.length() != 0) {
                        first.setVolumel(first.toFloat(voll1));
                        first.findMolc();
                        mols1.setText(first.getMol() + "");
                        first.findMass();
                        masss1.setText(first.getMass() + "");
                    }
                }
            }
        }
        if (formula2.length() != 0) {
            int i;
            char tav;
            String temp = "";
            for (k = 0; k < formula2.length(); k++) {
                tav3 = formula2.charAt(k);
                if (tav3 != ' ') {
                    temp = temp + tav3;
                }
            }
            formula2 = temp;
            f2.setText(formula2);
            boolean stupid = false;
            for (i = 0; i < formula2.length() - 2; i++) {
                tav = formula2.charAt(i);
                if ((tav < '0' || tav > '9') && tav != '.') {
                    stupid = true;
                }
            }
            if (formula2.charAt(formula2.length() - 2) == 'k') {
                if (formula2.charAt(formula2.length() - 1) == 'j' && !stupid) {
                    mols2.setText("");
                    masss2.setText("");
                    volgs2.setText("");
                    molvols2.setText("");
                    volls2.setText("");
                    cons2.setText("");
                    String kj = "";
                    if (formula2.charAt(0) == '-') {
                        for (i = 1; i < formula2.length() - 2; i++) {
                            tav = formula2.charAt(i);
                            kj = kj + tav;
                        }
                    } else {
                        for (i = 0; i < formula2.length() - 2; i++) {
                            tav = formula2.charAt(i);
                            kj = kj + tav;
                        }
                    }
                    second.setName(kj);
                    if (formula1.length() != 0) {
                        double toFloat;
                        if (formula2.charAt(0) == '-') {
                            toFloat = (double) (second.toFloat(kj) * -1.0f);
                            second.setMolar((float) ((toFloat / first.findCoefficient()) * ((double) first.getMol())));
                        } else {
                            toFloat = (double) second.toFloat(kj);
                            second.setMolar((float) ((toFloat / first.findCoefficient()) * ((double) first.getMol())));
                        }
                        molars2.setText(second.getMolar() + "");
                        return;
                    }
                    return;
                }
            }
            if (typeError(formula2)) {
                molars2.setText(R.string.type_Error);
                mols2.setText("");
                masss2.setText("");
                volgs2.setText("");
                molvols2.setText("");
                volls2.setText("");
                cons2.setText("");
                return;
            }
            second.setName(formula2);
            second.findMolar();
            molars2.setText(second.getMolar() + "");
            if (formula1.length() != 0 && mols1.length() != 0) {
                second.setMol((float) ((((double) first.getMol()) / first.findCoefficient()) * second.findCoefficient()));
                mols2.setText(second.getMol() + "");
                second.findMass();
                masss2.setText(second.getMass() + "");
                if (molvol2.length() != 0) {
                    second.setMolarvol(second.toFloat(molvol2));
                    second.findVolumeg();
                    volgs2.setText(second.getVolumeg() + "");
                } else if (volg2.length() != 0) {
                    second.setVolumeg(second.toFloat(volg2));
                    second.findMolarvol();
                    molvols2.setText(second.getMolarvol() + "");
                } else if (voll2.length() != 0) {
                    second.setVolumel(second.toFloat(voll2));
                    second.findConcentration();
                    cons2.setText(second.getConcentration() + "");
                } else if (con2.length() != 0) {
                    second.setConcentration(second.toFloat(con2));
                    second.findVolc();
                    volls2.setText(second.getVolumel() + "");
                }
            }
        }
    }

    public boolean typeError(String matter) {
        int i;
        char tav;
        int count = 0;
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
        if ((matter.charAt(0) >= 'a' && matter.charAt(0) <= 'z') || matter.charAt(0) == '+' || matter.charAt(0) == '-' || matter.charAt(0) == ')') {
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
            if (tav == '-' || tav == '+' || tav == '.' || tav == '(' || tav == ')') {
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
            //Already At Stoichiometry
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
