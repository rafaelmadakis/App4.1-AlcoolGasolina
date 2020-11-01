package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view) {

        // recuperar os  valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validar os campos
        Boolean campoValidados = this.validarCampos(precoAlcool, precoGasolina);

        if (campoValidados) {
            this.calcularMelhorPreco(precoAlcool, precoGasolina);
        }else{
            textResultado.setText("Preencha os preços primeiro");
        }

    }

    public void calcularMelhorPreco(String pAlcool, String pGasolina){

        //Converter valores de String para numeros
        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);

        /*
        Faz cáculo (precoAlcool / precoGasolina)
        * Se resultado >= 0.7 melhor utilizar gasolina
        * senão melhor utilizar Álcool
         */

        Double resultado = precoAlcool / precoGasolina;

        if (resultado >= 0.7) {
            textResultado.setText("Melhor utulizar Gasolina!");
        }else{
            textResultado.setText("Melhor utilizar Álcool!");
        }

    }


    public Boolean validarCampos(String pAlcool, String pGasolina) {

        Boolean camposValidados = true;

        //validar campos

        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }

        return camposValidados;
    }



}