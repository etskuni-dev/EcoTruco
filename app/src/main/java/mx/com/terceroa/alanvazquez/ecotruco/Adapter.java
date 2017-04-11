package mx.com.terceroa.alanvazquez.ecotruco;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by AlanVazquez on 10/04/17.
 */

public class Adapter  extends RecyclerView.Adapter<Adapter.TrucosViewHolder>{


    List<Truco> trucos;
    Context contexto;

    public Adapter(Context contexto, List<Truco> trucos) {
        this.trucos = trucos;
        this.contexto = contexto;
    }

    @Override
    public TrucosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler, parent,false);
        TrucosViewHolder holder = new TrucosViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(TrucosViewHolder holder, int position) {
        Truco truco = trucos.get(position);
        holder.tvTitulo.setText(truco.getTitulo());
        holder.tvTiempo.setText(Integer.toString(truco.getTiempo()) + "min");
        holder.tvDificultad.setText(truco.getDificultad());
        holder.tvDescripcion.setText(truco.getDescripcion());
        //holder.tvImagen.setText(truco.getUrlImagen());
        String url = truco.getUrlImagen();


        Glide.with(contexto)
                .load(url)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return trucos.size();
    }

    public static class TrucosViewHolder extends RecyclerView.ViewHolder{


        TextView tvTitulo, tvTiempo, tvDificultad, tvDescripcion;
        ImageView imageView;

        public TrucosViewHolder(View itemView) {
            super(itemView);
            tvTitulo= (TextView) itemView.findViewById(R.id.textViewTitulo);
            tvTiempo = (TextView) itemView.findViewById(R.id.textViewTiempo);
            tvDificultad = (TextView) itemView.findViewById(R.id.textViewDificultad);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            tvDescripcion = (TextView) itemView.findViewById(R.id.textViewDescripcion);
        }
    }
}
