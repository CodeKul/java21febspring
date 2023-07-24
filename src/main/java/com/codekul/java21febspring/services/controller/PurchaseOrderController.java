package com.codekul.java21febspring.services.controller;

import com.codekul.java21febspring.services.entity.PurchaseOrder;
import com.codekul.java21febspring.services.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping("savePo")
    public ResponseEntity<?> savePo(@RequestBody PurchaseOrder purchaseOrder){
        return purchaseOrderService.savePo(purchaseOrder);
    }
}
