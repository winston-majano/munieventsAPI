package com.munievents.munievents.service;



import com.munievents.munievents.entity.Purchase;
import com.munievents.munievents.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository  purchaseRepository;

    //TODO: retornamos todos las compras
    public List<Purchase> getAllPurchase() {
        return purchaseRepository.findAll();
    }

    //TODO: buscamos una compra por su id
    public Optional<Purchase> getPurchaseById(int id) {
        return purchaseRepository.findById(id);
    }

    //TODO:guarda o actualiza la compra
    @PostMapping
    public void saveOrUpdate(@RequestBody Purchase purchase) {
        purchaseRepository.save(purchase);
    }


    //TODO: elimina una compra por su id
    public void delete(int id) {
        purchaseRepository.deleteById(id);
    }

}
