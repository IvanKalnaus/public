package Park;


public class Order {
    private String startingPointOrder;
    private String destinationOrder;
    private int volumeOrder;
    private int weightOrder;
    private TypeOfCargo typeOfCargo;
    private int countPassengers = 0;


    public Order(String startingPointOrder, String destinationOrder, int volumeOrder, int weightOrder, TypeOfCargo typeOfCargo) {
        this.startingPointOrder = startingPointOrder;
        this.destinationOrder = destinationOrder;
        this.volumeOrder = volumeOrder;
        this.weightOrder = weightOrder;
        this.typeOfCargo = typeOfCargo;

    }

    public Order(String startingPointOrder, String destinationOrder, int countPassengers) {
        this.startingPointOrder = startingPointOrder;
        this.destinationOrder = destinationOrder;
        this.countPassengers = countPassengers;

    }

    public Order(String startingPointOrder, String destinationOrder, int volumeOrder, int weightOrder, TypeOfCargo typeOfCargo, int countPassengers) {
        this.startingPointOrder = startingPointOrder;
        this.destinationOrder = destinationOrder;
        this.volumeOrder = volumeOrder;
        this.weightOrder = weightOrder;
        this.typeOfCargo = typeOfCargo;
        this.countPassengers = countPassengers;

    }

    public String getStartingPointOrder() {
        return startingPointOrder;
    }

    public String getDestinationOrder() {
        return destinationOrder;
    }

    public int getVolumeOrder() {
        return volumeOrder;
    }

    public int getWeightOrder() {
        return weightOrder;
    }

    public TypeOfCargo getTypeOfCargo() {
        return typeOfCargo;
    }

    public int getCountPassengers() {
        return countPassengers;
    }
}



