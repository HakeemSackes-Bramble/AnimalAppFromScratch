package nyc.c4q.hakeemsackes_bramble.animalappfromscratch.AnimalDataService;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hakeemsackes-bramble on 12/21/16.
 */

public interface AnimalService {

    @GET("cgi-bin/12_21_2016_exam.pl")
    Call<AnimalData> getAnimalData();
}
