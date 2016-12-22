package nyc.c4q.hakeemsackes_bramble.animalappfromscratch.AnimalRecyclerView;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.hakeemsackes_bramble.animalappfromscratch.AnimalDataService.Animal;
import nyc.c4q.hakeemsackes_bramble.animalappfromscratch.R;

/**
 * Created by hakeemsackes-bramble on 12/21/16.
 */

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    List<Animal> animals;

    public AnimalAdapter(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        inflater.inflate(R.layout.animal_layout, parent, false);
        return new AnimalViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        holder.animalName.setText(animals.get(position).getmName());
        holder.animalName.setBackgroundColor(Color.parseColor(animals.get(position).getBackground()));
        holder.animalName.setTextColor(Color.parseColor(animals.get(position).getTextColor()));
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }
}
