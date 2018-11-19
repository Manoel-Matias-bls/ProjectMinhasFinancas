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

public class MainActivity extends AppCompatActivity {

    DataBaseHelper helper;
    EditText usuario,senha;
    Button cadastrar, login, listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DataBaseHelper(this);

        // Resgatar dados do XML
        usuario = findViewById(R.id.usuario);
        senha = findViewById(R.id.senha);
        cadastrar = findViewById(R.id.cadastrar);
        login = findViewById(R.id.login);
        listar = findViewById(R.id.listar);

        // Ao clicar no botão cadastrar
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarDados();
            }
        });

        // Ao clicar no botão chama método login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        // Ao clicar no botão listar
        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listarDados();
            }
        });

    }

    private void listarDados() {
        // Abre a tela de listagem dos usuários
        startActivity(new Intent(MainActivity.this,ListarActivity.class));
    }

    private void login() {
        // Abre a tela para usuário efeutar login
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }

    private void salvarDados() {
        // Instancia o bando de dados em modo de escrita
        SQLiteDatabase db = helper.getWritableDatabase();

        // Monta a associção das colunas da tabela com os dados
//        a serem inseridos
        ContentValues values = new ContentValues();
        values.put("login",usuario.getText().toString());
        values.put("senha",senha.getText().toString());

        // Realiza a inserção dos dados e retorna o ID do elemento inserido
        long newId = db.insert(DataBaseHelper.TABLE_NAME,null,values);

        // Retorna -1 caso não tenha dado certo a inserção
        if (newId != -1)
            Toast.makeText(this,"Dados inseridos", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Erro ao inserir dados", Toast.LENGTH_LONG).show();
    }
}
