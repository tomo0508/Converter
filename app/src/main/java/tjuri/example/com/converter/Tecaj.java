package tjuri.example.com.converter;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tecaj {

    @SerializedName("selling_rate")
    @Expose
    private String sellingRate;
    @SerializedName("median_rate")
    @Expose
    private String medianRate;
    @SerializedName("unit_value")
    @Expose
    private Integer unitValue;
    @SerializedName("buying_rate")
    @Expose
    private String buyingRate;
    @SerializedName("currency_code")
    @Expose
    private String currencyCode;

    public String getSellingRate() {
        return sellingRate;
    }

    public void setSellingRate(String sellingRate) {
        this.sellingRate = sellingRate;
    }

    public String getMedianRate() {
        return medianRate;
    }

    public void setMedianRate(String medianRate) {
        this.medianRate = medianRate;
    }

    public Integer getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Integer unitValue) {
        this.unitValue = unitValue;
    }

    public String getBuyingRate() {
        return buyingRate;
    }

    public void setBuyingRate(String buyingRate) {
        this.buyingRate = buyingRate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}