package com.codekul.java21febspring.services.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "PO number can not be null")
    private String poNumber;

    private LocalDate poDate = LocalDate.now();

    @NotNull(message = "PO type can not be null")
    private String poType;

    private LocalDate deliveryDate;

    private String guaranteeWarranty;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private Double otherCharges=0.0;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private Double totalDiscountAmount=0.0;
    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private Double totalGstAmount=0.0;
    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private Double totalAmount=0.0;
    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private Double totalNetAmount=0.0;

    @Column(columnDefinition = "Decimal(10,2) default '0.00'")
    private Double totalGrossAmount=0.0;

    private String schedule;

    private String remarks;

    private String closedReason;

    private LocalDateTime closedDateTime;

    private String cancelledReason;

    private LocalDateTime cancelledDateTime;

    @OneToMany(mappedBy = "purchaseOrder",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PurchaseOrderDetails> purchaseOrderDetails;

}
