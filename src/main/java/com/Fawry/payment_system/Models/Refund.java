package com.Fawry.payment_system.Models;
import javax.persistence.*;

@Table(name = "refunds")
@Entity
public class Refund {
    @SequenceGenerator(
            sequenceName = "discount_id_gen",
            name = "discount_id_gen",
            initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(generator = "discount_id_gen",
            strategy = GenerationType.SEQUENCE)
    @Id
    private Integer discountId;
    private Integer transactionId;
    private String date;

    public Refund(Integer discountId, Integer transactionId, String date) {
        this.discountId = discountId;
        this.transactionId = transactionId;
        this.date = date;
    }

    public Refund(Integer transactionId, String date) {
        this.transactionId = transactionId;
        this.date = date;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
