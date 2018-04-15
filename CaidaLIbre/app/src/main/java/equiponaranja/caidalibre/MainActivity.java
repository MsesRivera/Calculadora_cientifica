package equiponaranja.caidalibre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Button btnForm1,btnForm2,btnForm3;
    EditText edtY1,edtH,edtG1,edtT1,edtV2,edtG2,edtT2,edtA3,edtG3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtY1=(EditText)findViewById(R.id.edtY1);
        edtH=(EditText)findViewById(R.id.edtH);
        edtG1=(EditText)findViewById(R.id.edtG1);
        edtT1=(EditText)findViewById(R.id.edtT1);
        edtV2=(EditText)findViewById(R.id.edtV2);
        edtG2=(EditText)findViewById(R.id.edtG2);
        edtT2=(EditText)findViewById(R.id.edtT2);
        edtA3=(EditText)findViewById(R.id.edtA3);
        edtG3=(EditText)findViewById(R.id.edtG3);

        btnForm1=(Button)findViewById(R.id.btnForm1);
        btnForm2=(Button)findViewById(R.id.btnForm2);
        btnForm3=(Button)findViewById(R.id.btnForm3);

        btnForm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strY,strH,strG,strT;
                strY=edtY1.getText().toString();
                strH=edtH.getText().toString();
                strG=edtG1.getText().toString();
                strT=edtT1.getText().toString();

                double y,h,g,t;
                if (strY.length()<=0 && strH.length()>0 && strG.length()>0 && strT.length()>0){
                    h=Double.valueOf(strH);
                    g=Double.valueOf(strG);
                    t=Double.valueOf(strT);
                    y=h-((g*(t*t))/2);
                    edtY1.setText("" + y);
                }
                else if (strY.length()>0 && strH.length()<=0 && strG.length()>0 && strT.length()>0){
                    y=Double.valueOf(strY);
                    g=Double.valueOf(strG);
                    t=Double.valueOf(strT);
                    h=y+((g*(t*t))/2);
                    edtH.setText("" + h);
                }
                else if (strY.length()>0 && strH.length()>0 && strG.length()<=0 && strT.length()>0){
                    y=Double.valueOf(strY);
                    h=Double.valueOf(strH);
                    t=Double.valueOf(strT);
                    g=(2*(y-h))/(t*t);
                    edtG1.setText("" + g);
                }
                else if (strY.length()>0 && strH.length()>0 && strG.length()>0 && strT.length()<=0){
                    y=Double.valueOf(strY);
                    g=Double.valueOf(strG);
                    h=Double.valueOf(strH);
                    t=java.lang.Math.sqrt((-2*(y-h))/g);
                    edtT1.setText("" + t);
                }
            }
        });
        btnForm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strV,strG,strT;
                strV=edtV2.getText().toString();
                strG=edtG2.getText().toString();
                strT=edtT2.getText().toString();

                double vel,g,t;
                if (strV.length()<=0 && strG.length()>0 && strT.length()>0){
                    g=Double.valueOf(strG);
                    t=Double.valueOf(strT);
                    vel=(-1*g)*t;
                    edtV2.setText(""+vel);
                }
                else if (strV.length()>0 && strG.length()<=0 && strT.length()>0){
                    vel=Double.valueOf(strV);
                    t=Double.valueOf(strT);
                    g=(-1)*(vel/t);
                    edtG2.setText(""+g);
                }
                else if (strV.length()>0 && strG.length()>0 && strT.length()<=0){
                    g=Double.valueOf(strG);
                    vel=Double.valueOf(strV);
                    t=vel/(-1*g);
                    edtT2.setText(""+t);
                }

            }
        });
        btnForm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strA,strG;
                double a,g;
                strA=edtA3.getText().toString();
                strG=edtG3.getText().toString();
                if (strA.length()<=0 && strG.length()>0){
                    g=Double.valueOf(strG);
                    a=(-1*g);
                    edtA3.setText(""+a);
                }
                else if (strA.length()>0 && strG.length()<0){
                    a=Double.valueOf(strA);
                    g=(-1*a);
                    edtG3.setText(""+g);
                }
            }
        });
    }
}
