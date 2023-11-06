/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javax.swing.ImageIcon;

/**
 *
 * @author Rushabh
 */
public class Supplier {
    
    private String supplyName;
    private ProductCatalog productCatalog;
    private ImageIcon logoImage;
    private SupplierProfile profile;
    
    public ImageIcon getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(ImageIcon logoImage) {
        this.logoImage = logoImage;
    }
    
    public Supplier() {
        productCatalog = new ProductCatalog();
        profile = new SupplierProfile(); 
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public SupplierProfile getProfile() {
        return profile;
    }

    public void setProfile(SupplierProfile profile) {
        this.profile = profile;
    }
    
    public class SupplierProfile {

        private String name;
        private long contactInformation;
        private String description;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getContactInformation() {
            return contactInformation;
        }

        public void setContactInformation(long contactInformation) {
            this.contactInformation = contactInformation;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
     }
    
    @Override
    public String toString() {
        return supplyName;
    }
    
}
