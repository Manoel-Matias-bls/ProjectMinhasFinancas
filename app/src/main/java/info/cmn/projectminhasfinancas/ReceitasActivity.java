package info.cmn.projectminhasfinancas;

import android.content.ContentValues;
import android.content.Intent;
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
                salvarReceita();
                startActivity(new Intent(getBaseContext(), ListarRecActivity.class));
            }
        });


    }

    public void salvarReceita()
    {
        helper = new DataBaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.COLUMN_NAME_TIPO_OP, "receita");
        values.put(DataBaseHelper.COLUMN_NAME_VALOR, valor.getText().toString());
        values.put(DataBaseHelper.COLUMN_NAME_DATA, data.getText().toString());
        values.put(DataBaseHelper.COLUMN_NAME_DESCRICAO, descricao.getText().toString());
        values.put(DataBaseHelper.COLUMN_NAME_CATEGORIA, categoria.getText().toString());

        // Realiza a inserção dos dados e retorna o ID do elemento inserido
        long newId = db.insert(DataBaseHelper.TABLE_NAME_OP,null, values);

        // Retorna -1 caso não tenha dado certo a inserção
        if (newId != -1)
            Toast.makeText(this,"Dados inseridos", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Erro ao inserir dados", Toast.LENGTH_LONG).show();

    }

}
