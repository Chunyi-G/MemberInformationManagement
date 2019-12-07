package com.example.asus.membermanagement;

import android.provider.BaseColumns;

public class CustomerInformation {

    private CustomerInformation() {}

    public static final class CustomerInformationEntry implements BaseColumns {
        public static final String TABLE_NAME = "customerinformation_table";
        public static final String COL_1 = "ID";
        public static final String COL_2 = "FIRST_NAME";
        public static final String COL_3 = "LAST_NAME";
        public static final String COL_4 = "CONTACT_NO";
        public static final String COL_5 = "EMAIL";
        public static final String COL_6 = "MEMBER_TYPE";
        public static final String COL_7 = "ADDRESS";
    }
}
