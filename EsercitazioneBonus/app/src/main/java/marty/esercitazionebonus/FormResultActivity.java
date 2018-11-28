package marty.esercitazionebonus;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class FormResultActivity extends AppCompatActivity {
    TextView labelWelcome;
    Button btnIndietro;

    boolean checkCredentials(String username, String password) {
        // offline db
        final Map<String, String> credentials = new HashMap<String, String>() {
            {
                put("admin", "123456");
                put("user", "qwerty");
            }
        };

        // check user existence
        if (!credentials.containsKey(username))
            return false;

        // check password mismatch
        String c = credentials.get(username);
        if (!c.equals(password))
            return false;

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_result);

        // get data from intent
        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString(getString(R.string.key_username));
        String password = bundle.getString(getString(R.string.key_password));

        // process data
        labelWelcome = this.findViewById(R.id.labelWelcome);
        if (checkCredentials(username, password)) {
            // login success
            labelWelcome.setText(String.format(getString(R.string.welcome_fmt), username));
        } else {
            // login failed
            labelWelcome.setText(getString(R.string.access_denied));
            labelWelcome.setTextColor(Color.RED);
        }

        // button that goes back to the main activity
        btnIndietro = this.findViewById(R.id.btnIndietro);
        btnIndietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
