package com.user.work.testing.horoscope.ui.list_fragment;


import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.user.work.testing.horoscope.R;
import com.user.work.testing.horoscope.data.model.Horoscope;
import com.user.work.testing.horoscope.ui.HoroscopeAdapter;
import com.user.work.testing.horoscope.ui.HoroscopeClickHandler;
import com.user.work.testing.horoscope.utils.ZodiacSignUtil;

import java.util.List;

public class FragmentList extends Fragment implements IListMvpView, DatePickerDialog.OnDateSetListener {
    public static final String TAG = "tag";
    private RecyclerView mRecyclerView;
    private HoroscopeAdapter mAdapter;
    private List<Horoscope> mHoroscopeList;
    private ListPresenter mListPresenter;
    private HoroscopeClickHandler listener;
    private AboutOptionClick listenerAbout;
    private  int zodiac = -1;

    public interface AboutOptionClick {
        void onAboutOptionClicked();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (HoroscopeClickHandler) context;
        listenerAbout = (AboutOptionClick) context;
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.date:
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, 2017, 0, 1);
                datePickerDialog.show();
                break;
            case R.id.about:
                listenerAbout.onAboutOptionClicked();
        }

        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mListPresenter = new ListPresenter(getActivity(), this);

        if (zodiac == -1) {
            mListPresenter.showHoroscopeList();
            Log.d(TAG, "onCreateView: " + zodiac);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null){

            zodiac = savedInstanceState.getInt("int", -1);
            Log.d(TAG, "onActivityCreated: " + zodiac);
            if (zodiac != -1){
                mListPresenter.showSingleHoroscopeList(zodiac);
            } else mListPresenter.showHoroscopeList();
        }
    }

    @Override
    public void showHoroscopeList() {
        mHoroscopeList = mListPresenter.getHoroscopeList();
        mAdapter = new HoroscopeAdapter(mHoroscopeList, new HoroscopeClickHandler() {
            @Override
            public void onHoroscopeItemClick(Horoscope horoscope) {
                onItemClick(horoscope);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        Log.d(TAG, "showHoroscopeList: ");
    }

    @Override
    public void showSingleHoroscopeList(int position) {
        mHoroscopeList = mListPresenter.getSingleHoroscopeList(position);
        Log.d(TAG, "showSingleHoroscopeList: size " + mHoroscopeList.size());

        mAdapter = new HoroscopeAdapter(mHoroscopeList, new HoroscopeClickHandler() {
            @Override
            public void onHoroscopeItemClick(Horoscope horoscope) {
                onItemClick(horoscope);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(Horoscope horoscope) {
        listener.onHoroscopeItemClick(horoscope);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        zodiac = ZodiacSignUtil.getZodiacPosition(i1 + 1, i2);
        mListPresenter.showSingleHoroscopeList(zodiac);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("int", zodiac );
    }
}
