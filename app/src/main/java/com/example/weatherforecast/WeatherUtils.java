package com.example.weatherforecast;

import android.content.Context;

public final class WeatherUtils {

    private static final String LOG_TAG = WeatherUtils.class.getSimpleName();

    private static double celsiusToFahrenheit(double temperatureInCelsius) {
        double temperatureInFahrenheit = (temperatureInCelsius * 1.8) + 32;
        return temperatureInFahrenheit;
    }

    public static String formatTemperature(Context context, double temperature) {
        boolean isMetric=true;
        int temperatureFormatResourceId = R.string.format_temperature_celsius;

        if (isMetric) {
            temperature = celsiusToFahrenheit(temperature);
            temperatureFormatResourceId = R.string.format_temperature_fahrenheit;
        }

        return String.format(context.getString(temperatureFormatResourceId), temperature);
    }


    public static String formatHighLows(Context context, double high, double low) {
        long roundedHigh = Math.round(high);
        long roundedLow = Math.round(low);

        String formattedHigh = formatTemperature(context, roundedHigh);
        String formattedLow = formatTemperature(context, roundedLow);

        String highLowStr = formattedHigh + " / " + formattedLow;
        return highLowStr;
    }







}