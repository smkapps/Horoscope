package com.user.work.testing.horoscope.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.user.work.testing.horoscope.data.model.Horoscope;
import com.user.work.testing.horoscope.databinding.HoroscopeItemBinding;

import java.util.List;
public class HoroscopeAdapter  extends RecyclerView.Adapter<HoroscopeAdapter.HoroscopeViewHolder> {
    private List<Horoscope> mHoroscopeList;
    private HoroscopeClickHandler mHoroscopeClickHandler;

    public HoroscopeAdapter(List<Horoscope> horoscopeList, HoroscopeClickHandler horoscopeClickHandler) {
        mHoroscopeList = horoscopeList;
        mHoroscopeClickHandler = horoscopeClickHandler;
    }

    public HoroscopeAdapter(List<Horoscope> horoscopeList) {
        this.mHoroscopeList = horoscopeList;
    }

    @Override
    public HoroscopeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        HoroscopeItemBinding binding = HoroscopeItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HoroscopeViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(HoroscopeViewHolder holder, int position) {
        holder.binding.setHoroscope(mHoroscopeList.get(position));
        holder.binding.setClick(mHoroscopeClickHandler);
    }

    @Override
    public int getItemCount() {
        return mHoroscopeList.size();
    }

    public class HoroscopeViewHolder extends RecyclerView.ViewHolder {
        HoroscopeItemBinding binding;

        public HoroscopeViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}