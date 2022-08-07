package com.unir.abas.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.unir.abas.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InscricoesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InscricoesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private View construtor;
    private EditText edt_lado, edt_maior, edt_menor;
    private Button btn_calcular;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InscricoesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InscricoesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InscricoesFragment newInstance(String param1, String param2) {
        InscricoesFragment fragment = new InscricoesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        //return inflater.inflate(R.layout.fragment_inscricoes, container, false);

        construtor = inflater.inflate(R.layout.fragment_inscricoes, container, false);
        edt_maior = construtor.findViewById(R.id.edt_losango_maior);
        edt_menor = construtor.findViewById(R.id.edt_losango_menor);

        btn_calcular = construtor.findViewById(R.id.btn_losango_calcular);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double area = 0;
                double ladoMaior = 0;
                double ladoMenor = 0;
                ladoMaior = Double.parseDouble(edt_maior.getText().toString());
                ladoMenor = Double.parseDouble(edt_menor.getText().toString());
                area = (ladoMaior*ladoMenor)/2;

                if(ladoMaior == 0 || ladoMenor == 0){
                    AlertDialog.Builder janela = new AlertDialog.Builder(getActivity());
                    janela.setTitle(R.string.app_name);
                    janela.setMessage("Preencha todos os campos!!!");
                    janela.setPositiveButton("OK", null);
                    janela.show();
                } else {
                    AlertDialog.Builder janela = new AlertDialog.Builder(getActivity());
                    janela.setTitle(R.string.app_name);
                    janela.setMessage("Area do losango é " + area);
                    janela.setPositiveButton("OK", null);
                    janela.show();
                }
            }
        });
        return construtor;
    }
}