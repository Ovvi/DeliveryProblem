import java.util.GregorianCalendar;


public class Main {


    public static void main(String[] args) {

        PackageManagement packageManagement = new PackageManagement();
        GregorianCalendar dateToDeliver = new GregorianCalendar(2017,3,24);

        packageManagement.addPackage(new Package("Constanta", 800, 55, new GregorianCalendar(2017, 3, 24)));
        packageManagement.addPackage(new Package("Constanta", 800, 102, new GregorianCalendar(2017, 3, 24)));
        packageManagement.addPackage(new Package("Iasi", 500, 20, new GregorianCalendar(2017, 6, 18)));
        packageManagement.addPackage(new Package("Iasi", 500, 30, new GregorianCalendar(2017, 1, 16)));
        packageManagement.addPackage(new Package("Iasi", 500, 26, new GregorianCalendar(2017, 3, 24)));
        packageManagement.addPackage(new Package("Iasi", 500, 6, new GregorianCalendar(2017, 3, 20)));
        packageManagement.addPackage(new Package("Bucuresti", 650, 55, new GregorianCalendar(2017, 1, 15)));
        packageManagement.addPackage(new Package("Bucuresti", 650, 37, new GregorianCalendar(2017, 3, 24)));
        packageManagement.addPackage(new Package("Bucuresti", 650, 25, new GregorianCalendar(2017, 5, 9)));
        packageManagement.addPackage(new Package("Bucuresti", 650, 22, new GregorianCalendar(2017, 3, 24)));
        packageManagement.addPackage(new Package("Brasov", 300, 10, new GregorianCalendar(2017, 4, 12)));
        packageManagement.addPackage(new Package("Brasov", 300, 20, new GregorianCalendar(2017, 5, 6)));
        packageManagement.addPackage(new Package("Brasov", 300, 32, new GregorianCalendar(2017, 3, 24)));
        packageManagement.addPackage(new Package("Brasov", 300, 44, new GregorianCalendar(2017, 3, 24)));
        packageManagement.addPackage(new Package("Oradea", 220, 71, new GregorianCalendar(2017, 1, 2)));
        packageManagement.addPackage(new Package("Oradea", 220, 32, new GregorianCalendar(2017, 3, 24)));
        packageManagement.addPackage(new Package("Oradea", 220, 86, new GregorianCalendar(2017, 4, 20)));
        packageManagement.addPackage(new Package("Oradea", 220, 8, new GregorianCalendar(2017, 3, 24)));

        Delivery delivery = new Delivery(packageManagement,dateToDeliver);


        if (!packageManagement.getPackages().isEmpty()){
            if (!(packageManagement.getPackages().get(dateToDeliver) == null)){
                for (int i = 0; i < packageManagement.getPackages().get(dateToDeliver).size(); i++) {
                    DeliveryThread deliveryThread = new DeliveryThread(delivery);
                    deliveryThread.start();
                }
            }else{
                System.out.println("No Packages to deliver in this date.");
            }
        }else{
            System.out.println("No packages to deliver.");
        }



    }
}
