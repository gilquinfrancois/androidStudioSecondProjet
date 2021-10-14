package be.heh.secondprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final int CODE_ACTIVITE = 1; //Valeur arbitraire

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMainClickManager(View v){
        switch (v.getId()){
            case R.id.bt_homeactivity_hw:
                //Afficher message système
                /*Toast.makeText(getApplicationContext(),
                        "clic sur le btn enfant",
                        Toast.LENGTH_LONG)
                        .show();*/
                Intent monIntent = new Intent(this, ChildrenActivity.class);
                startActivityForResult(monIntent,CODE_ACTIVITE);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case CODE_ACTIVITE:
                switch (resultCode) {
                    case RESULT_OK:
                        Toast.makeText(this,"Action validée depuis l'activité Children",Toast.LENGTH_LONG).show();

                        return;
                    case RESULT_CANCELED:
                        Toast.makeText(this,"Action annulée depuis l'activité Children",Toast.LENGTH_LONG).show();
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }
}