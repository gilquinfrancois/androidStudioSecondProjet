package be.heh.secondprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final int CODE_ACTIVITE = 1; //Valeur arbitraire
    SharedPreferences prefs_datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Récupération du login, pwd et email
        prefs_datas = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //N'affiche pas de message lors du premier lancement de l'application
        if(!prefs_datas.getAll().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Votre login est : " + (prefs_datas.getString("login","NULL")) + "\n" + "Votre password est : " + (prefs_datas.getString("pwd","NULL")) + "\n" + "Votre email est : " + (prefs_datas.getString("email","NULL")), Toast.LENGTH_SHORT).show();
        }
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