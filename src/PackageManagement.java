import java.util.*;


public class PackageManagement {

    private TreeMap<Calendar, TreeMap<String,LinkedList<Package>>> packages = new TreeMap<>();

    public  TreeMap<Calendar, TreeMap<String,LinkedList<Package>>> addPackage(Package onePackage){
        TreeMap<String, LinkedList<Package>> dailyList = new TreeMap<>();
        LinkedList<Package> dailyByLocation = new LinkedList<>();

        if (packages.containsKey(onePackage.getDeliveryDate())){
            dailyList = packages.get(onePackage.getDeliveryDate());

            if (dailyList.containsKey(onePackage.getTargetLocation())){
                dailyByLocation = dailyList.get(onePackage.getTargetLocation());
                dailyByLocation.add(onePackage);
                dailyList.put(onePackage.getTargetLocation(),dailyByLocation);
            }else{
                dailyByLocation.add(onePackage);
                dailyList.put(onePackage.getTargetLocation(),dailyByLocation);
            }
            packages.put(onePackage.getDeliveryDate(),dailyList);
        }else{
            dailyByLocation.add(onePackage);
            dailyList.put(onePackage.getTargetLocation(),dailyByLocation);
            packages.put(onePackage.getDeliveryDate(),dailyList);
        }
        return packages;
    }


    public synchronized LinkedList<Package> deliverByDate(GregorianCalendar date){
        LinkedList<Package> packagesReadyToDeliver = new LinkedList<>();
        TreeMap<String,LinkedList<Package>> listByDate;
        if (!packages.isEmpty()){
            listByDate = packages.get(date);
            packagesReadyToDeliver = listByDate.pollFirstEntry().getValue();
        }else{
            System.out.println("0 packages to deliver");
        }
        return packagesReadyToDeliver;
    }


    public TreeMap<Calendar, TreeMap<String, LinkedList<Package>>> getPackages() {
        return packages;
    }
}
