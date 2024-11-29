package Park;

public class CargoTransport extends Vehicles implements SealingTheBody, OrderDeliveryExecution {
    private int bodyVolume;
    private int loadCapacity;
    private BodyTypeOfCargoTransport bodyTypeOfCargoTransport;


    CargoTransport(String carBrand, String carModel, String typeOfFuel, String carManufactureDate, int fuelEfficiency, int numberOfWheels, int bodyVolume, int loadCapacity, BodyTypeOfCargoTransport type) {
        super(carBrand, carModel, typeOfFuel, carManufactureDate, fuelEfficiency, numberOfWheels);
        this.bodyTypeOfCargoTransport = type;
        this.bodyVolume = bodyVolume;
        this.loadCapacity = loadCapacity;
    }


    @Override
    public void carCleaning(Vehicles vehicle) {
        System.out.println("The cabin, the salon and the body " + vehicle.getCarBrand() + " " + vehicle.getCarModel() + " were washed");
    }

    @Override
    public void sealing() {
        System.out.println("The body was sealed");
    }

    public int getBodyVolume() {
        return bodyVolume;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public BodyTypeOfCargoTransport getBodyTypeOfCargoTransport() {
        return bodyTypeOfCargoTransport;
    }

    @Override
    public void loadingTheOrderIntoTheCar(String placeOfLoading, Vehicles vehicle) {
        System.out.println("The cargo was loaded in place " + placeOfLoading + " in following car: " + vehicle.getCarBrand() + " " + vehicle.getCarModel());
        sealing();
    }

    @Override
    public void deliveryOrder() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unloadingTheOrderIntoTheCar(String destination, Vehicles vehicle) {
        System.out.println("The cargo was unloaded in place " + destination + " from following car: " + vehicle.getCarBrand() + " " + vehicle.getCarModel());
    }
}



