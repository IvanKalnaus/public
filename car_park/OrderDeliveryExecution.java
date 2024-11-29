package Park;

interface OrderDeliveryExecution {
    void loadingTheOrderIntoTheCar(String placeOfLoading, Vehicles vehicle);

    void deliveryOrder();

    void unloadingTheOrderIntoTheCar(String destination, Vehicles vehicle);

}



