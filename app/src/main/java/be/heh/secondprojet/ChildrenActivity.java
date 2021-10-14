package be.heh.secondprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChildrenActivity extends Activity {

    EditText et_children_email ;
    EditText et_children_login ;
    EditText et_children_pwd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);

        et_children_login = (EditText)findViewById(R.id.et_children_login);
        et_children_pwd = (EditText)findViewById(R.id.et_children_pwd);
        et_children_email = (EditText)findViewById(R.id.et_children_email);

    }
    public void onChildrenClickManager(View v){
        switch (v.getId()){
            case R.id.bt_children_hb:
                //Affichage message système
                /*
                Toast.makeText(getApplicationContext()
                        ," Login : " + et_children_login.getText() + "\n Password: " + et_children_pwd.getText() + "\n Email : "
                    + et_children_email.getText()
                    , Toast.LENGTH_SHORT)
                    .show();*/
                //Intent versMain = new Intent(this, MainActivity.class);
                //startActivity(versMain);
                setResult(RESULT_OK);
                finish();
                break;
            case R.id.bt_children_li:
                Intent versListe = new Intent(this, ListActivity.class);
                startActivity(versListe);
                finish();
                break;
        }
    }
}