package com.user.work.testing.horoscope.ui;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.user.work.testing.horoscope.R;
import com.user.work.testing.horoscope.data.model.Horoscope;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAbout extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        TextView textView= view.findViewById(R.id.link);
        Linkify.addLinks(textView, Linkify.WEB_URLS);
        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Ваш гороскоп")
                .setView(R.layout.fragment_about)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        Dialog dlg = builder.create();
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dlg;
    }

    public static class DetailFragment extends DialogFragment {
        public static final String HOROSCOPE = "horoscope";
        private Horoscope mHoroscope;

        public static DetailFragment newInstance(Horoscope horoscope) {
            DetailFragment detailFragment = new DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(HOROSCOPE, horoscope);
            detailFragment.setArguments(bundle);
            return detailFragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() !=null)
            mHoroscope = (Horoscope) getArguments().getSerializable(HOROSCOPE);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_detail, container, false);
            TextView text = view.findViewById(R.id.text);
            text.setText(mHoroscope.getPrediction());
            return view;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Ваш гороскоп")
                    .setMessage(mHoroscope.getPrediction()                )
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            Dialog dlg = builder.create();
            dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
            return dlg;
        }
    }
}
