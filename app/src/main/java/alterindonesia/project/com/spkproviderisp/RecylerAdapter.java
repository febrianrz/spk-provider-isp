package alterindonesia.project.com.spkproviderisp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.ViewHolder>{

    List<PaketResponse> modelList = new ArrayList<>();
    Context context;

    public RecylerAdapter(Context context, List<PaketResponse> modelList){
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
        try {
            viewHolder.tvNama.setText(modelList.get(i).getPaket());
            viewHolder.tvHarga.setText(modelList.get(i).getPrice());
            viewHolder.tvSpeed.setText(modelList.get(i).getSpeed());
            Picasso.get()
                    .load(Config.url+"gambar/"+modelList.get(i).getGambar())
                    .placeholder(R.drawable.icn_paket5)
                    .error(R.drawable.icn_paket5)
                    .into(viewHolder.imgLogo);
        } catch (Exception e){
            Toast.makeText(context,e.getMessage().toString(),Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvHarga, tvSpeed;
        ImageView imgLogo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama  = (TextView) itemView.findViewById(R.id.tvNama);
            tvHarga  = (TextView) itemView.findViewById(R.id.tvHarga);
            tvSpeed  = (TextView) itemView.findViewById(R.id.tvSpeed);
            imgLogo = (ImageView) itemView.findViewById(R.id.imgLogo);
        }
    }
}
