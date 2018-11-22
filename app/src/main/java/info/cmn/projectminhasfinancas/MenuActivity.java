package info.cmn.projectminhasfinancas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btAdicionar = (Button) findViewById(R.id.btAdicionar);
        Button btListar = (Button) findViewById(R.id.btListar);
        Button btExcluir = (Button) findViewById(R.id.btExcluir);


        btAdicionar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ReceitasActivity.class));
            }
        });

        btListar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ListarRecActivity.class));
            }
        });

        btExcluir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), DeleteRecActivity.class));
            }
        });

    }
}
