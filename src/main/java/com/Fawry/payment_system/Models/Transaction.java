package com.Fawry.payment_system.Models;

import com.Fawry.payment_system.enums.TransactionStatus;
import com.Fawry.payment_system.enums.TransactionType;
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
    private TransactionStatus transactionStatus;
    @Column(columnDefinition = "varchar(55)")
    private TransactionType transactionType;

    public Transaction(int transactionId,
                       Integer senderId,
                       Integer receiverId,
                       TransactionStatus transactionStatus,
                       TransactionType transactionType,
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
                       TransactionStatus transactionStatus,
                       TransactionType transactionType) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.transactionStatus = transactionStatus;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    public TransactionStatus getTransactionStatus() {
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

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
