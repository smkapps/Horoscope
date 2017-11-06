package com.user.work.testing.horoscope.data;

import android.content.Context;

import com.user.work.testing.horoscope.R;
import com.user.work.testing.horoscope.data.model.Horoscope;

import java.util.ArrayList;
import java.util.List;

public class DataLab implements IDataLab{

    private static DataLab sDataLab;
    private static List<Horoscope> mHoroscopeList;


    private DataLab(Context context) {
        mHoroscopeList = new ArrayList<>();
        populateList(context);
    }

    public static DataLab getInstance(Context context) {
        if (sDataLab==null){
            return new DataLab(context);
        }
        else return sDataLab;
    }

    private void populateList(Context context) {
        mHoroscopeList = new ArrayList<>();
        String[] array = context.getResources().getStringArray(R.array.item_list);
        for (int i = 0; i < array.length; i += 4) {
            String imageUrl = array[i];
            String zodiac = array[i + 1];
            String prediction = array[i + 2];
            String dates = array[i + 3];
            Horoscope recipe = new Horoscope(zodiac, dates, prediction, imageUrl);
            mHoroscopeList.add(recipe);
        }

    }

    @Override
    public List<Horoscope> getData() {
        return mHoroscopeList;
    }

    @Override
    public List<Horoscope> getSingleSignData(int position) {
        List<Horoscope> singleSignList = new ArrayList<>();
        singleSignList.add(mHoroscopeList.get(position));
        return singleSignList;
    }
}
