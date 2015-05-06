package com.vivien_adnot.imccalculator.IMC.SizeConverter;

/**
 * Created by Vivien on 06/05/2015.
 */
public class CentimeterSizeConverter implements SizeConverter {
    @Override
    public double GetSizeInMeter(double size) {
        return size / 100;
    }
}
