package com.user.work.testing.horoscope.ui.list_fragment;

import android.content.Context;
import android.util.Log;

import com.user.work.testing.horoscope.data.DataLab;
import com.user.work.testing.horoscope.data.model.Horoscope;
import com.user.work.testing.horoscope.data.IDataLab;

import java.util.List;

/**
 * Created by Solo_Family on 05.11.2017.
 */

public class ListPresenter implements IListMvpPresenter {
    IListMvpView mIListMvpView;
    IDataLab mIDataLab;

    public ListPresenter(Context context, IListMvpView listMvpView) {
        mIListMvpView = listMvpView;
        mIDataLab = DataLab.getInstance(context);
    }

    @Override
    public List<Horoscope> getHoroscopeList() {
        return mIDataLab.getData();
    }

    @Override
    public List<Horoscope> getSingleHoroscopeList(int position) {
        Log.d("tag", "getSingleHoroscopeList: " + mIDataLab.getSingleSignData(position).get(0).getZodiac());
        return mIDataLab.getSingleSignData(position);

    }

    @Override
    public void showHoroscopeList() {
        mIListMvpView.showHoroscopeList();

    }

    @Override
    public void showSingleHoroscopeList(int position) {
        mIListMvpView.showSingleHoroscopeList(position);
        Log.d("tag", "showSingleHoroscopeList: " + position);
    }
}
