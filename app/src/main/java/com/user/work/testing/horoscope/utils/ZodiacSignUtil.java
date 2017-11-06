package com.user.work.testing.horoscope.utils;

public class ZodiacSignUtil {

    public static int getZodiacPosition (int month, int day){
        switch (month) {
            case 1:
                if (day < 20) {
                    return 11;
                } else {
                    return 0;
                }

            case 2:
                if (day < 18) {
                    return 0;
                } else {
                    return 1;
                }

            case 3:
                if (day < 21) {
                    return 1;
                } else {
                    return(2);
                }

            case 4:
                if (day < 20) {
                    return 2;
                } else {
                    return(3);
                }

            case 5:
                if (day < 21) {
                    return(3);
                } else {
                    return(4);
                }

            case 6:
                if (day < 21) {
                    return(4);
                } else {
                    return(5);
                }

            case 7:
                if (day < 23) {
                    return(5);
                } else {
                    return(6);
                }

            case 8:
                if (day < 23) {
                    return(6);
                } else {
                    return(7);
                }

            case 9:
                if (day < 23) {
                    return(7);
                } else {
                    return(8);
                }

            case 10:
                if (day < 23) {
                    return(8);
                } else {
                    return(9);
                }

            case 11:
                if (day < 22) {
                    return(9);
                } else {
                    return(10);
                }

            case 12:
                if (day < 22) {
                    return(10);
                } else {
                    return(11);
                }

        }
        return -1;
    }

}


