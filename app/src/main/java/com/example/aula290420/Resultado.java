package com.example.aula290420;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Resultado extends AppCompatActivity {
    EditText ra, nome, curso;
    Button prox;
    ArrayList<Aluno> objAluno;
    ArrayList<Aluno> alunosnovo = new ArrayList<>();
    ArrayList<Aluno> alunosvelho = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        ra =  findViewById(R.id.editTextRa);
        nome =  findViewById(R.id.editTextNome);
        curso =  findViewById(R.id.editTextCurso);
        prox =  findViewById(R.id.buttonProx);

        objAluno = (ArrayList<Aluno>)getIntent().getSerializableExtra("objAluno");

        ra.setText(objAluno.get(0).getRa());
        nome.setText(objAluno.get(0).getNome());
        curso.setText(objAluno.get(0).getCurso());

        prox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent terceiraTela = new Intent(getApplicationContext(), TerceiraTela.class);

                alunosvelho.add(
                        new Aluno(
                                objAluno.get(0).getRa(),
                                objAluno.get(0).getNome(),
                                objAluno.get(0).getCurso()
                        )
                );

                alunosnovo.add(
                        new Aluno(
                                ra.getText().toString(),
                                nome.getText().toString(),
                                curso.getText().toString()
                        )
                );
                terceiraTela.putExtra("Aluno",alunosnovo);
                terceiraTela.putExtra("Aluno2",alunosvelho);

                startActivity(terceiraTela);
            }
        });
    }
}
