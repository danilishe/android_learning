package com.example.danilishe.crriminalintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.danilishe.crriminalintent.model.Crime;
import com.example.danilishe.crriminalintent.model.CrimeLab;

import java.util.List;

public class CrimeListFragment extends Fragment {
    public CrimeListFragment() {

    }

    private RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mRecyclerView = v.findViewById(R.id.crime_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUi();
        return v;
    }

    private void updateUi() {
        CrimeLab crimeLab = CrimeLab.getInstance(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        CrimeAdapter adapter = new CrimeAdapter(crimes);
        mRecyclerView.setAdapter(adapter);
    }

    public class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crimeList) {
           mCrimes = crimeList;
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            holder.bind(mCrimes.get(position));
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
    private class CrimeHolder extends RecyclerView.ViewHolder {
        private TextView mCrimeTitle;
        private TextView mCrimeDate;

        public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_crime, parent, false));
            mCrimeDate = itemView.findViewById(R.id.crime_item_date);
            mCrimeTitle = itemView.findViewById(R.id.crime_item_title);
        }
        public void bind(Crime crime) {
            mCrimeTitle.setText(crime.getTitle());
            mCrimeDate.setText(crime.getDate().toString());
        }
    }
}
