package app.com.huelightsalarm.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import app.com.huelightsalarm.interfaces.DataSetChanged;
import app.com.huelightsalarm.interfaces.HueLightsListProvider;
import app.com.huelightsalarm.R;
import app.com.huelightsalarm.viewmodels.HueLightViewModel;
import app.com.huelightsalarm.views.holders.HueLightCardHolder;

public class HueLightCardAdapter extends RecyclerView.Adapter<HueLightCardHolder> implements DataSetChanged {

    private HueLightsListProvider listProvider;
    private View.OnClickListener onClickListener;

    public HueLightCardAdapter(HueLightsListProvider listProvider, View.OnClickListener onClickListener) {
        this.listProvider = listProvider;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public HueLightCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_huelight, parent, false);

        return new HueLightCardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HueLightCardHolder holder, int position) {
        HueLightViewModel model = this.listProvider.getHueLightViewModelList().get(position);
        model.fillCardHolder(holder,listProvider.getLightsModifier());
        holder.subscribeToOnClick(onClickListener);
    }

    @Override
    public int getItemCount() {
        return listProvider.getHueLightViewModelList().size();
    }


}
