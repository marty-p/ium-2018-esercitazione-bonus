package marty.esercitazionebonus;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {
    private TextView labelWelcome;
    private Button btnIndietro;

    private boolean checkCredentials(String username, String password) {
        // offline db
        final Map<String, String> credentials = new HashMap<String, String>() {
            {
                put("admin", "123456");
                put("user", "qwerty");
            }
        };

        // check password mismatch
        String c = credentials.get(username);
        return c != null && c.equals(password);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_result);

        // get data from intent
        Intent intent = getIntent();
        String username = intent.getStringExtra(getString(R.string.key_username));
        String password = intent.getStringExtra(getString(R.string.key_password));

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
        btnIndietro.setOnClickListener(v -> finish());
    }
}
