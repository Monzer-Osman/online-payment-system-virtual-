package com.Fawry.payment_system.Models;

import com.Fawry.payment_system.enums.TransactionStatus;

import javax.persistence.*;

@Table(name = "transactions")
@Entity
public class Transaction {
    @Id
    @SequenceGenerator(
            name = "transaction_id_generator",
            sequenceName = "transaction_id_generator",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_id_generator"
    )
    private int transactionId;
    private Integer senderId;
    private Integer receiverId;
    private int transactionAmount;
    @Column(columnDefinition = "varchar(55)")
    private String transactionStatus;
    @Column(columnDefinition = "varchar(55)")
    private java.lang.String transactionType;

    public Transaction(int transactionId,
                       Integer senderId,
                       Integer receiverId,
                       String transactionStatus,
                       String transactionType,
                       int transactionAmount) {
        this.transactionId = transactionId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.transactionStatus = transactionStatus;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }
    public Transaction(Integer senderId,
                       Integer receiverId,
                       int transactionAmount,
                       String transactionStatus,
                       String transactionType) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.transactionStatus = transactionStatus;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public java.lang.String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(java.lang.String transactionType) {
        this.transactionType = transactionType;
    }
}
