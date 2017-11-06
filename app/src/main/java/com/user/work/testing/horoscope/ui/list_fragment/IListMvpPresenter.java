package com.user.work.testing.horoscope.ui.list_fragment;

import com.user.work.testing.horoscope.data.model.Horoscope;

import java.util.List;

public interface IListMvpPresenter {

    List<Horoscope> getHoroscopeList();

    List<Horoscope> getSingleHoroscopeList(int pos);

    void showHoroscopeList();

    void showSingleHoroscopeList(int position);
}
