package treinaweb.com.br.primeiroprojeto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tela1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        final Button button = (Button) findViewById(R.id.buttonProximo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Carregando...", Toast.LENGTH_LONG).show();
                Runnable clickButton = new Runnable() {
                    @Override
                    public void run() {
                        TextView tvResultado = (TextView) findViewById(R.id.textViewResposta);
                        EditText txtNome = (EditText) findViewById(R.id.editTextNome);
                        String msg = "Nome: " + txtNome.getText().toString();
                        tvResultado.setText(msg);
                    }
                };
                button.postDelayed(clickButton, 3000); //Delay for 3 seconds to show the result
                Intent intencao = new Intent(Tela1.this, Tela2.class);
                startActivity(intencao);
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela1, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void cliqueTeste(View view) {
        Toast.makeText(getApplicationContext(), "Testanto...", Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "OK!", Toast.LENGTH_SHORT).show();
    }
}
