package Park;

 public class CargoAndPassengerTransport extends Vehicles implements DisinfectTheInterior, SealingTheBody, PassengersDeliveryExecution, OrderDeliveryExecution {
    private int bodyVolume;
    private int loadCapacity;
    private int passengerCapacity;
    private BodyTypeOfCargoTransport bodyTypeOfCargoTransport;


    CargoAndPassengerTransport(String carBrand, String carModel, String typeOfFuel, String carManufactureDate, int fuelEfficiency, int numberOfWheels, int bodyVolume, int loadCapacity, int passengerCapacity, BodyTypeOfCargoTransport type) {
        super(carBrand, carModel, typeOfFuel, carManufactureDate, fuelEfficiency, numberOfWheels);
        this.bodyTypeOfCargoTransport = type;
        this.bodyVolume = bodyVolume;
        this.loadCapacity = loadCapacity;
        this.passengerCapacity = passengerCapacity;
    }


    @Override
    public void carCleaning(Vehicles vehicle) {
        System.out.println("The cabin, the salon and the body " + vehicle.getCarBrand() + " " + vehicle.getCarModel() + " were washed");
    }

    @Override
    public void disinfect(Vehicles vehicle) {
        System.out.println("The salon car " + vehicle.getCarBrand() + " " + vehicle.getCarModel() + " was desinfected");
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

    public int getPassengerCapacity() {
        return passengerCapacity;
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
    public void passengerBoarding(String landingPlace, Vehicles vehicle) {
        System.out.println("Passengeres were planted in place " + landingPlace + " in following car: " + vehicle.getCarBrand() + " " + vehicle.getCarModel());
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
    public void deliveryPassengers() {
    }

    @Override
    public void unloadingTheOrderIntoTheCar(String destination, Vehicles vehicle) {
        System.out.println("The cargo was unloaded in place " + destination + " from following car: " + vehicle.getCarBrand() + " " + vehicle.getCarModel());
    }


    @Override
    public void disembarkingPassengers(String destination, Vehicles vehicle) {
        System.out.println("Passengeres were landed in place " + destination + " from following car: " + vehicle.getCarBrand() + " " + vehicle.getCarModel());
    }

}



