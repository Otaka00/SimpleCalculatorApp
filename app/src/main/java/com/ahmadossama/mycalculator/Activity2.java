package com.ahmadossama.mycalculator;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView txt;
    final EditText name = (EditText) findViewById(R.id.Name);
    final EditText email = (EditText) findViewById(R.id.EmailAddress);
    final TextView name2 = findViewById(R.id.outname);
    final TextView email2 = findViewById(R.id.outemail);
    public final String Prefs_name = "PreferencesFile";
    Button btn = (Button) findViewById(R.id.empty);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        txt = findViewById(R.id.textView2);
        String txt2 = getResources().getString(R.string.app_name);
        txt.setText(txt2);
        Log.d("lifecycle", "----On Create----");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getSharedPreferences(Prefs_name, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("name", name.getText().toString());
                editor.putString("email", email.getText().toString());
                editor.commit();
                name2.setText(settings.getString("name", "Name not found"));
                email2.setText(settings.getString("email", "Email not found"));
            }
        });
    }
}
