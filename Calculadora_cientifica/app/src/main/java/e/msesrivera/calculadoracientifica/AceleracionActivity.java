package e.msesrivera.calculadoracientifica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class AceleracionActivity extends AppCompatActivity {

    EditText edtAceleracion,edtVelFinal,edtVelInicial,edtTiempo;
    Button btnCalcular;
    ImageButton ibtnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceleracion);

        edtAceleracion=(EditText)findViewById(R.id.edtAceleracionAcel);
        edtVelFinal=(EditText)findViewById(R.id.edtVelFinalAcel);
        edtVelInicial=(EditText)findViewById(R.id.edtVelInicialAcel);
        edtTiempo=(EditText)findViewById(R.id.edtTiempoAcel);
        btnCalcular=(Button)findViewById(R.id.btnCalcularAcel);
        ibtnMenu=(ImageButton)findViewById(R.id.ibtnMenuAcel);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strAceleracion,strVelFinal,strVelInicial,strTiempo;
                strAceleracion=edtAceleracion.getText().toString();
                strVelFinal=edtVelFinal.getText().toString();
                strVelInicial=edtVelInicial.getText().toString();
                strTiempo=edtTiempo.getText().toString();
                if (strAceleracion.length()<=0 && strTiempo.length()>0
                        && strVelFinal.length()>0 && strVelInicial.length()>0){
                    double f=((Double.valueOf(strVelFinal))-(Double.valueOf(strVelInicial)))/((Double.valueOf(strTiempo)));
                    edtAceleracion.setText(f +"");
                }
                else if (strAceleracion.length()>0 && strTiempo.length()<=0
                        && strVelFinal.length()>0 && strVelInicial.length()>0){
                    double f=((Double.valueOf(strVelFinal))-(Double.valueOf(strVelInicial)))/(Double.valueOf(strAceleracion));
                    edtTiempo.setText(f +"");
                }
                else if (strAceleracion.length()>0 && strTiempo.length()>0
                        && strVelFinal.length()<=0 && strVelInicial.length()>0){
                    double f=((Double.valueOf(strVelInicial))+((Double.valueOf(strAceleracion)))*(Double.valueOf(strTiempo)));
                    edtVelFinal.setText(f+"");
                }
                else if (strAceleracion.length()>0 && strTiempo.length()>0
                        && strVelFinal.length()>0 && strVelInicial.length()<=0){
                    double f=(Double.valueOf(strVelFinal)-((Double.valueOf(strAceleracion))*(Double.valueOf(strTiempo))));
                    edtVelInicial.setText(f+"");
                }
            }
        });

        ibtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
            }
        });
    }
}
