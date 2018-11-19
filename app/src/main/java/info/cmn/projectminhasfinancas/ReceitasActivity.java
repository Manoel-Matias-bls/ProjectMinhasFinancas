package info.cmn.projectminhasfinancas;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReceitasActivity extends AppCompatActivity {

    DataBaseHelper helper;
    EditText valor,categoria, data, descricao;
    Button salvar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receitas);

        valor = findViewById(R.id.valorReceita);
        data =  findViewById(R.id.data);
        descricao = findViewById(R.id.descricao);
        categoria = findViewById(R.id.categoria);
        salvar = findViewById(R.id.salvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarReceita(valor.getText().toString(), data.getText().toString(), descricao.getText().toString(), categoria.getText().toString());
            }
        });


    }

    public void salvarReceita(String valores, String date, String descricao, String categoria)
    {
        SQLiteDatabase db = helper.getWritableDatabase();

        Double valor = Double.parseDouble(valores);
        //Date data = new Date(date);

        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.COLUMN_NAME_VALOR, valor);
        values.put(DataBaseHelper.COLUMN_NAME_DATA, date);
        values.put(DataBaseHelper.COLUMN_NAME_DESCRICAO, descricao);
        values.put(DataBaseHelper.COLUMN_NAME_CATEGORIA, categoria);

        // Realiza a inserção dos dados e retorna o ID do elemento inserido
        long newId = db.insert(DataBaseHelper.TABLE_NAME_RC,null, values);

        // Retorna -1 caso não tenha dado certo a inserção
        if (newId != -1)
            Toast.makeText(this,"Dados inseridos", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Erro ao inserir dados", Toast.LENGTH_LONG).show();

    }

}
