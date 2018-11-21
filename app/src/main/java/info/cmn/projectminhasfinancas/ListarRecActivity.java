package info.cmn.projectminhasfinancas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class ListarRecActivity extends AppCompatActivity {

    ListView mListView;
    DataBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_rec);

        mListView = findViewById(R.id.lista);

        helper = new DataBaseHelper(this);

        SQLiteDatabase db = helper.getReadableDatabase();

        String[] camposBD = {
                DataBaseHelper.COLUMN_NAME_VALOR,
                DataBaseHelper.COLUMN_NAME_DATA,
                DataBaseHelper.COLUMN_NAME_DESCRICAO
        };

        String[] where = {"receita"};

        Cursor cursor = db.query(DataBaseHelper.TABLE_NAME_OP,camposBD,DataBaseHelper.COLUMN_NAME_TIPO_OP+ " = ?", where,null,null,null);

        ArrayList<Receita> receitas = new ArrayList<>();
        while (cursor.moveToNext()) {
            String valor = cursor.getString(cursor.getColumnIndex("valor"));
            String data = cursor.getString(cursor.getColumnIndex("data"));
            String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
            receitas.add(new Receita(valor, data, descricao));
        }

        // Criar o adapter para listar os dados
        ArrayAdapter<Receita> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        adapter.addAll(receitas);

        // associa o Adapter a ListView
        mListView.setAdapter(adapter);
    }
}

