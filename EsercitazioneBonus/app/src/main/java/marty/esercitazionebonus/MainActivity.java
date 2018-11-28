package marty.esercitazionebonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText inputUsername;
    EditText inputPassword;
    Button btnAccedi;
    // TextView textErrors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUsername = this.findViewById(R.id.inputUsername);
        inputPassword = this.findViewById(R.id.inputPassword);

        //textErrors = this.findViewById(R.id.textErrors);
        //textErrors.setVisibility(View.GONE); // must be displayed only when there are errors

        btnAccedi = this.findViewById(R.id.btnAccedi);
        btnAccedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInput()) {
                    Intent showResults = new Intent(MainActivity.this, FormResultActivity.class);
                    startActivity(showResults);
                }
            }
        });
    }

    //! @brief it returns true if there are no errors
    private boolean checkInput() {
        boolean hasErrors = false;
        if (inputUsername.getText().length()==0) {
            inputUsername.setError("Inserisci l'username");
            hasErrors = true;
        }
        if (inputPassword.getText().length()==0) {
            inputPassword.setError("Inserisci la password");
            hasErrors = true;
        }
        //if (hasErrors)
        //    textErrors.setVisibility(View.VISIBLE);

        return !hasErrors; // true if no errors
    }
}
