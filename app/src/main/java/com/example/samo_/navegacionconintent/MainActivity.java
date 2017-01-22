package com.example.samo_.navegacionconintent;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.samo_.navegacionconintent.Fragments.Calcular.FragmentCalcular;
import com.example.samo_.navegacionconintent.Fragments.Lista.ListFragmentLugares;
import com.example.samo_.navegacionconintent.Fragments.Lista.ObjetosLista.ListaLugares;
import com.example.samo_.navegacionconintent.Fragments.UtilidadesAndroid.FragmentUtilidadesAndroid;

////////////////////////////////////////////////////////////////////////////////////////////////////
// Se tiene que crear un proyecto como Navigation Drawer Activity y pegar
// 1 dentro de values: drawables, contiene la referencia de las imagenes de los item del menu
// 2 dentro de menu: activity_main_drawer, contiene los item del menu
// 3 dentro de app: support and recicleview
// 4 asegurate de que ningun elemento se copia con un valor diferente (21)
// 5 copiar el manifest
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , FragmentCalcular.OnFragmentInteractionListener, FragmentUtilidadesAndroid.OnFragmentInteractionListener, ListFragmentLugares.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment;

        switch (id) {
            case R.id.nav_calcular:
                fragment = new FragmentCalcular();
                getSupportFragmentManager().beginTransaction().add(R.id.content_main, fragment).commit();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_main, fragment).commit();
            break;
            case R.id.nav_varios:
                fragment = new FragmentUtilidadesAndroid();
                getSupportFragmentManager().beginTransaction().add(R.id.content_main, fragment).commit();
                FragmentManager fragmentManager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(R.id.content_main, fragment).commit();
            break;
            case R.id.nav_lista:
                fragment = new ListFragmentLugares();
                getSupportFragmentManager().beginTransaction().add(R.id.content_main, fragment).commit();
                FragmentManager fragmentManager3 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                fragmentTransaction3.replace(R.id.content_main, fragment).commit();
            break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(ListaLugares item) {

    }
}
