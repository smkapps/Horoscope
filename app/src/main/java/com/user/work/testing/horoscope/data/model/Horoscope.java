package com.user.work.testing.horoscope.data.model;

import java.io.Serializable;

public class Horoscope implements Serializable {

    private String zodiac;

    private String dates;

    private String prediction;

    private String imageUrl;

    public Horoscope(String zodiac, String dates, String prediction, String imageUrl) {
        this.zodiac = zodiac;
        this.dates = dates;
        this.prediction = prediction;
        this.imageUrl = imageUrl;
    }

    public String getZodiac() {
        return zodiac;
    }

    public String getDates() {
        return dates;
    }

    public String getPrediction() {
        return prediction;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
