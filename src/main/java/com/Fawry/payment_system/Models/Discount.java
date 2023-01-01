package com.Fawry.payment_system.Models;

import javax.persistence.*;

@Table(name = "discounts")
@Entity
public class Discount {
    @SequenceGenerator(
            sequenceName = "discount_id_gen",
            name = "discount_id_gen",
            initialValue = 1,
            allocationSize = 1)
            @GeneratedValue(generator = "discount_id_gen",
                            strategy = GenerationType.SEQUENCE)
    @Id
    private Integer discountId;
    private String discountType;
    private int discountAmount;

    public Discount(Integer discountId, String discountType, int discountAmount) {
        this.discountId = discountId;
        this.discountType = discountType;
        this.discountAmount = discountAmount;
    }

    public Discount(String discountType, int discountAmount) {
        this.discountType = discountType;
        this.discountAmount = discountAmount;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }
}
