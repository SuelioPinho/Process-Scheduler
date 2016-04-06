package com.example.sueliopss.escalonador;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_tela_inicial)
public class TelaInicial extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private String algoritimo;
    List <String> categorias = new ArrayList<>();
    EditText quantum;
    Button iniciar;
    Spinner spinner;
    EditText processos;
    EditText processadores;
    int numProcessos;
    int numQtdProcessadores;
    int numQuantum = 0;

    @AfterViews
    public void afterViews(){
        iniciarComponentes();
        iniciar.setOnClickListener(this);
        popularSpinner();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        final String item = parent.getItemAtPosition(position).toString();
        quantum.setEnabled(parent.getItemAtPosition(position).toString().equals(getString(R.string.round)));
        algoritimo = item;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onClick(View v) {
        salvarDados();

        switch (algoritimo){
            case "Selecionar...":
                showToast(getResources().getString(R.string.SelecionarAlgoritimo));
                break;
            case "Round Robin":
                iniciarRoundRobin();
                break;
            case "Scheduling":
             iniciarScheduling();
                break;
            case "Least Time to Go":
              iniciarLTG();
                break;
        }
    }

    public void showToast(String mensagem) {
        Toast.makeText(getBaseContext(),mensagem,
                Toast.LENGTH_LONG).show();
    }

    public boolean isProcessoVazio(){
        return processos.getText().toString().equals("");
    }

    public boolean isProcessadorVazio(){
        return processadores.getText().toString().equals("");
    }

    public boolean isQuantumVazio(){
       return quantum.getText().toString().equals("");
    }

    public boolean verificadorDeDados(){
        return !(isProcessadorVazio() && isProcessoVazio());
    }

    public boolean verificadorDeDadosRR(){
        return !(isProcessadorVazio() && isProcessoVazio() && isQuantumVazio());
    }

    public void iniciarRoundRobin() {
        if (verificadorDeDadosRR()) {
            irParaRoundRActivity();
        } else {
            showToast(getResources().getString(R.string.camposvazios));
        }
    }

    public void iniciarLTG(){
        if (verificadorDeDados()){
            irParaLTG();
        }else{
            showToast(getResources().getString(R.string.camposvazios));
        }
    }
    public void iniciarScheduling(){
        if (verificadorDeDados()){
           irParaScheduling();
        }else{
            showToast(getResources().getString(R.string.camposvazios));
        }
    }

    public void popularSpinner(){
        spinner.setOnItemSelectedListener(this);
        addCategorias();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categorias);
        spinner.setAdapter(dataAdapter);
    }

    public void addCategorias(){
        categorias.add(getString(R.string.selecionar));
        categorias.add(getString(R.string.ltg));
        categorias.add(getString(R.string.round));
        categorias.add(getString(R.string.scheduling));
    }

    public void iniciarComponentes(){
        editText();
        componetesAleatorios();
    }

    public void componetesAleatorios(){
        spinner = (Spinner) findViewById(R.id.spinner);
        iniciar = (Button) findViewById(R.id.buttonIniciar);
    }

    public void editText(){
        quantum = (EditText) findViewById(R.id.quantum);
        processos = (EditText) findViewById(R.id.editTextProcessos);
        processadores = (EditText) findViewById(R.id.editTextProcessadores);
    }

    public void salvarDados(){
        salvarProcessos();
        salvarProcessador();
        salvarQuantum();
    }

    public void salvarProcessos(){
        numProcessos = isProcessoVazio() ? 0 : Integer.parseInt(processos.getText().toString());
    }

    public void salvarProcessador(){
        numQtdProcessadores = isProcessadorVazio() ? 0 : Integer.parseInt(processadores.getText().toString());
    }

    public void salvarQuantum(){
       numQuantum = isQuantumVazio() ? 0 : Integer.parseInt(quantum.getText().toString());
    }

    public void irParaRoundRActivity(){
        RoundRActivity_.intent(this).numProcessos(numProcessos).numQtdProcessadores(numQtdProcessadores).numQuantum(numQuantum).start();
    }

    private void irParaLTG() {
        MainActivity_.intent(this).numProcessos(numProcessos).numQtdProcessadores(numQtdProcessadores).start();
    }

    private void irParaScheduling() {
    }

}
