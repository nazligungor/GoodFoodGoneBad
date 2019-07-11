package edu.duke.compsci290.goodfoodgonebad;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import edu.duke.compsci290.goodfoodgonebad.Database.Product;

/**
 * Created by nazligungor on 29.04.2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>{

    private List<Product> itemList;
    private View.OnLongClickListener longClickListener;
    private Context mContext;

    private ItemListViewModel mViewModel;

    public RecyclerViewAdapter(List<Product> itemList, View.OnLongClickListener longClickListener, Context c, ItemListViewModel v) {
        this.itemList = itemList;
        this.longClickListener = longClickListener;
        this.mContext = c;
        this.mViewModel = v;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = mInflater.inflate(R.layout.item_holder, parent, false);
        final RecyclerViewHolder itemHolder = new RecyclerViewHolder(row);

        itemHolder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = itemHolder.itemTextView.toString();
                openItem(n);
            }
        });
        return itemHolder;
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        Product p = itemList.get(position);
        // Add object name with padding
        holder.itemTextView.setText(String.format("%1$-" + 5 + "s", p.getItemName()));
        // Determine Expiration Date from getTime arithmetic
        long tRemainMillis = p.getExpiration().getTime() - new Date().getTime();
        long tRemainDays = tRemainMillis / (24 * 60 * 60 * 1000);
        int daysRem = Math.round(tRemainDays);
        String daysStr;
        // Add days-until-expiration
        if (daysRem > 0 ){
            daysStr = String.format("%d",daysRem).concat(" days until expiration");
        }
        else{
            daysStr = "EXPIRED";
        }
        holder.dateTextView.setText(daysStr);

    }

    private void openItem(String n){
//        if(n != null) {      // Line with Error
//
//            Intent intent = new Intent(mContext, ItemDetailsActivity.class);
//            Product p = mViewModel.getItembyName(n);
//            intent.putExtra("item_name", p.getItemName());
//            intent.putExtra("item_brand", p.getBrand());
//            intent.putExtra("item_exp", p.getExpiration().toString());
//            intent.putExtra("item_pur", p.getPurchase().toString());
//
//            mContext.startActivity(intent);
//        }
    }

    public Product getFirstItem(){
        return itemList.get(0);

    }


    public void addItems(List<Product> itemList) {
//        // Re-sort list in descending order with new entry included
//        Collections.sort(itemList, new Comparator<Product>() {
//            @Override
//            // Descending Order (get Time gets Milliseconds since 01/1997 00:00:00 GMT
//            public int compare(Product o1, Product o2) {
//                return (int)(o1.expiration.getTime() - o2.expiration.getTime());
//            }
//        });

        this.itemList = itemList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTextView;
        private TextView dateTextView;
        private LinearLayout mLinearLayout;

        RecyclerViewHolder(View view) {
            super(view);
            itemTextView = view.findViewById(R.id.item_name_text_view);
            dateTextView = view.findViewById(R.id.exp_date_text_view);
            mLinearLayout = view.findViewById(R.id.item_holder_linear_layout);
        }
    }

}
