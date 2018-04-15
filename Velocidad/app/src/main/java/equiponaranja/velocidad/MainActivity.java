package equiponaranja.velocidad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtDistancia, edtTiempo, edtVel;
    Button btnCalc;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtDistancia = (EditText) findViewById(R.id.edtDistancia);
        edtTiempo = (EditText) findViewById(R.id.edtTiempo);
        edtVel = (EditText) findViewById(R.id.edtVel);
        btnCalc = (Button) findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strDistancia, strTiempo, strVelocidad;
                strDistancia = edtDistancia.getText().toString();
                strTiempo = edtTiempo.getText().toString();
                strVelocidad = edtVel.getText().toString();
                if (strVelocidad.length()<=0 && strDistancia.length()>0 && strTiempo.length()>0) {
                    double dblResVel = (Double.valueOf(strDistancia) / Double.valueOf(strTiempo));
                    edtVel.setText("" + dblResVel);
                }
                else if (strDistancia.length()<=0 && strVelocidad.length()>0 && strTiempo.length()>0){
                    double dblResultDis = ((Double.valueOf(strVelocidad)*(Double.valueOf(strTiempo))));
                    edtDistancia.setText(""+dblResultDis);
                }
                else if (strDistancia.length()>0 && strVelocidad.length()>0 && strTiempo.length()<=0){
                    double dblResultTie = ((Double.valueOf(strDistancia)/(Double.valueOf(strVelocidad))));
                    edtTiempo.setText(""+dblResultTie);
                }
            }

        });

    }
}