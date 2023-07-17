package com.codekul.java21febspring.services.service;

import com.codekul.java21febspring.services.entity.PurchaseOrder;
import com.codekul.java21febspring.services.entity.PurchaseOrderDetails;
import com.codekul.java21febspring.services.repository.PurchaseOrderDetailsRepo;
import com.codekul.java21febspring.services.repository.PurchaseOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class PurchaseOrderImpl implements PurchaseOrderService{

    @Autowired
    private PurchaseOrderRepo purchaseOrderRepo;

    @Autowired
    private PurchaseOrderDetailsRepo purchaseOrderDetailsRepo;
    @Override
    public ResponseEntity<?> savePo(PurchaseOrder purchaseOrder) {

        var ttlGst = new AtomicReference<>(0.0);
        var ttlDis = new AtomicReference<>(0.0);
        purchaseOrder.getPurchaseOrderDetails().forEach(s->{
           ttlGst.set(ttlGst.get() + s.getGstAmount());
           ttlDis.set(ttlDis.get()+s.getDiscountAmount());
        });

        var purchaseOrder1 = new PurchaseOrder();
        purchaseOrder1.setTotalGstAmount(ttlGst.get());
        purchaseOrder1.setTotalDiscountAmount(ttlDis.get());

        purchaseOrderRepo.save(purchaseOrder1);

        var details = new PurchaseOrderDetails();
        details.setPurchaseOrder(purchaseOrder1);
        purchaseOrderDetailsRepo.save(details);


       purchaseOrderRepo.save(purchaseOrder);
       return ResponseEntity.ok("Purchase Order saved");
    }
}
