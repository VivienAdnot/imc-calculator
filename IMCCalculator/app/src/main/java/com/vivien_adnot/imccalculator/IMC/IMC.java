package com.vivien_adnot.imccalculator.IMC;

import android.util.Log;

import com.vivien_adnot.imccalculator.IMC.SizeConverter.SizeConverter;
import com.vivien_adnot.imccalculator.IMC.SizeConverter.SizeConverterFactory;
import com.vivien_adnot.imccalculator.IMC.SizeConverter.Unit;

/**
 * Created by Vivien on 06/05/2015.
 */
public class IMC {
    private Unit unit;

    public IMC() {
        this.unit = Unit.METER;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public double ComputeIMC(double weight, double size) {
        double sizeInMeter = GetSizeInMeter(size);
        return ExecuteIMCFormula(weight, sizeInMeter);
    }

    private double GetSizeInMeter(double size) {
        double sizeInMeter;

        try {
            SizeConverter sizeConverter = SizeConverterFactory.GetSizeConverter(unit);
            sizeInMeter = sizeConverter.GetSizeInMeter(size);
        } catch (IllegalArgumentException exception) {
            Log.e("IMC:GetSizeInMeter", exception.getMessage());
            sizeInMeter = size;
        }

        return sizeInMeter;
    }

    private double ExecuteIMCFormula(double weight, double sizeInMeter) {
        double imc;

        try {
            imc = weight / Math.pow(sizeInMeter, 2.0);
        } catch (ArithmeticException exception) {
            Log.e("IMC:ExecuteIMCFormula", "illegal division by 0");
            imc = 0.0;
        }

        return imc;
    }
}
