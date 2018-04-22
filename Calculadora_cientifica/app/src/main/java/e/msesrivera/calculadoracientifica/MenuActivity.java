package e.msesrivera.calculadoracientifica;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    ImageButton ibtnAce,ibtnVel,ibtnCai,ibtnVer,ibtnPar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ibtnAce=(ImageButton)findViewById(R.id.ibtnAcel);
        ibtnCai=(ImageButton)findViewById(R.id.ibtnCai);
        ibtnVel=(ImageButton)findViewById(R.id.ibtnVel);
        ibtnVer=(ImageButton)findViewById(R.id.ibtnVer);
        ibtnPar=(ImageButton)findViewById(R.id.ibtnPar);

        ibtnCai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(getApplicationContext(),CaidaLibreActivity.class);
                startActivity(it);
                overridePendingTransition(R.anim.right_in,R.anim.right_out);
            }
        });

        ibtnAce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(getApplicationContext(),AceleracionActivity.class);
                startActivity(it);
                overridePendingTransition(R.anim.right_in,R.anim.right_out);
            }
        });

        ibtnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(getApplicationContext(),TiroVerticalActivity.class);
                startActivity(it);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
            }
        });

        ibtnPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(getApplicationContext(),TiroParabolicoActivity.class);
                startActivity(it);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        ibtnVel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(getApplicationContext(),VelocidadActivity.class);
                startActivity(it);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
            }
        });
    }
}
