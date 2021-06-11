package com.example.aula290420;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText ra,  nome, curso;
    Button inserir;
    ListView  lvalunos;
    ArrayList<Aluno>alunos  =  new ArrayList<>();
    ArrayAdapter<Aluno> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ra =  findViewById(R.id.editTextRa);
        nome =  findViewById(R.id.editTextNome);
        curso =  findViewById(R.id.editTextCurso);
        inserir =  findViewById(R.id.buttonInserir);
        lvalunos = findViewById(R.id.listViewAlunos);

        //configura o adaptador para aparecer na list view
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alunos);

        lvalunos.setAdapter(adapter);

        inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alunos.add(
                        new Aluno(
                                ra.getText().toString(),
                                nome.getText().toString(),
                                curso.getText().toString()
                        )
                );
                adapter.notifyDataSetChanged();
                ra.setText("");
                nome.setText("");
                curso.setText("");
                ra.requestFocus();

                ((InputMethodManager) MainActivity.this.getSystemService(
                        Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                        getCurrentFocus().getWindowToken(), 0);
            }
        });
        lvalunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno aluno =  (Aluno) lvalunos.getItemAtPosition(position);
            }
        });

        lvalunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Aluno aluno =  (Aluno) lvalunos.getItemAtPosition(position);

                //criando arraylist pra passar pro intent
                ArrayList<Aluno> alunos = new ArrayList<>();
                alunos.add(aluno);
                Intent result = new Intent(MainActivity.this,Resultado.class);
                result.putExtra("objAluno",alunos);
                startActivity(result);

                return false;
            }
        });
    }
}
