package info.cmn.projectminhasfinancas;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteRecActivity extends AppCompatActivity {

    EditText campoDel;
    Button btDelete;

    DataBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_rec);

        campoDel = (EditText)findViewById(R.id.et_deletar);
        btDelete = (Button) findViewById(R.id.btDelete);


        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteReceita();
                startActivity(new Intent(getBaseContext(), ListarRecActivity.class));
            }
        });
    }

    public void deleteReceita()
    {

        helper = new DataBaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String id = campoDel.getText().toString();

        String [] campo = {id};

        if (id == ""){
            Toast.makeText(getBaseContext(), "Receita não inserida, tente novamente", Toast.LENGTH_SHORT).show();
        }
        else {
            int res = db.delete(DataBaseHelper.TABLE_NAME_OP, null, null);
//            int res = db.delete(DataBaseHelper.TABLE_NAME_OP, "id = ?", campo);

            if (res != -1){
                Toast.makeText(getBaseContext(), "Deletado com sucesso", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getBaseContext(), "Erro, tente novamente", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
