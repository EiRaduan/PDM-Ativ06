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
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private View construtor;
    private EditText edt_lado;
    private Button btn_calcular;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

        construtor = inflater.inflate(R.layout.fragment_home, container, false);
        edt_lado = construtor.findViewById(R.id.edt_quadrado_lado);
        btn_calcular = construtor.findViewById(R.id.btn_quadrado_calcular);


        //return inflater.inflate(R.layout.fragment_home, container, false);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double area = 0;
                double lado = 0;

                lado = Double.parseDouble(edt_lado.getText().toString());
                area = (lado*lado);

                if(lado == 0){
                    AlertDialog.Builder janela = new AlertDialog.Builder(getActivity());
                    janela.setTitle(R.string.app_name);
                    janela.setMessage("Preencha todos os campos!!!");
                    janela.setPositiveButton("OK", null);
                    janela.show();
                } else {


                    AlertDialog.Builder janela = new AlertDialog.Builder(getActivity());
                    janela.setTitle(R.string.app_name);
                    janela.setMessage("Area do quadrado ?? " + area);
                    janela.setPositiveButton("OK", null);
                    janela.show();
                }
            }
        });
        return construtor;
    }
}