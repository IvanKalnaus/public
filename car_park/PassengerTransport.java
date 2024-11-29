package Park;


public class PassengerTransport extends Vehicles implements DisinfectTheInterior, PassengersDeliveryExecution {
    private int passengerCapacity;


    PassengerTransport(String carBrand, String carModel, String typeOfFuel, String carManufactureDate, int fuelEfficiency, int numberOfWheels, int passengerCapacity) {
        super(carBrand, carModel, typeOfFuel, carManufactureDate, fuelEfficiency, numberOfWheels);
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

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public void passengerBoarding(String landingPlace, Vehicles vehicle) {
        System.out.println("Passengeres were planted in place " + landingPlace + " in following car: " + vehicle.getCarBrand() + " " + vehicle.getCarModel());
    }

    @Override
    public void deliveryPassengers() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disembarkingPassengers(String destination, Vehicles vehicle) {
        System.out.println("Passengeres were landed in place " + destination + " from following car: " + vehicle.getCarBrand() + " " + vehicle.getCarModel());
    }
}



