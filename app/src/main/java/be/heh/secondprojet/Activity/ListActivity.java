package be.heh.secondprojet.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import be.heh.secondprojet.R;

public class ListActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list);

        getFragmentManager().beginTransaction().replace(android.R.id.content,
            new NotreFragment()).commit();
    }

    public static class NotreFragment extends PreferenceFragment{

        @Override
        public void onCreate(final Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref);
        }
    }
}