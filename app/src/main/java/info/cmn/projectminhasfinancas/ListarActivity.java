package info.cmn.projectminhasfinancas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarActivity extends AppCompatActivity {

    ListView mListView;
    DataBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        mListView = findViewById(R.id.lista);

        helper = new DataBaseHelper(this); // instancia Helper

        SQLiteDatabase db = helper.getReadableDatabase(); // instancia BD em modo de leitura

        // Campos a serem lido do BD
        String[] campos = {
                DataBaseHelper.COLUMN_NAME_LOGIN
        };

        // Cursor contém o resultado da consulta
        Cursor cursor = db.query(DataBaseHelper.TABLE_NAME,campos,null,null,null,null,null);

        // Monta um ArrayList com os dados da consulta
        ArrayList<String> nomes = new ArrayList<>();
        while (cursor.moveToNext()) { // enquanto houver dados para serem lidos, faça
//            adiciona no arraylist o dados lido do banco
            String login = cursor.getString(cursor.getColumnIndex("login"));
            nomes.add(login);
        }

        // Criar o adapter para listar os dados
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.addAll(nomes);

        // associa o Adapter a ListView
        mListView.setAdapter(adapter);
    }
}
