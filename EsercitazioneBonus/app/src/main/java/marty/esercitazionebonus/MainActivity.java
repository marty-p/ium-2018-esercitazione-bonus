package marty.esercitazionebonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputUsername = this.findViewById(R.id.inputUsername);
        final EditText inputPassword = this.findViewById(R.id.inputPassword);
        Button btnAccedi = this.findViewById(R.id.btnAccedi);
        btnAccedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputUsername.toString().isEmpty() || inputPassword.toString().isEmpty()) {
                    return;
                }
                Intent showResults = new Intent(MainActivity.this, FormResultActivity.class);
                startActivity(showResults);
            }
        });
    }
}
