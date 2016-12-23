package nyc.c4q.hakeemsackes_bramble.animalappfromscratch.AnimalDataService;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hakeemsackes-bramble on 12/22/16.
 */

public class AnimalRetrofitData {
    public List<Animal> getRetroAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    List<Animal> animals;

    private List<Animal> getAnimalData() {

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
        return animals;
    }

}
