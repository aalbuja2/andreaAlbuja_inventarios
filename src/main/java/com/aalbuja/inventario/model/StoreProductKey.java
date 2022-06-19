package com.aalbuja.inventario.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StoreProductKey implements Serializable {

    @Column(name = "producto_id")
    private Integer productId;

    @Column(name = "tienda_id")
    private Integer storeId;

    public StoreProductKey() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}
