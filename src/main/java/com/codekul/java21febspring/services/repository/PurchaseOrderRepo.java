package com.codekul.java21febspring.services.repository;

import com.codekul.java21febspring.services.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder,Long> {
}
