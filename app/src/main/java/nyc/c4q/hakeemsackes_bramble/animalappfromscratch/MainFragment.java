package nyc.c4q.hakeemsackes_bramble.animalappfromscratch;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.hakeemsackes_bramble.animalappfromscratch.AnimalDataService.Animal;
import nyc.c4q.hakeemsackes_bramble.animalappfromscratch.AnimalDataService.AnimalRetrofitData;
import nyc.c4q.hakeemsackes_bramble.animalappfromscratch.AnimalRecyclerView.AnimalAdapter;

/**
 * Created by hakeemsackes-bramble on 12/21/16.
 */

public class MainFragment extends android.support.v4.app.Fragment {

    private View root;
    private RecyclerView recyclerView;
    static List<Animal> animals;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animals = new AnimalRetrofitData().getRetroAnimals();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_layout, parent, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.list);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        recyclerView.setAdapter(new AnimalAdapter(animals));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

}
