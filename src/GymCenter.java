public class GymCenter {
    private String locationId;
    private String detailedAddress;
    private int maxCap;

    public GymCenter(String locationId, String detailedAddress, int maxCap) {
        this.locationId = locationId;
        this.detailedAddress = detailedAddress;
        this.maxCap = maxCap;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public int getMaxCap() {
        return maxCap;
    }

    public void setMaxCap(int maxCap) {
        this.maxCap = maxCap;
    }
}
