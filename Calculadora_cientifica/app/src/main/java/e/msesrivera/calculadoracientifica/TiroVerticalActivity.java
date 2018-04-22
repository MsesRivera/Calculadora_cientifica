package e.msesrivera.calculadoracientifica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class TiroVerticalActivity extends AppCompatActivity {

    EditText edtY1,edtH1,edtVo1,edtT1,edtG1,edtV2,edtVo2,edtG2,edtT2,edtA3,edtG3;
    TextView txvT1;
    Button btnForm1,btnForm2,btnForm3;
    ImageButton ibtnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiro_vertical);

        edtY1=(EditText)findViewById(R.id.edtY1Tiro);
        edtH1=(EditText)findViewById(R.id.edtH1Tiro);
        edtVo1=(EditText)findViewById(R.id.edtVo1Tiro);
        edtT1=(EditText)findViewById(R.id.edtT1Tiro);
        edtG1=(EditText)findViewById(R.id.edtG1Tiro);
        edtV2=(EditText)findViewById(R.id.edtV2Tiro);
        edtVo2=(EditText)findViewById(R.id.edtVo2Tiro);
        edtG2=(EditText)findViewById(R.id.edtG2Tiro);
        edtT2=(EditText)findViewById(R.id.edtT2Tiro);
        edtA3=(EditText)findViewById(R.id.edtA3Tiro);
        edtG3=(EditText)findViewById(R.id.edtG3Tiro);

        txvT1=(TextView)findViewById(R.id.txvT1Tiro);

        btnForm1=(Button)findViewById(R.id.btnForm1Tiro);
        btnForm2=(Button)findViewById(R.id.btnForm2Tiro);
        btnForm3=(Button)findViewById(R.id.btnForm3Tiro);

        ibtnMenu=(ImageButton)findViewById(R.id.ibtnMenuTiro);

        btnForm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strY,strH,strVo,strT,strG;
                strY=edtY1.getText().toString();
                strH=edtH1.getText().toString();
                strVo=edtVo1.getText().toString();
                strT=edtT1.getText().toString();
                strG=edtG1.getText().toString();

                double y,h,vo,t,g;

                txvT1.setText(strT);

                if (strY.length()<=0 && strH.length()>0 && strVo.length()>0
                        && strT.length()>0 && strG.length()>0){
                    h=Double.valueOf(strH);
                    vo=Double.valueOf(strVo);
                    t=Double.valueOf(strT);
                    g=Double.valueOf(strG);
                    if (vo>0) y=h+(vo*t)-((g*(t*t))/2);
                    else y=h-(vo*t)-((g*(t*t))/2);
                    edtY1.setText(""+y);
                }
                else if (strY.length()>0 && strH.length()>0 && strVo.length()>0
                        && strT.length()<=0 && strG.length()>0){
                    vo=Double.valueOf(strVo);
                    g=Double.valueOf(strG);
                    y=Double.valueOf(strY);
                    h=Double.valueOf(strH);
                    t=((-1*vo)+(java.lang.Math.sqrt((vo*vo)+(2*g*y))))/g;
                    if (t<0) t=((-1*vo)-(java.lang.Math.sqrt((vo*vo)+(2*g*y))))/g;
                    edtT1.setText(""+t);
                }
                else if (strY.length()>0 && strH.length()<=0 && strVo.length()>0
                        && strT.length()>0 && strG.length()>0){
                    vo=Double.valueOf(strVo);
                    g=Double.valueOf(strG);
                    y=Double.valueOf(strY);
                    t=Double.valueOf(strT);
                    if (vo>0) h=y-(vo*t)+((g*(t*t))/2);
                    else h=y+(vo*t)+((g*(t*t))/2);
                    edtH1.setText(""+h);
                }
                else if(strY.length()>0 && strH.length()>0 && strVo.length()<=0
                        && strT.length()>0 && strG.length()>0){
                    t=Double.valueOf(strT);
                    g=Double.valueOf(strG);
                    y=Double.valueOf(strY);
                    h=Double.valueOf(strH);
                    vo=(y-h+((g*(t*t))/2))/t;
                    edtVo1.setText(""+vo);
                }
                else if (strY.length()>0 && strH.length()>0 && strVo.length()>0
                        && strT.length()>0 && strG.length()<=0){
                    y=Double.valueOf(strY);
                    h=Double.valueOf(strH);
                    vo=Double.valueOf(strVo);
                    t=Double.valueOf(strT);
                    if (vo>0) g=(2*(y-h-(vo*t))/(t*t));
                    else g=(2*(y-h-(vo*t))/(t*t));
                    edtG1.setText(""+g);
                }
            }
        });

        btnForm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strV,strVo,strG,strT;
                strV=edtV2.getText().toString();
                strVo=edtVo2.getText().toString();
                strG=edtG2.getText().toString();
                strT=edtT2.getText().toString();

                double vf=0,vo=0,g=0,t=0;

                if (strV.length()<=0 && strVo.length()>0 && strG.length()>0
                        && strT.length()>0){
                    vo=Double.valueOf(strVo);
                    g=Double.valueOf(strG);
                    t=Double.valueOf(strT);
                    vf=vo-(g*t);
                    edtV2.setText(""+vf);
                }
                else if (strV.length()>0 && strVo.length()<=0 && strG.length()>0
                        && strT.length()>0){
                    g=Double.valueOf(strG);
                    t=Double.valueOf(strT);
                    vf=Double.valueOf(strV);
                    vo=vf+(g*t);
                    edtVo2.setText(""+vo);
                }
                else if (strV.length()>0 && strVo.length()>0 && strG.length()<=0
                        && strT.length()>0){
                    t=Double.valueOf(strT);
                    vo=Double.valueOf(strVo);
                    vf=Double.valueOf(strV);
                    g=(vo-vf)/t;
                    edtG2.setText(""+g);
                }
                else if (strV.length()>0 && strVo.length()>0 && strG.length()>0
                        && strT.length()<=0){
                    vf=Double.valueOf(strV);
                    vo=Double.valueOf(strVo);
                    g=Double.valueOf(strG);
                    t=(vo-vf)/g;
                    edtT2.setText(""+t);
                }
            }
        });

        btnForm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strA,strG;
                strA=edtA3.getText().toString();
                strG=edtG3.getText().toString();
                if (strA.length()<=0 && strG.length()>0) {
                    double a = -1*Double.valueOf(strG);
                    edtA3.setText(""+a);
                }
                else if (strA.length()>0 && strG.length()<=0) {
                    double g = -1*Double.valueOf(strA);
                    edtG3.setText(""+g);
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
