package pallav.pharmeasy.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

@Table
public class Medicine extends SugarRecord {

    private String form;
    private String name;
    private String manufacturer;
    private long uip;
    private long mfId;
    private String imgUrl;
    private boolean available;
    private long su;
    private long medicine_id;
    private String generics;
    private double uPrice;
    private long hkpDrugCode;
    private String label;
    private String packForm;
    private String packSizeLabel;
    private double mrp;
    private String packSize;
    private double discountPerc;
    private String type;
    private String slug;
    private double oPrice;
    private String productsForBrand;
    private String pForm;
    private String mappedPForm;


    public String getProductsForBrand() {
        return productsForBrand;
    }

    public void setProductsForBrand(String productsForBrand) {
        this.productsForBrand = productsForBrand;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public long getUip() {
        return uip;
    }

    public void setUip(long uip) {
        this.uip = uip;
    }

    public long getMfId() {
        return mfId;
    }

    public void setMfId(long mfId) {
        this.mfId = mfId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public long getSu() {
        return su;
    }

    public void setSu(long su) {
        this.su = su;
    }

    public long getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(long id) {
        this.medicine_id = id;
    }

    public String getGenerics() {
        return generics;
    }

    public void setGenerics(String generics) {
        this.generics = generics;
    }

    public double getuPrice() {
        return uPrice;
    }

    public void setuPrice(double uPrice) {
        this.uPrice = uPrice;
    }

    public long getHkpDrugCode() {
        return hkpDrugCode;
    }

    public void setHkpDrugCode(long hkpDrugCode) {
        this.hkpDrugCode = hkpDrugCode;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPackForm() {
        return packForm;
    }

    public void setPackForm(String packForm) {
        this.packForm = packForm;
    }

    public String getPackSizeLabel() {
        return packSizeLabel;
    }

    public void setPackSizeLabel(String packSizeLabel) {
        this.packSizeLabel = packSizeLabel;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public String getPackSize() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    public double getDiscountPerc() {
        return discountPerc;
    }

    public void setDiscountPerc(double discountPerc) {
        this.discountPerc = discountPerc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public double getoPrice() {
        return oPrice;
    }

    public void setoPrice(double oPrice) {
        this.oPrice = oPrice;
    }

    public String getpForm() {
        return pForm;
    }

    public void setpForm(String pForm) {
        this.pForm = pForm;
    }

    public String getMappedPForm() {
        return mappedPForm;
    }

    public void setMappedPForm(String mappedPForm) {
        this.mappedPForm = mappedPForm;
    }



    public Medicine() {
    }

    public Medicine(String name, long medicine_id) {
        this.name = name;
        this.medicine_id = medicine_id;
    }
}
