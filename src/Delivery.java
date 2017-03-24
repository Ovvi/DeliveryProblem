import java.util.GregorianCalendar;
import java.util.LinkedList;


public class Delivery {

    private PackageManagement packageManagement;
    private int packagesValue;
    private int profitPerKm = 4;
    private int profit;
    private GregorianCalendar date;
    private String deliveryDestination;
    private int timeToDeliver;
    private int numberOfPackagesDelivered;

    public Delivery(PackageManagement packageManagement, GregorianCalendar date) {
        this.packageManagement = packageManagement;
        this.date = date;
    }

    public void setDeliveryInformation(LinkedList<Package> packages){
        for (Package onePackage :packages){
            deliveryDestination = onePackage.getTargetLocation();
            timeToDeliver = onePackage.getDistanceToTarget()* 20;
            packagesValue = packagesValue + onePackage.getMerchandiseValue();
            profit = profit + onePackage.getDistanceToTarget() * profitPerKm;
            numberOfPackagesDelivered++;
        }
    }

    public void printInformation(){
        System.out.println("Number of packages delivered to " + deliveryDestination + " = "
                + numberOfPackagesDelivered+"\n"+"Delivery profit = " + profit + " EURO" + "\n" + "Merchandise value = " + packagesValue
                + " EURO");

        System.out.println("-------------------------------------------------");
    }




    public int getPackagesValue() {
        return packagesValue;
    }

    public int getProfit() {
        return profit;
    }

    public String getDeliveryDestination() {
        return deliveryDestination;
    }

    public int getNumberOfPackagesDelivered() {
        return numberOfPackagesDelivered;
    }

    public int getTimeToDeliver() {
        return timeToDeliver;
    }

    public PackageManagement getPackageManagement() {
        return packageManagement;
    }

    public GregorianCalendar getDate() {
        return date;
    }
}

