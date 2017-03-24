import java.util.GregorianCalendar;


public class Package {

    private String targetLocation;
    private int distanceToTarget;
    private int merchandiseValue;
    private GregorianCalendar deliveryDate;

    public Package(String targetLocation, int distanceToTarget, int merchandiseValue, GregorianCalendar deliveryDate) {
        this.targetLocation = targetLocation;
        this.distanceToTarget = distanceToTarget;
        this.merchandiseValue = merchandiseValue;
        this.deliveryDate = deliveryDate;
    }

    public String getTargetLocation() {
        return targetLocation;
    }

    public int getDistanceToTarget() {
        return distanceToTarget;
    }

    public int getMerchandiseValue() {
        return merchandiseValue;
    }

    public GregorianCalendar getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String toString() {
        return "Package{" +
                "targetLocation='" + targetLocation + '\'' +
                ", distanceToTarget=" + distanceToTarget +
                ", merchandiseValue=" + merchandiseValue +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
