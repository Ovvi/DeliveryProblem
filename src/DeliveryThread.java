import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DeliveryThread extends Thread {

    private Delivery delivery;
    private LinkedList<Package> packages;
    private PackageManagement packageManagement;
    private GregorianCalendar date;


    public DeliveryThread(Delivery delivery) {
        this.delivery = delivery;
        packageManagement = delivery.getPackageManagement();
        date = delivery.getDate();
    }


    @Override
    public void run() {
        delivery = new Delivery(packageManagement, date);

        System.out.println("Packet was received for delivery");
        packages = packageManagement.deliverByDate(date);

        delivery.setDeliveryInformation(packages);

        try {
            Thread.sleep(delivery.getTimeToDeliver());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        delivery.printInformation();
    }
}
