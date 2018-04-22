package e.msesrivera.calculadoracientifica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class VelocidadActivity extends AppCompatActivity {

    EditText edtDistancia, edtTiempo, edtVel;
    Button btnCalc;
    TextView txtResult;
    ImageButton ibtnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocidad);

        edtDistancia = (EditText) findViewById(R.id.edtDistanciaVel);
        edtTiempo = (EditText) findViewById(R.id.edtTiempoVel);
        edtVel = (EditText) findViewById(R.id.edtVelVel);
        btnCalc = (Button) findViewById(R.id.btnCalcVel);
        ibtnMenu = (ImageButton) findViewById(R.id.ibtnMenuVel);

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

        ibtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.right_in,R.anim.right_out);
            }
        });

    }
}
