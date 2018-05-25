package com.example.danilishe.crriminalintent.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab ourInstance;
    private List<Crime> mCrimes;

    public static CrimeLab getInstance(Context context) {
        ourInstance = new CrimeLab(context);
        return ourInstance;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime c = new Crime();
            c.setTitle("Преступление №" + i);
            c.setSolved(i % 2 == 0);
            mCrimes.add(c);
        }
    }

    public Crime getCrime(UUID uuid) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(uuid)) return crime;
        }
        return null;
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }
}
