package app.com.huelightsalarm.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import app.com.huelightsalarm.interfaces.DataSetChanged;
import app.com.huelightsalarm.interfaces.HueLightsListProvider;
import app.com.huelightsalarm.R;
import app.com.huelightsalarm.viewmodels.HueLightViewModel;
import app.com.huelightsalarm.views.holders.HueLightCardHolder;

public class HueLightCardAdapter extends RecyclerView.Adapter<HueLightCardHolder> implements DataSetChanged {

    private HueLightsListProvider listProvider;

    public HueLightCardAdapter(HueLightsListProvider listProvider) {
        this.listProvider = listProvider;
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
        model.fillCardHolder(holder);
    }

    @Override
    public int getItemCount() {
        return listProvider.getHueLightViewModelList().size();
    }


}
