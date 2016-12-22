package nyc.c4q.hakeemsackes_bramble.animalappfromscratch;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.hakeemsackes_bramble.animalappfromscratch.AnimalDataService.Animal;
import nyc.c4q.hakeemsackes_bramble.animalappfromscratch.AnimalDataService.AnimalData;
import nyc.c4q.hakeemsackes_bramble.animalappfromscratch.AnimalDataService.AnimalService;
import nyc.c4q.hakeemsackes_bramble.animalappfromscratch.AnimalRecyclerView.AnimalAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        getAnimalData();
    }

    public static void getAnimalData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsjrobotics.nyc/cgi-bin/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AnimalService service = retrofit.create(AnimalService.class);
        Call<AnimalData> call = service.getAnimalData();
        call.enqueue(new Callback<AnimalData>() {
            @Override
            public void onResponse(Call<AnimalData> call, Response<AnimalData> response) {
                AnimalData data = response.body();
                animals = data.getAnimals();
                System.out.println("it worked");
                Log.d("", "onResponse: post data ");
            }

            @Override
            public void onFailure(Call<AnimalData> call, Throwable t) {
                Log.d("error", t.getMessage());
                System.out.println("fail");
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_layout, parent, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.list);
        recyclerView.setAdapter(new AnimalAdapter(animals));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

}
