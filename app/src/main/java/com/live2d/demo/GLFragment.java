package com.live2d.demo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import java.util.List;

public class GLFragment extends Fragment {

    private CoordinatorLayout constraintLayout;
    private Button showButton;
    private Button floatingButton;
    private Button loadButton;

    private EditText x;
    private EditText y;
    private EditText s;
    private EditText etPath;
    private EditText etName;

    private int mos;
    private int exs;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        constraintLayout = root.findViewById(R.id.gl_root);
        showButton = root.findViewById(R.id.show_button);
        floatingButton = root.findViewById(R.id.button_floating);
        loadButton = root.findViewById(R.id.button_load);


        x = root.findViewById(R.id.x);
        y = root.findViewById(R.id.y);
        s = root.findViewById(R.id.scale);
        etPath = root.findViewById(R.id.et_path);
        etName = root.findViewById(R.id.et_name);

        x.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String data = x.getText().toString();
                if (data.isEmpty())
                    return;
                float f = Float.parseFloat(data);
                JniBridgeJava.nativeSetPosX(f);
            }
        });

        y.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String data = y.getText().toString();
                if (data.isEmpty())
                    return;
                float f = Float.parseFloat(data);
                JniBridgeJava.nativeSetPosY(f);
            }
        });

        s.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable a) {
                String data = s.getText().toString();
                if (data.isEmpty())
                    return;
                float f = Float.parseFloat(data);
                JniBridgeJava.nativeSetScale(f);
            }
        });


        showButton.setOnClickListener(v -> {
            JniBridgeJava.ChangeModel();
            MainActivity.glView.callAdd(constraintLayout);
        });

        floatingButton.setOnClickListener(v -> {
            try {
                List<String> list = JniBridgeJava.getMotions();
                mos++;
                if (mos == list.size())
                    mos = 0;

                String item = list.get(mos);
                String[] temp = item.split("_");

                JniBridgeJava.StartMotion(temp[0], Integer.parseInt(temp[1]), 3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        loadButton.setOnClickListener(v -> {
            try {
                List<String> list = JniBridgeJava.getExpressions();

                if (list.size() == 0)
                    return;
                exs++;
                if (exs == list.size())
                    exs = 0;

                String item = list.get(exs);

                JniBridgeJava.StartExpressions(item);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        floatingButton.setOnClickListener(v -> {
            try {
                if (MainActivity.glView.getParent() != null) {
                    constraintLayout.removeView(MainActivity.glView);
                }
                MainActivity.app.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        loadButton.setOnClickListener(v -> {
            try {
//                JniBridgeJava.LoadModel("sizuku", "shizuku");
                JniBridgeJava.LoadModel(etPath.getText().toString(), etName.getText().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return root;
    }
}