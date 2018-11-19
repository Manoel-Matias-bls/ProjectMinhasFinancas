package info.cmn.projectminhasfinancas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    DataBaseHelper helper;
    EditText usuario,senha;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.usuario);
        senha = findViewById(R.id.senha);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(login(usuario.getText().toString(), senha.getText().toString())) {
                    Log.d("Cursor", "Login bem sucedido");
//                    startActivity(new Intent(getBaseContext(), MainCalendarActivity.class));
                    startActivity(new Intent(getBaseContext(), MenuActivity.class));
                    //Toast.makeText(this, "Login bem sucedido", Toast.LENGTH_LONG).show();
                }else
                    Log.d("Cursor", "Login falhou");

            }
        });

    }


    public boolean login(String usuario, String senha)
    {
        helper = new DataBaseHelper(this);

        SQLiteDatabase db = helper.getReadableDatabase();

        String[] campos = {
                DataBaseHelper.COLUMN_NAME_LOGIN,
                DataBaseHelper.COLUMN_NAME_SENHA
        };

        String[] args = {
                usuario,
                senha
        };

        Cursor cursor = db.query(DataBaseHelper.TABLE_NAME, campos,"login = ? and senha = ?", args,null,null,null);

        return cursor != null && cursor.getCount() == 1;

    }

}
