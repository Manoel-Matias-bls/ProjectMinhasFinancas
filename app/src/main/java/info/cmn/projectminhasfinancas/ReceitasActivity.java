package info.cmn.projectminhasfinancas;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.Date;

public class ReceitasActivity extends AppCompatActivity {

    DataBaseHelper helper;
    EditText valor,categoria;
    Text descricao, data;
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
                salvarReceita(valor.getText().toString(), data.getData(), descricao.getData(), categoria.getText().toString());
            }
        });


    }

    public void salvarReceita(String valor, String data, String descricao, String categoria)
    {
        helper = new DataBaseHelper(this);

        SQLiteDatabase db = helper.getReadableDatabase();

        String[] campos = {
                DataBaseHelper.COLUMN_NAME_LOGIN,
                DataBaseHelper.COLUMN_NAME_SENHA
        };

        String[] args = {
                valor,
                data,
                descricao,
                categoria
        };

        Cursor cursor = db.query(DataBaseHelper.TABLE_NAME, campos,"login = ? and senha = ?", args,null,null,null);

       // return cursor != null && cursor.getCount() == 1;
    }
}
