package com.codekul.java21febspring.services.service;

import com.codekul.java21febspring.services.entity.PurchaseOrder;
import org.springframework.http.ResponseEntity;

public interface PurchaseOrderService {

    ResponseEntity<?> savePo(PurchaseOrder purchaseOrder);
}
