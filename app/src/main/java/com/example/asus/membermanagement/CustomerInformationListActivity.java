package com.example.asus.membermanagement;

import android.support.v4.app.Fragment;

public class CustomerInformationListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CustomerInformationListFragment();
    }
}
