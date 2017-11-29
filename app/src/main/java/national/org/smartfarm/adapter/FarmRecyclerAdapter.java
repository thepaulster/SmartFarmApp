package national.org.smartfarm.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import national.org.smartfarm.R;
import national.org.smartfarm.model.FarmList;

/**
 * Created by Owner on 11/26/2017.
 */

public class FarmRecyclerAdapter extends RecyclerView.Adapter<FarmRecyclerAdapter.BeneficiaryViewHolder>  {

    private ArrayList<FarmList> listFarmList;
    public ImageView overflow;
    private Context mContext;
    private ArrayList<FarmList> mFilteredList;


    public FarmRecyclerAdapter(ArrayList<FarmList> listFarmList, Context mContext) {
        this.listFarmList = listFarmList;
        this.mContext = mContext;
        this.mFilteredList = listFarmList;


    }

    public class BeneficiaryViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewName;
        public AppCompatTextView textViewEmail;
        public AppCompatTextView textViewAddress;
        public AppCompatTextView textViewCountry;
        public  ImageView overflow;

        public BeneficiaryViewHolder(View view) {
            super(view);
            textViewName = (AppCompatTextView) view.findViewById(R.id.textViewChickensold);
            textViewEmail = (AppCompatTextView) view.findViewById(R.id.textViewChickssold);
            textViewAddress = (AppCompatTextView) view.findViewById(R.id.textVieweggssold);
//            textViewCountry = (AppCompatTextView) view.findViewById(R.id.textViewCountry);

        }


    }




    @Override
    public BeneficiaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_beneficiary_recycler, parent, false);

        return new BeneficiaryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BeneficiaryViewHolder holder, int position) {
        holder.textViewName.setText(listFarmList.get(position).getChickenSold());
        holder.textViewEmail.setText(listFarmList.get(position).getChicksSold());
        holder.textViewAddress.setText(listFarmList.get(position).getEggsSold());
//        holder.textViewCountry.setText(listFarmList.get(position).getCountry());


    }


    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }



}
