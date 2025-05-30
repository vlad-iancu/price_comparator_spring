package com.example.price_comparator.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductStoreId implements Serializable {

    @Column(name = "product_id")
    private Long product;

    @Column(name = "store_id")
    private Long store;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public ProductStoreId() {
    }

    public ProductStoreId(Long product, Long store, LocalDate updatedAt) {
        this.product = product;
        this.store = store;
        this.updatedAt = updatedAt;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Long getStore() {
        return store;
    }

    public void setStore(Long store) {
        this.store = store;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    // equals and hashCode based on product and store
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductStoreId)) {
            return false;
        }
        ProductStoreId that = (ProductStoreId) o;
        return Objects.equals(product, that.product)
                && Objects.equals(store, that.store)
                && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, store);
    }
}
