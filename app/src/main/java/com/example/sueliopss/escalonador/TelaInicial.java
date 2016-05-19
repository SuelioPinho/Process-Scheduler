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
    List <String> categoriasMemoria = new ArrayList<>();
    EditText quantum;
    Button iniciar;
    Spinner spinner;
    Spinner spinnerMemoria;
    EditText processos;
    EditText processadores;
    EditText tamanhoMemoria;

    int numProcessos;
    int numQtdProcessadores;
    int numQuantum = 0;
    int algortimoId;
    int memoria;

    @AfterViews
    public void afterViews(){
        iniciarComponentes();
        iniciar.setOnClickListener(this);
        popularSpinner();
        popularSpinnerMemoria();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = null;


        switch (parent.getId()){

            case R.id.spinner:
                item = parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinnerMemoria1:
                algortimoId = parent.getSelectedItemPosition();
                break;
        }
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
            case "Interval Base":
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

    public boolean isQuantumZero(){
        return quantum.getText().toString().equals("0");
    }


    public boolean verificadorDeDados(){
        return !(isProcessadorVazio() && isProcessoVazio());
    }

    public boolean verificadorDeDadosRR(){
        return !(isProcessadorVazio() && isProcessoVazio() && isQuantumVazio() && isQuantumZero());
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

    public void popularSpinnerMemoria(){
        spinnerMemoria.setOnItemSelectedListener(this);
        addCategoriasMemoria();
        ArrayAdapter<String> dataAdapterMemoria = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoriasMemoria);
        spinnerMemoria
                .setAdapter(dataAdapterMemoria);
    }

    public void addCategorias(){
        categorias.add(getString(R.string.selecionar));
        categorias.add(getString(R.string.ltg));
        categorias.add(getString(R.string.round));
        categorias.add(getString(R.string.scheduling));

    }

    public void addCategoriasMemoria(){
        categoriasMemoria.add(getString(R.string.selecionar));
        categoriasMemoria.add(getString(R.string.bestfit));
        categoriasMemoria.add(getString(R.string.mergefit));
        categoriasMemoria.add(getString(R.string.quickfit));

    }

    public void iniciarComponentes(){
        editText();
        componetesAleatorios();
    }

    public void componetesAleatorios(){
        spinner = (Spinner) findViewById(R.id.spinner);
        spinnerMemoria = (Spinner) findViewById(R.id.spinnerMemoria1);
        iniciar = (Button) findViewById(R.id.buttonIniciar);
    }

    public void editText(){
        quantum = (EditText) findViewById(R.id.quantum);
        processos = (EditText) findViewById(R.id.editTextProcessos);
        processadores = (EditText) findViewById(R.id.editTextProcessadores);
        tamanhoMemoria = (EditText) findViewById(R.id.EditTextTamanhoMemoria);

    }

    public void salvarDados(){
        salvarProcessos();
        salvarProcessador();
        salvarQuantum();
        salvarMemoria();
    }

    public void salvarMemoria(){
        memoria = isProcessoVazio() ? 0 : Integer.parseInt(tamanhoMemoria.getText().toString());
    }

    public void salvarProcessos(){
        numProcessos = isProcessoVazio() ? 0 : Integer.parseInt(processos.getText().toString());
    }

    public void salvarProcessador(){
        numQtdProcessadores = isProcessadorVazio() ? 0 : Integer.parseInt(processadores.getText().toString());
    }

    public void salvarQuantum(){
       numQuantum = isQuantumVazio() ? 1 : Integer.parseInt(quantum.getText().toString());
    }

    public void irParaRoundRActivity(){
        RoundRActivity_.intent(this).numProcessos(numProcessos).numQtdProcessadores(numQtdProcessadores).numQuantum(numQuantum).start();
    }

    private void irParaLTG() {
        LTGActivity_.intent(this).numProcessos(numProcessos).numQtdProcessadores(numQtdProcessadores).algoritmo(algortimoId).qtdMemoria(memoria).start();
    }

    private void irParaScheduling() {
        IntervalBaseActivity_.intent(this).numProcessos(numProcessos).numQtdProcessadores(numQtdProcessadores).start();
    }

}
