package marty.esercitazionebonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputUsername;
    EditText inputPassword;
    Button btnAccedi;
    TextView labelErrors;
    TextView labelLostPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUsername = this.findViewById(R.id.inputUsername);
        inputPassword = this.findViewById(R.id.inputPassword);

        labelErrors = this.findViewById(R.id.labelErrors);
        labelErrors.setVisibility(View.GONE); // must be displayed only when there are errors

        // linkable textview with "a href"
        labelLostPassword = this.findViewById(R.id.labelLostPassword);
        labelLostPassword.setMovementMethod(LinkMovementMethod.getInstance());
        labelLostPassword.setText(Html.fromHtml(labelLostPassword.getText().toString()));

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
        // check username
        if (inputUsername.getText().length()==0) {
            inputUsername.setError("Inserisci l'username");
            hasErrors = true;
        }
        // check password
        if (inputPassword.getText().length()==0) {
            inputPassword.setError("Inserisci la password");
            hasErrors = true;
        }

        if (hasErrors) // mostra il label se ha errori
            labelErrors.setVisibility(View.VISIBLE);
        else // nascondi altrimenti
            labelErrors.setVisibility(View.GONE);

        return !hasErrors; // true if no errors
    }
}
