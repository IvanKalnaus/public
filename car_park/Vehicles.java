package Park;

abstract class Vehicles implements FleetMintenance {
    private String carBrand;
    private String carModel;
    private String typeOfFuel;
    private String carManufactureDate;
    private int fuelEfficiency;
    private int numberOfWheels;

    Vehicles(String carBrand, String carModel, String typeOfFuel, String carManufactureDate, int fuelEfficiency, int numberOfWheels) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.typeOfFuel = typeOfFuel;
        this.carManufactureDate = carManufactureDate;
        this.fuelEfficiency = fuelEfficiency;
        this.numberOfWheels = numberOfWheels;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getTypeOfFuel() {
        return typeOfFuel;
    }

    public String getCarManufactureDate() {
        return carManufactureDate;
    }

    public int getFuelEfficiency() {
        return fuelEfficiency;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }
}



