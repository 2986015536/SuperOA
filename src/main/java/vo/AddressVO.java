package vo;

public class AddressVO {
    private Integer add;
    private Integer addressId;
    private String addressCode;
    private String addressName;
    private String addressParentCode;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressParentCode() {
        return addressParentCode;
    }

    public void setAddressParentCode(String addressParentCode) {
        this.addressParentCode = addressParentCode;
    }
}
