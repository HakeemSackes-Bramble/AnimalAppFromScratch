package nyc.c4q.hakeemsackes_bramble.animalappfromscratch.AnimalDataService;

import java.util.List;

/**
 * Created by hakeemsackes-bramble on 12/21/16.
 */
public class AnimalData {
    boolean success;
    List<Animal> animals;

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
