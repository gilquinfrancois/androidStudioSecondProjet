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
                if(et_children_login.getText().toString().isEmpty() || et_children_pwd.getText().toString().isEmpty() || et_children_email.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Complétez tous les champs !", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intxt = new Intent(this, MainActivity.class);
                    intxt.putExtra("login",et_children_login.getText().toString());
                    intxt.putExtra("pwd",et_children_pwd.getText().toString());
                    intxt.putExtra("email",et_children_email.getText().toString());
                    startActivity(intxt);
                    finish();
                }
                break;
            case R.id.bt_children_li:
                Intent versListe = new Intent(this, ListActivity.class);
                startActivity(versListe);
                finish();
                break;
        }
    }
}