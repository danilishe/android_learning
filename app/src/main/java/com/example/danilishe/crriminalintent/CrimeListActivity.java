package com.example.danilishe.crriminalintent;

import android.support.v4.app.Fragment;

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new CrimeListFragment();
    }
}
