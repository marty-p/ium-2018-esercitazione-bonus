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
    TextView labelRegistrati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUsername = this.findViewById(R.id.inputUsername);
        inputPassword = this.findViewById(R.id.inputPassword);

        labelErrors = this.findViewById(R.id.labelErrors);
        labelErrors.setVisibility(View.GONE); // must be displayed only when there are errors

        // linkable textview with "a href"
        labelRegistrati = this.findViewById(R.id.labelRegistrati);
        labelRegistrati.setMovementMethod(LinkMovementMethod.getInstance());
        labelRegistrati.setText(Html.fromHtml(labelRegistrati.getText().toString()));

        btnAccedi = this.findViewById(R.id.btnAccedi);
        btnAccedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInput()) {
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    // add data inside intent
                    intent.putExtra(getString(R.string.key_username), inputUsername.getText().toString());
                    intent.putExtra(getString(R.string.key_password), inputPassword.getText().toString());
                    // run login activity
                    startActivity(intent);
                }
            }
        });
    }

    //! @brief it returns true if there are no errors
    private boolean checkInput() {
        boolean hasErrors = false;
        // check username
        if (inputUsername.getText().length()==0) {
            inputUsername.setError(getString(R.string.insert_username));
            hasErrors = true;
        }
        // check password
        if (inputPassword.getText().length()==0) {
            inputPassword.setError(getString(R.string.insert_password));
            hasErrors = true;
        }

        if (hasErrors) // show the error label if it has errors
            labelErrors.setVisibility(View.VISIBLE);
        else // hide it otherwise
            labelErrors.setVisibility(View.GONE);

        return !hasErrors; // true if no errors
    }
}
