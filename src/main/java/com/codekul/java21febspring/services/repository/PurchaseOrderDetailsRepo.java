package com.codekul.java21febspring.services.repository;

import com.codekul.java21febspring.services.entity.PurchaseOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderDetailsRepo extends JpaRepository<PurchaseOrderDetails,Long> {
}
