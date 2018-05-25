package com.example.danilishe.crriminalintent;

import android.support.v4.app.Fragment;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return new CrimeFragment();
    }
}
