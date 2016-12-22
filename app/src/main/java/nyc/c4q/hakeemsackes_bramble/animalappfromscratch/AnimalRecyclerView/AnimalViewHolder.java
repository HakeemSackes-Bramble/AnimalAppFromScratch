package nyc.c4q.hakeemsackes_bramble.animalappfromscratch.AnimalRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.hakeemsackes_bramble.animalappfromscratch.R;

/**
 * Created by hakeemsackes-bramble on 12/21/16.
 */

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    TextView animalName;

    public AnimalViewHolder(ViewGroup parent) {
        super(parent);
        animalName = (TextView) itemView.findViewById(R.id.animal_name);
    }

}
