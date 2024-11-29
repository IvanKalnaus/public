package Park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarPark {
    public static void main(String[] args) {

        Order order;
        Vehicles aSuitableCar;
        List<CargoTransport> listOfAvailableVehiclesCapableOfTransportingGoods = new ArrayList<>();
        List<PassengerTransport> listOfAvailableVehiclesCapableOfTransportingPassengers = new ArrayList<>();
        List<CargoAndPassengerTransport> listOfAvailableVehiclesCapableOfTransportingGoodsAndPassengers = new ArrayList<>();
        List<Vehicles> listOfNotAvailableVehicles = new ArrayList<>();


        CargoTransport cargoTransport1 = new CargoTransport("Volkswagen", "Crafter", "Diesel", "01.01.2011", 10,
                4, 8, 2000, BodyTypeOfCargoTransport.TENT_TYPE);

        CargoTransport cargoTransport2 = new CargoTransport("Hyundai", "HD 170", "Diesel", "01.01.2002", 15,
                10, 82, 20000, BodyTypeOfCargoTransport.REFRIGERATOR);

        CargoTransport cargoTransport3 = new CargoTransport("Mercedes-benz", "Actros 2545 6X2", "Diesel", "01.01.2014", 17,
                8, 31, 12420, BodyTypeOfCargoTransport.TANK);

        PassengerTransport passengerTransport1 = new PassengerTransport("Renault", "Espace", "95",
                "30.06.2000", 9, 4, 7);

        CargoAndPassengerTransport cargoAndPassengerTransport = new CargoAndPassengerTransport("Toyota", "Hilux", "Diesel", "01.01.2016", 13,
                4, 7, 700, 12, BodyTypeOfCargoTransport.TENT_TYPE);

        cargoTransport1.carCleaning(cargoTransport1);
        cargoTransport2.carCleaning(cargoTransport2);
        cargoTransport3.carCleaning(cargoTransport3);
        FleetMintenance.refuel(cargoTransport1);
        FleetMintenance.repair(cargoTransport2);
        passengerTransport1.disinfect(passengerTransport1);
        cargoAndPassengerTransport.disinfect(cargoAndPassengerTransport);


        listOfAvailableVehiclesCapableOfTransportingGoods.add(cargoTransport1);
        listOfAvailableVehiclesCapableOfTransportingGoods.add(cargoTransport2);
        listOfAvailableVehiclesCapableOfTransportingGoods.add(cargoTransport3);
        listOfAvailableVehiclesCapableOfTransportingPassengers.add(passengerTransport1);
        listOfAvailableVehiclesCapableOfTransportingGoodsAndPassengers.add(cargoAndPassengerTransport);

        System.out.println("Enter the desired number of orders ");
        Scanner scanner = new Scanner(System.in);
        int numberOfOrders = scanner.nextInt();
        for (int i = 0; i < numberOfOrders; i++) {
            order = makingAnOrder();
            if (order != null) {
                aSuitableCar = checkingTheAvailabilityOfTheRightCar(order, listOfAvailableVehiclesCapableOfTransportingGoods,
                        listOfAvailableVehiclesCapableOfTransportingPassengers, listOfAvailableVehiclesCapableOfTransportingGoodsAndPassengers);
                if (aSuitableCar instanceof CargoTransport) {
                    listOfAvailableVehiclesCapableOfTransportingGoods.remove(aSuitableCar);
                    listOfNotAvailableVehicles.add(aSuitableCar);

                    ((CargoTransport) aSuitableCar).loadingTheOrderIntoTheCar(order.getStartingPointOrder(), aSuitableCar);

                    System.out.println("Now free load capacity in this car = " + viewTheFreeLoadCapacity(aSuitableCar, order, listOfNotAvailableVehicles));
                    System.out.println("Now free value in this car = " + viewTheFreeValue(aSuitableCar, order, listOfNotAvailableVehicles));

                    ((CargoTransport) aSuitableCar).deliveryOrder();
                    ((CargoTransport) aSuitableCar).unloadingTheOrderIntoTheCar(order.getDestinationOrder(), aSuitableCar);

                    listOfNotAvailableVehicles.remove(aSuitableCar);
                    listOfAvailableVehiclesCapableOfTransportingGoods.add((CargoTransport) aSuitableCar);
                } else if (aSuitableCar instanceof PassengerTransport) {
                    listOfAvailableVehiclesCapableOfTransportingPassengers.remove(aSuitableCar);
                    listOfNotAvailableVehicles.add(aSuitableCar);

                    ((PassengerTransport) aSuitableCar).disinfect(aSuitableCar);
                    ((PassengerTransport) aSuitableCar).passengerBoarding(order.getStartingPointOrder(), aSuitableCar);

                    System.out.println("Now number free passenger seats in this car = " + viewTheNumberOfFreePassengerSeats(aSuitableCar, order, listOfNotAvailableVehicles));
                    ((PassengerTransport) aSuitableCar).deliveryPassengers();
                    ((PassengerTransport) aSuitableCar).disembarkingPassengers(order.getDestinationOrder(), aSuitableCar);

                    listOfNotAvailableVehicles.remove(aSuitableCar);
                    listOfAvailableVehiclesCapableOfTransportingPassengers.add((PassengerTransport) aSuitableCar);
                } else if (aSuitableCar instanceof CargoAndPassengerTransport) {
                    listOfAvailableVehiclesCapableOfTransportingGoodsAndPassengers.remove(aSuitableCar);
                    listOfNotAvailableVehicles.add(aSuitableCar);

                    printInformationAboutCurrentOrder(order, aSuitableCar);


                    ((CargoAndPassengerTransport) aSuitableCar).disinfect(aSuitableCar);
                    ((CargoAndPassengerTransport) aSuitableCar).loadingTheOrderIntoTheCar(order.getStartingPointOrder(), aSuitableCar);

                    System.out.println("Now free load capacity in this car = " + viewTheFreeLoadCapacity(aSuitableCar, order, listOfNotAvailableVehicles));
                    System.out.println("Now free value in this car = " + viewTheFreeValue(aSuitableCar, order, listOfNotAvailableVehicles));

                    ((CargoAndPassengerTransport) aSuitableCar).passengerBoarding(order.getStartingPointOrder(), aSuitableCar);

                    System.out.println("Now number free passenger seats in this car = " + viewTheNumberOfFreePassengerSeats(aSuitableCar, order, listOfNotAvailableVehicles));

                    ((CargoAndPassengerTransport) aSuitableCar).deliveryOrder();
                    ((CargoAndPassengerTransport) aSuitableCar).deliveryPassengers();
                    ((CargoAndPassengerTransport) aSuitableCar).unloadingTheOrderIntoTheCar(order.getDestinationOrder(), aSuitableCar);
                    ((CargoAndPassengerTransport) aSuitableCar).disembarkingPassengers(order.getDestinationOrder(), aSuitableCar);

                    listOfNotAvailableVehicles.remove(aSuitableCar);
                    listOfAvailableVehiclesCapableOfTransportingGoodsAndPassengers.add((CargoAndPassengerTransport) aSuitableCar);
                }
            }
        }
    }

    public static boolean positiveOrNegativeAnswerToTheQuestion() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String agreement = "yes";
        String disagreement = "no";
        String answer;
        try {
            answer = reader.readLine();
            if (answer.equals(agreement)) {
                return true;

            } else if (answer.equals(disagreement)) {
                return false;
            } else {
                System.out.println("Incorrect answer, enter yes or no again ");
                return positiveOrNegativeAnswerToTheQuestion();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static int choiceOfNumberOption(int... possibleAnswers) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer;
        try {
            answer = reader.readLine();
            for (int i = 0; i < possibleAnswers.length; i++) {
                if (Integer.parseInt(answer) == possibleAnswers[i]) {
                    return possibleAnswers[i];

                } else {
                    System.out.println("Incorrect answer, enter correct number ");
                    return choiceOfNumberOption(possibleAnswers);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static Order makingAnOrder() {
        boolean onTheNeedForATruck, onTheNeedForAPassengerCar;
        int volumeOrder;
        int weightOrder;
        int numberOfTypeProduct;
        TypeOfCargo typeOfCargo = null;
        int countPassengers;

        System.out.println("Do you need to transport the cargo: yes or no?");
        onTheNeedForATruck = positiveOrNegativeAnswerToTheQuestion();

        System.out.println("Do you have passengeres: yes or no?");
        onTheNeedForAPassengerCar = positiveOrNegativeAnswerToTheQuestion();

        if (!onTheNeedForAPassengerCar && !onTheNeedForATruck) {
            System.out.println("Сome another day");
            return null;
        }
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Enter starting point of order:");
        String startingPointOrder = scanner.nextLine();
        System.out.println("Enter destination of order:");
        String destinationOrder = scanner.nextLine();

        if (onTheNeedForATruck) {
            System.out.println("Enter the order volume in cubic meters:");
            volumeOrder = scanner.nextInt();
            System.out.println("Enter the order weight in kilograms:");
            weightOrder = scanner.nextInt();
            System.out.println("If you need to transport is manufactured goods ENTER 1, if perishable products ENTER 2, if liquids ENTER 3");
//            numberOfTypeProduct = scanner.nextInt();
            numberOfTypeProduct = choiceOfNumberOption(1,2,3);
            switch (numberOfTypeProduct) {
                case 1:
                    typeOfCargo = TypeOfCargo.MANUFACTURED_GOODS;
                    break;
                case 2:
                    typeOfCargo = TypeOfCargo.PERISHABLE_PRODUCTS;
                    break;
                case 3:
                    typeOfCargo = TypeOfCargo.LIQUIDS;
                    break;
            }

            if (onTheNeedForAPassengerCar) {
                System.out.println("Enter count passengers:");
                countPassengers = scanner.nextInt();
                return new Order(startingPointOrder, destinationOrder, volumeOrder, weightOrder, typeOfCargo, countPassengers);

            } else
                return new Order(startingPointOrder, destinationOrder, volumeOrder, weightOrder, typeOfCargo);
        } else {
            System.out.println("Enter count passengers:");
            countPassengers = scanner.nextInt();
            return new Order(startingPointOrder, destinationOrder, countPassengers);
        }

    }

    public static Vehicles checkingTheAvailabilityOfTheRightCar(Order order, List<CargoTransport> listOfAvailableVehiclesCapableOfTransportingGoods,
                                                                List<PassengerTransport> listOfAvailableVehiclesCapableOfTransportingPassengers,
                                                                List<CargoAndPassengerTransport> listOfAvailableVehiclesCapableOfTransportingGoodsAndPassengers) {
        if (order.getTypeOfCargo() != null) {
            if (order.getCountPassengers() == 0) {
                for (CargoTransport car : listOfAvailableVehiclesCapableOfTransportingGoods
                ) {

                    if (order.getTypeOfCargo() == TypeOfCargo.LIQUIDS) {
                        if (car.getBodyTypeOfCargoTransport().equals(BodyTypeOfCargoTransport.TANK) && car.getBodyVolume() >= order.getVolumeOrder() && car.getLoadCapacity() >= order.getWeightOrder()) {
                            return car;

                        }

                    } else if (order.getTypeOfCargo() == TypeOfCargo.PERISHABLE_PRODUCTS) {
                        if (car.getBodyTypeOfCargoTransport() == BodyTypeOfCargoTransport.REFRIGERATOR && car.getBodyVolume() >= order.getVolumeOrder() && car.getLoadCapacity() >= order.getWeightOrder()) {
                            return car;
                        }
                    } else if (order.getTypeOfCargo() == TypeOfCargo.MANUFACTURED_GOODS) {
                        if ((car.getBodyTypeOfCargoTransport() == BodyTypeOfCargoTransport.TENT_TYPE || car.getBodyTypeOfCargoTransport() == BodyTypeOfCargoTransport.REFRIGERATOR)
                                && car.getBodyVolume() >= order.getVolumeOrder() && car.getLoadCapacity() >= order.getWeightOrder()) {
                            return car;
                        }
                    }
                }
                for (CargoAndPassengerTransport car : listOfAvailableVehiclesCapableOfTransportingGoodsAndPassengers
                ) {

                    if (order.getTypeOfCargo() == TypeOfCargo.LIQUIDS) {
                        if (car.getBodyTypeOfCargoTransport() == BodyTypeOfCargoTransport.TANK &&
                                car.getBodyVolume() >= order.getVolumeOrder() && car.getLoadCapacity() >= order.getWeightOrder()) {
                            return car;
                        }

                    } else if (order.getTypeOfCargo() == TypeOfCargo.PERISHABLE_PRODUCTS) {
                        if (car.getBodyTypeOfCargoTransport() == BodyTypeOfCargoTransport.REFRIGERATOR && car.getBodyVolume() >= order.getVolumeOrder() && car.getLoadCapacity() >= order.getWeightOrder()) {
                            return car;
                        }
                    } else if (order.getTypeOfCargo() == TypeOfCargo.MANUFACTURED_GOODS) {
                        if ((car.getBodyTypeOfCargoTransport() == BodyTypeOfCargoTransport.TENT_TYPE || car.getBodyTypeOfCargoTransport() == BodyTypeOfCargoTransport.REFRIGERATOR)
                                && car.getBodyVolume() >= order.getVolumeOrder() && car.getLoadCapacity() >= order.getWeightOrder()) {
                            return car;
                        }
                    }
                }
                System.out.println("Sorry, we have not found a free car for your order, please contact us later");

            } else if (order.getCountPassengers() != 0) {
                for (CargoAndPassengerTransport car : listOfAvailableVehiclesCapableOfTransportingGoodsAndPassengers
                ) {
                    switch (order.getTypeOfCargo()) {
                        case LIQUIDS:
                            if (car.getBodyTypeOfCargoTransport() == BodyTypeOfCargoTransport.TANK &&
                                    car.getBodyVolume() >= order.getVolumeOrder() && car.getLoadCapacity() >= order.getWeightOrder()
                                    && car.getPassengerCapacity() >= order.getCountPassengers()) {
                                return car;
                            }
                        case PERISHABLE_PRODUCTS:
                            if (car.getBodyTypeOfCargoTransport() == BodyTypeOfCargoTransport.REFRIGERATOR && car.getBodyVolume() >= order.getVolumeOrder() && car.getLoadCapacity() >= order.getWeightOrder()
                                    && car.getPassengerCapacity() >= order.getCountPassengers()) {
                                return car;
                            }
                        case MANUFACTURED_GOODS:
                            if ((car.getBodyTypeOfCargoTransport() == BodyTypeOfCargoTransport.TENT_TYPE || car.getBodyTypeOfCargoTransport() == BodyTypeOfCargoTransport.REFRIGERATOR)
                                    && car.getBodyVolume() >= order.getVolumeOrder() && car.getLoadCapacity() >= order.getWeightOrder()
                                    && car.getPassengerCapacity() >= order.getCountPassengers()) {
                                return car;
                            }
                    }
                }
                System.out.println("Sorry, we have not found a free car for your order, please contact us later");
            }

        } else {
            for (PassengerTransport car : listOfAvailableVehiclesCapableOfTransportingPassengers
            ) {
                if (order.getCountPassengers() <= car.getPassengerCapacity()) {
                    return car;
                }
            }
            for (CargoAndPassengerTransport car : listOfAvailableVehiclesCapableOfTransportingGoodsAndPassengers
            ) {
                if (order.getCountPassengers() <= car.getPassengerCapacity()) {
                    return car;
                }
            }
        }
        return null;
    }

    public static int viewTheFreeLoadCapacity(Vehicles vehicle, Order order, List<Vehicles> listOfNotAvailableVehicles) {
        if (listOfNotAvailableVehicles.contains(vehicle)) {
            if (vehicle instanceof CargoTransport) {
                return (((CargoTransport) vehicle).getLoadCapacity() - order.getWeightOrder());
            } else if (vehicle instanceof CargoAndPassengerTransport) {
                return (((CargoAndPassengerTransport) vehicle).getLoadCapacity() - order.getWeightOrder());
            }
        } else {
            if (vehicle instanceof CargoTransport) {
                return (((CargoTransport) vehicle).getLoadCapacity());
            } else if (vehicle instanceof CargoAndPassengerTransport) {
                return (((CargoAndPassengerTransport) vehicle).getLoadCapacity());
            }
        }
        return 0;
    }

    public static int viewTheNumberOfFreePassengerSeats(Vehicles vehicle, Order order, List<Vehicles> listOfNotAvailableVehicles) {
        if (listOfNotAvailableVehicles.contains(vehicle)) {
            if (vehicle instanceof PassengerTransport) {
                return (((PassengerTransport) vehicle).getPassengerCapacity() - order.getCountPassengers());
            } else if (vehicle instanceof CargoAndPassengerTransport) {
                return (((CargoAndPassengerTransport) vehicle).getPassengerCapacity() - order.getCountPassengers());
            }
        } else {
            if (vehicle instanceof PassengerTransport) {
                return (((PassengerTransport) vehicle).getPassengerCapacity());
            } else if (vehicle instanceof CargoAndPassengerTransport) {
                return (((CargoAndPassengerTransport) vehicle).getPassengerCapacity());
            }
        }
        return 0;
    }

    public static int viewTheFreeValue(Vehicles vehicle, Order order, List<Vehicles> listOfNotAvailableVehicles) {
        if (listOfNotAvailableVehicles.contains(vehicle)) {
            if (vehicle instanceof CargoTransport) {
                return (((CargoTransport) vehicle).getBodyVolume() - order.getVolumeOrder());
            } else if (vehicle instanceof CargoAndPassengerTransport) {
                return (((CargoAndPassengerTransport) vehicle).getBodyVolume() - order.getVolumeOrder());
            }
        } else {
            if (vehicle instanceof CargoTransport) {
                return (((CargoTransport) vehicle).getBodyVolume());
            } else if (vehicle instanceof CargoAndPassengerTransport) {
                return (((CargoAndPassengerTransport) vehicle).getBodyVolume());
            }
        }
        return 0;
    }

    public static void printInformationAboutCurrentOrder(Order order, Vehicles vehicle) {
        System.out.println("Current order information: \n" + "Start point order: "
                + order.getStartingPointOrder() + "\n Destination: " + order.getDestinationOrder());

        if (vehicle instanceof CargoTransport) {
            System.out.println("Volume order: " + order.getVolumeOrder());
            System.out.println("Weight order: " + order.getWeightOrder());
        } else if (vehicle instanceof PassengerTransport) {
            System.out.println("Count passengers: " + order.getCountPassengers());
        } else if (vehicle instanceof CargoAndPassengerTransport) {
            System.out.println("Volume order: " + order.getVolumeOrder());
            System.out.println("Weight order: " + order.getWeightOrder());
            System.out.println("Count passengers: " + order.getCountPassengers());
        }
    }
}
