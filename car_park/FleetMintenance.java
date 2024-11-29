package Park;


interface FleetMintenance {

    static void refuel(Vehicles vehicle) {
        System.out.println("The car " + vehicle.getCarBrand() + " " + vehicle.getCarModel() + " was refueled");
    }

    static void repair(Vehicles vehicle) {
        System.out.println("The car " + vehicle.getCarBrand() + " " + vehicle.getCarModel() + " was repaired");
    }

    static void wheelReplacement(Vehicles vehicle, int count) {
        if (count == 1)
            System.out.println("Wheel replaced");
        else
            System.out.println(count + " wheels replaced");
    }

    void carCleaning(Vehicles vehicle);
}



