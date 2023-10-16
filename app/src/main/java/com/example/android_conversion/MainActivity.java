package com.example.android_conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.android_conversion.models.Celcius;
import com.example.android_conversion.models.Farenheit;
import com.example.android_conversion.models.Kelvin;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Celcius c;
    Farenheit f;
    Kelvin k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Spinner primerS = findViewById(R.id.spinner);
        Spinner SegundoS = findViewById(R.id.spinner2);

        List<String> items = new ArrayList<>();
        items.add("Selecciona:");
        items.add("Celcius");
        items.add("Kelvin");
        items.add("Farenheit");



// Crear un ArrayAdapter y asociarlo al Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        List<String> items2 = new ArrayList<>();
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        primerS.setAdapter(adapter);
        SegundoS.setAdapter(adapter2);

        // Agregar un OnItemSelectedListener para manejar las selecciones del usuario
        primerS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String va = (String) parent.getItemAtPosition(position);
                switch(va) {
                    case "Selecciona:":

                        items2.clear();
                        items2.add("Selecciona:");
                        items2.add("Celcius");
                        items2.add("Farenheit");
                        items2.add("Kelvin");
                        adapter2.notifyDataSetChanged();

                        break;
                    case "Farenheit":
                        items2.clear();
                        items2.add("Selecciona:");
                        items2.add("Celcius");
                        items2.add("Kelvin");
                        adapter2.notifyDataSetChanged();

                        String dos = SegundoS.getSelectedItem().toString();

                        if(dos!="Selecciona:"){
                            TextView res2=findViewById(R.id.res2);
                            EditText res1=findViewById(R.id.res1);
                            String res1String = res1.getText().toString();
                            Double ress1=Double.parseDouble(res1String);

                            String txtS1 = primerS.getSelectedItem().toString();

                            switch (dos){
                                case "Kelvin":
                                    f = new Farenheit(ress1);
                                    Kelvin resultadoFK = new Kelvin(0.0);
                                    resultadoFK=resultadoFK.parse(f);
                                    res2.setText(String.valueOf(resultadoFK.getValor()));
                                    break;
                                case "Celcius":
                                    f = new Farenheit(ress1);
                                    Celcius resultadoFC = new Celcius(0.0);
                                    resultadoFC=resultadoFC.parse(f);
                                    res2.setText(String.valueOf(resultadoFC.getValor()));
                                    break;
                            }
                        }
                        break;
                    case"Celcius":
                        items2.clear();
                        items2.add("Selecciona:");
                        items2.add("Farenheit");
                        items2.add("Kelvin");
                        adapter2.notifyDataSetChanged();

                        String dosC = SegundoS.getSelectedItem().toString();

                        if(dosC!="Selecciona:"){

                            TextView res2=findViewById(R.id.res2);
                            EditText res1=findViewById(R.id.res1);
                            String res1String = res1.getText().toString();
                            Double ress1=Double.parseDouble(res1String);
                            String txtS1 = primerS.getSelectedItem().toString();

                            switch (dosC){
                                case "Kelvin":
                                    c = new Celcius(ress1);
                                    Kelvin resultadoCK = new Kelvin(0.0);
                                    resultadoCK=resultadoCK.parse(c);
                                    res2.setText(String.valueOf(resultadoCK.getValor()));
                                    break;
                                case "Farenheit":
                                    c = new Celcius(ress1);
                                    Farenheit resultadoCF = new Farenheit(0.0);
                                    resultadoCF=resultadoCF.parse(c);
                                    res2.setText(String.valueOf(resultadoCF.getValor()));
                                    break;
                            }
                        }

                        break;
                    case"Kelvin":
                        items2.clear();
                        items2.add("Selecciona:");
                        items2.add("Celcius");
                        items2.add("Farenheit");
                        adapter2.notifyDataSetChanged();

                        String dosK = SegundoS.getSelectedItem().toString();

                        if(dosK!="Selecciona:"){

                            TextView res2=findViewById(R.id.res2);
                            EditText res1=findViewById(R.id.res1);
                            String res1String = res1.getText().toString();
                            Double ress1=Double.parseDouble(res1String);
                            String txtS1 = primerS.getSelectedItem().toString();

                            switch (dosK){
                                case "Farenheit":
                                    k = new Kelvin(ress1);
                                    Farenheit resultadoKF = new Farenheit(0.0);
                                    resultadoKF=resultadoKF.parse(k);
                                    res2.setText(String.valueOf(resultadoKF.getValor()));
                                    break;
                                case "Celcius":
                                    k = new Kelvin(ress1);
                                    Celcius resultadoKC = new Celcius(0.0);
                                    resultadoKC=resultadoKC.parse(k);
                                    res2.setText(String.valueOf(resultadoKC.getValor()));
                                    break;
                            }
                        }
                        break;
                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Este método se llama cuando no se selecciona ningún elemento.
            }
        });

        SegundoS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                EditText res1=findViewById(R.id.res1);
                String res1String = res1.getText().toString();
                Double ress1=Double.parseDouble(res1String);

                String txtS1 = primerS.getSelectedItem().toString();

                String dos = (String) parent.getItemAtPosition(position);
                TextView res2=findViewById(R.id.res2);

                switch( txtS1){
                    case "Farenheit":


                        switch (dos){
                            case "Kelvin":
                                f = new Farenheit(ress1);
                                Kelvin resultadoFK = new Kelvin(0.0);
                                resultadoFK=resultadoFK.parse(f);
                                res2.setText(String.valueOf(resultadoFK.getValor()));
                                break;
                            case "Celcius":
                                f = new Farenheit(ress1);
                                Celcius resultadoFC = new Celcius(0.0);
                                resultadoFC=resultadoFC.parse(f);
                                res2.setText(String.valueOf(resultadoFC.getValor()));
                                break;
                        }
                        break;
                    case "Kelvin":
                        switch (dos){
                            case "Farenheit":
                                k = new Kelvin(ress1);
                                Farenheit resultadoKF = new Farenheit(0.0);
                                resultadoKF=resultadoKF.parse(k);
                                res2.setText(String.valueOf(resultadoKF.getValor()));
                                break;
                            case "Celcius":
                                k = new Kelvin(ress1);
                                Celcius resultadoKC = new Celcius(0.0);
                                resultadoKC=resultadoKC.parse(k);
                                res2.setText(String.valueOf(resultadoKC.getValor()));
                                break;
                        }
                        break;
                    case "Celcius":
                        switch (dos){
                            case "Kelvin":
                                c = new Celcius(ress1);
                                Kelvin resultadoCK = new Kelvin(0.0);
                                resultadoCK=resultadoCK.parse(c);
                                res2.setText(String.valueOf(resultadoCK.getValor()));
                                break;
                            case "Farenheit":
                                c = new Celcius(ress1);
                                Farenheit resultadoCF = new Farenheit(0.0);
                                resultadoCF=resultadoCF.parse(c);
                                res2.setText(String.valueOf(resultadoCF.getValor()));
                                break;
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Este método se llama cuando no se selecciona ningún elemento.
            }
        });
        EditText res1=findViewById(R.id.res1);
        String res1String = res1.getText().toString();
        Double ress1=Double.parseDouble(res1String);
        res1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // Este método se llama antes de que el texto cambie.
                // Puedes realizar acciones previas al cambio, si es necesario.
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {


                EditText res1=findViewById(R.id.res1);
                String res1String = res1.getText().toString();
                Double ress1=Double.parseDouble(res1String);

                String txtS1 = primerS.getSelectedItem().toString();

                String dos = SegundoS.getSelectedItem().toString();
                TextView res2=findViewById(R.id.res2);
                switch( txtS1){
                    case "Farenheit":


                        switch (dos){
                            case "Kelvin":
                                f = new Farenheit(ress1);
                                Kelvin resultadoFK = new Kelvin(0.0);
                                resultadoFK=resultadoFK.parse(f);
                                res2.setText(String.valueOf(resultadoFK.getValor()));
                                break;
                            case "Celcius":
                                f = new Farenheit(ress1);
                                Celcius resultadoFC = new Celcius(0.0);
                                resultadoFC=resultadoFC.parse(f);
                                res2.setText(String.valueOf(resultadoFC.getValor()));
                                break;
                        }
                        break;
                    case "Kelvin":
                        switch (dos){
                            case "Farenheit":
                                k = new Kelvin(ress1);
                                Farenheit resultadoKF = new Farenheit(0.0);
                                resultadoKF=resultadoKF.parse(k);
                                res2.setText(String.valueOf(resultadoKF.getValor()));
                                break;
                            case "Celcius":
                                 k = new Kelvin(ress1);
                                Celcius resultadoKC = new Celcius(0.0);
                                resultadoKC=resultadoKC.parse(k);
                                res2.setText(String.valueOf(resultadoKC.getValor()));
                                break;
                        }
                        break;
                    case "Celcius":
                        switch (dos){
                            case "Kelvin":
                                c = new Celcius(ress1);
                                Kelvin resultadoCK = new Kelvin(0.0);
                                resultadoCK=resultadoCK.parse(c);
                                res2.setText(String.valueOf(resultadoCK.getValor()));
                                break;
                            case "Farenheit":
                                c = new Celcius(ress1);
                                Farenheit resultadoCF = new Farenheit(0.0);
                                resultadoCF=resultadoCF.parse(c);
                                res2.setText(String.valueOf(resultadoCF.getValor()));
                                break;
                        }
                        break;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Este método se llama después de que el texto cambie.
                // Puedes realizar acciones posteriores al cambio, si es necesario.
            }
        });
    }


}