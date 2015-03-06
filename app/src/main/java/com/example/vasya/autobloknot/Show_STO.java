package com.example.vasya.autobloknot;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;


public class Show_STO extends ActionBarActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    DataBase dbAdapter;
    Cursor cursor;
    SimpleCursorAdapter simpleCursorAdapter;
    ListView listView2;
    private static final int CM_DELETE_ID = 1;
    private static final int CM_UPDATE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__sto);
        dbAdapter = new DataBase(this);
        cursor = dbAdapter.getAllItemSTO();

        String[] from = new String[] {"data", "suma", "desc"};
        int[] to = new int[] {R.id.tv_STO_data, R.id.tv_STO_suma, R.id.tv_STO_desc};

        simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.item_sto, cursor, from, to, 0 );

        listView2 = (ListView)findViewById(R.id.listView2);
        listView2.setAdapter(simpleCursorAdapter);
        dbAdapter.Close();

        registerForContextMenu(listView2);
        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, CM_DELETE_ID, 0, "Удалить");
        menu.add(0, CM_UPDATE, 0, "Редактировать");
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportLoaderManager().getLoader(0).forceLoad();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == CM_DELETE_ID){
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            long id = acmi.id;
            dbAdapter.delRecSTO(acmi.id);
            getSupportLoaderManager().getLoader(0).forceLoad();
            return true;
        }
        if(item.getItemId() == CM_UPDATE){
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            long id_u = acmi.id;
            String id = "" + id_u;
            Intent intent = new Intent(this, Update_STO.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new MyCursorLoader(this, dbAdapter);    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        simpleCursorAdapter.swapCursor(cursor);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    static class MyCursorLoader extends CursorLoader {

        DataBase db;

        public MyCursorLoader(Context context, DataBase db) {
            super(context);
            this.db = db;
        }

        @Override
        public Cursor loadInBackground() {
            Cursor cursor = db.getAllItemSTO();
            return cursor;
        }

    }
}
