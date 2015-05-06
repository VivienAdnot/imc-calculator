package com.vivien_adnot.imccalculator.IMC.SizeConverter;

/**
 * Created by Vivien on 06/05/2015.
 */
public class SizeConverterFactory {
    public static SizeConverter GetSizeConverter(Unit unit) {
        switch (unit) {
            case CENTIMETER: return new CentimeterSizeConverter();
            case METER: return new MeterSizeConverter();
        }

        throw new IllegalArgumentException("illegal unit: " + unit.toString());
    }
}