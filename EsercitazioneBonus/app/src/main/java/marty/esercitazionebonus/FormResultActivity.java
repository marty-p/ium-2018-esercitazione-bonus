package marty.esercitazionebonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormResultActivity extends AppCompatActivity {
    Button btnIndietro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_result);

        // bottone che torna indietro alla activity principale
        btnIndietro = this.findViewById(R.id.btnIndietro);
        btnIndietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showResults = new Intent(FormResultActivity.this, MainActivity.class);
                startActivity(showResults);
            }
        });
    }
}
