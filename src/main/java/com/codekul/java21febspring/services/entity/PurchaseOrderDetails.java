package com.codekul.java21febspring.services.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "purchase_order_details")
public class PurchaseOrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;

    @NotNull(message = "Quantity can not be null")
    @Min(value = 1, message = "Minimum 1 quantity expected")
    private Integer quantity;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private Double rate;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private Double amount;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private Double netAmount;

    @DecimalMax(value = "100.00", message = "discount percent cannot be more than 100")
    private Double discountPercentage;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private Double discountAmount;

    @DecimalMax(value = "100.00", message = "discount percent cannot be more than 100")
    private Double gstPercentage;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private Double gstAmount;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private Double mrp;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_order_id")
    @JsonBackReference
    private PurchaseOrder purchaseOrder;
}
