package com.user.work.testing.horoscope.data;

import com.user.work.testing.horoscope.data.model.Horoscope;

import java.util.List;

/**
 * Created by Solo_Family on 05.11.2017.
 */

public interface IDataLab {

    List<Horoscope> getData();
    List<Horoscope> getSingleSignData(int position);
}
