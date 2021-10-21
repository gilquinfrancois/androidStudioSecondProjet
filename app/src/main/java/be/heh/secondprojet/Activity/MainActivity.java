package be.heh.secondprojet.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import be.heh.secondprojet.Activity.ChildrenActivity;
import be.heh.secondprojet.R;

public class MainActivity extends Activity {

    private static final int CODE_ACTIVITE = 1; //Valeur arbitraire
    SharedPreferences prefs_datas;

    private static final int NOTIFY_ID = 1234;
    NotificationManager noma = null;
    int cpt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        noma = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
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

                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                //Afficher message système
                /*Toast.makeText(getApplicationContext(),
                        "clic sur le btn enfant",
                        Toast.LENGTH_LONG)
                        .show();*/
                builder.setTitle("Alerte activité")
                        .setMessage("Voulez-vous afficher l'activité Children ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                notifier();
                                /*
                                Intent monIntent = new Intent(getApplicationContext(), ChildrenActivity.class);
                                startActivityForResult(monIntent,CODE_ACTIVITE);
                                 */
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .create().show();
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

    private void notifier() {
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, ChildrenActivity.class ),0);
        BatteryManager bm = (BatteryManager) getSystemService(BATTERY_SERVICE);
        int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);

        Notification.Builder notification = new Notification.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("Notification !!")
                .setContentText("L'activité Children est disponible ! \n ID: ")
                .setNumber(++cpt)
                .setContentIntent(pi)
                .setDefaults(Notification.DEFAULT_ALL)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setWhen(System.currentTimeMillis());

        Notification notif = notification.build();
        noma.notify(NOTIFY_ID,notif);
    }

    public void arretNotifier() {
        noma.cancel(NOTIFY_ID);
    }
}