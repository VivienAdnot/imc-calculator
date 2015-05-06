package com.vivien_adnot.imccalculator;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.vivien_adnot.imccalculator.IMC.IMC;
import com.vivien_adnot.imccalculator.IMC.SizeConverter.Unit;


public class MainActivity extends Activity {
    private IMC imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.imc = new IMC();
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.btnCompute);
        final TextView resultView = (TextView) findViewById(R.id.result);
        final RadioGroup unitGroup = (RadioGroup) findViewById(R.id.unit);

        unitGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.meter:
                        imc.setUnit(Unit.METER);
                        break;
                    case R.id.centimeter:
                        imc.setUnit(Unit.CENTIMETER);
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weight = GetWeight();
                double size = GetSize();

                double result = imc.ComputeIMC(weight, size);

                resultView.setText(String.valueOf(result));
            }
        });
    }

    private double GetWeight() {
        final EditText weightView = (EditText) findViewById(R.id.weight);
        String text = weightView.getText().toString();
        return Double.parseDouble(text);
    }

    private double GetSize() {
        final EditText sizeView = (EditText) findViewById(R.id.size);
        String text = sizeView.getText().toString();
        return Double.parseDouble(text);
    }
}
