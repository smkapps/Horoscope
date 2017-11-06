package com.user.work.testing.horoscope.ui.list_fragment;

import com.user.work.testing.horoscope.data.model.Horoscope;

/**
 * Created by Solo_Family on 05.11.2017.
 */

public interface IListMvpView {
    void showHoroscopeList();

    void showSingleHoroscopeList(int position);

    void onItemClick(Horoscope horoscope);
}
