package com.example.aula290420;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TerceiraTela extends AppCompatActivity {
    TextView aRa, aNome, aCurso, vRa, vNome, vCurso;
    ArrayList<Aluno> objAlunoN;
    ArrayList<Aluno> objAlunoV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        aRa = findViewById(R.id.aRA);
        aNome = findViewById(R.id.aNome);
        aCurso = findViewById(R.id.aCurso);
        vRa = findViewById(R.id.vRa);
        vNome = findViewById(R.id.vNome);
        vCurso = findViewById(R.id.vCurso);

        objAlunoN = (ArrayList<Aluno>)getIntent().getSerializableExtra("Aluno");
        objAlunoV = (ArrayList<Aluno>)getIntent().getSerializableExtra("Aluno2");

        aRa.setText(objAlunoN.get(0).getRa());
        aNome.setText(objAlunoN.get(0).getNome());
        aCurso.setText(objAlunoN.get(0).getCurso());

        vRa.setText(objAlunoV.get(0).getRa());
        vNome.setText(objAlunoV.get(0).getNome());
        vCurso.setText(objAlunoV.get(0).getCurso());


    }
}