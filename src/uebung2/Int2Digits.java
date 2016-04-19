package uebung2;

import java.util.Arrays;

public class Int2Digits
{
    static String digits= new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    int base;

    public Int2Digits(int base)   // constructor with base parameter
    {
        this.base=base;
    }

    public int getBase()    // base getter function
    {
        return base;
    }

    public int[] int2digitArray(int number)
    // convert number to LITTLE ENDIAN integer array
    {
        int[] digitArray= new int[32];  // maximum number of digits
        int digit= 0;
        do  // run at least once even if number == 0
        {
            digitArray[digit++]= number % base;
            number /= base;
        }
        while (number > 0);
        return Arrays.copyOf(digitArray, digit);
    }

    public String digitArray2string(int[] digitArray)
    // convert LITTLE ENDIAN integer array to string
    {
        String result= new String("");
        for (int digit= digitArray.length; digit > 0;
            result+= digits.charAt(digitArray[--digit]));
        return result;
    }

    public String int2string(int number)
    // convert number to string
    {
        return digitArray2string(int2digitArray(number));
    }
}
