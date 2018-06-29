package com.lbompard.nouveautest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        View rootView = inflater.inflate(R.layout.activity_main, null);

        final ProgressBar loadbar = rootView.findViewById(R.id.progressBar);
        loadbar.setMax(100);
        loadbar.setProgress(0);

        final TextView resultView = rootView.findViewById(R.id.resultat);

        final EditText field = rootView.findViewById(R.id.TextNumber);


        Button validateButton = rootView.findViewById(R.id.BtnValider);

        View.OnClickListener myActionOnClickOfButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO gérer le clic
                final String fieldValue = field.getText().toString();
                if (fieldValue.isEmpty()) {
                    resultView.setText("Erreur veuillez remplir le champ");
                } else {
                    int fieldValueInt = Integer.valueOf(fieldValue);
                    if (fieldValueInt >= 1 && fieldValueInt <= 100) {
                        resultView.setText("Bravo tu as choisi un chiffre compris entre 1 et 100 !");
                        loadbar.setProgress(fieldValueInt, true);
                    } else {
                        resultView.setText("Erreur veuillez choisir un chiffre compris entre 1 et 100");
                        loadbar.setProgress(0, true);
                    }
                }

            }
        };

        validateButton.setOnClickListener(myActionOnClickOfButton);












        setContentView(rootView);
    }

}
