package com.coreymiles.Week_1;

/**
 * Created by Corey MIles on 1/17/2017.
 */
public class Exercise_1 {
    public static void main(String[] args) {
        String cityName = "Columbus";
        int zipCode = 43215;
        double[] highTemps = {32, 25 ,27, 40, 45};
        double average = (highTemps[0] + highTemps[1] + highTemps[2] + highTemps[3] + highTemps[4]) / 5;

        System.out.println("City: " + cityName);
        System.out.println("Zip: " + zipCode);
        System.out.println("Average High Temperature: " + average);
    }
}
