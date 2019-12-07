package com.example.asus.membermanagement;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomerInformationAdapter extends RecyclerView.Adapter<CustomerInformationAdapter.CustomerInformationViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public CustomerInformationAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }

    public class CustomerInformationViewHolder extends RecyclerView.ViewHolder {
        public TextView firstName;
        public TextView lastName;
        public TextView contactNo;
        public TextView email;
        public TextView memberType;
        public TextView address;

        public CustomerInformationViewHolder(View itemView) {
            super(itemView);

            firstName = itemView.findViewById(R.id.tv_fName);
            lastName = itemView.findViewById(R.id.tv_lName);
            contactNo = itemView.findViewById(R.id.tv_ContactNo);
            email = itemView.findViewById(R.id.tv_Email);
            memberType = itemView.findViewById(R.id.tv_MemberType);
            address = itemView.findViewById(R.id.tv_Address);

        }
    }

    @Override
    public CustomerInformationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_item_bs, parent, false);
        return new CustomerInformationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomerInformationViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
            return;
        }

        long id = mCursor.getLong(mCursor.getColumnIndex(CustomerInformation.CustomerInformationEntry.COL_1));
        String f_Name = mCursor.getString(mCursor.getColumnIndex(CustomerInformation.CustomerInformationEntry.COL_2));
        String l_Name = mCursor.getString(mCursor.getColumnIndex(CustomerInformation.CustomerInformationEntry.COL_3));
        String contact_No = mCursor.getString(mCursor.getColumnIndex(CustomerInformation.CustomerInformationEntry.COL_4));
        String email = mCursor.getString(mCursor.getColumnIndex(CustomerInformation.CustomerInformationEntry.COL_5));
        String member_Type = mCursor.getString(mCursor.getColumnIndex(CustomerInformation.CustomerInformationEntry.COL_6));
        String address = mCursor.getString(mCursor.getColumnIndex(CustomerInformation.CustomerInformationEntry.COL_7));

        holder.itemView.setTag(id);
        holder.firstName.setText(f_Name);
        holder.lastName.setText(l_Name);
        holder.contactNo.setText(contact_No);
        holder.email.setText(email);
        holder.memberType.setText(member_Type);
        holder.address.setText(address);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }

        mCursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }
}