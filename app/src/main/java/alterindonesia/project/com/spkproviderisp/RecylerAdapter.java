package alterindonesia.project.com.spkproviderisp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.ViewHolder>{

    List<Model> modelList = new ArrayList<>();
    Context context;

    public RecylerAdapter(Context context, List<Model> modelList){
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_item, viewGroup, false);
        RecylerAdapter.ViewHolder vh = new RecylerAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvNama.setText(modelList.get(i).getPaket());
        viewHolder.tvHarga.setText(modelList.get(i).getHarga());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvHarga;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama  = (TextView) itemView.findViewById(R.id.tvNama);
            tvHarga  = (TextView) itemView.findViewById(R.id.tvHarga);
        }
    }
}
