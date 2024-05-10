//FUTURA IMPLEMENTACION

//package com.munievents.munievents.controller;
//
//import com.munievents.munievents.entity.Event;
//import com.munievents.munievents.entity.Purchase;
//import com.munievents.munievents.service.PurchaseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping(path = "/api/v1")
//@CrossOrigin(origins = {"http://localhost:5173","http://localhost:8080"})
//public class PurchaseController {
//    @Autowired
//    private final PurchaseService  purchaseService;
//
//    public PurchaseController(PurchaseService purchaseService) {
//        this.purchaseService = purchaseService;
//    }
//
//    //TODO: obtenemos todas las compras
//    @GetMapping("/purchase")
//    public List<Purchase> getAll() {
//        return purchaseService.getAllPurchase();
//    }
//
//    //TODO: obtenemos una compra por su id
//    @GetMapping("/purchase/{idPurchase}")
//    public Optional<Purchase> getById(@PathVariable("idPurchase") int purchaseId) {
//        return purchaseService.getPurchaseById(purchaseId);
//    }
//
//
//    //TODO: enviamos el body una nueva compra
//    @PostMapping("/purchase")
//    public String saveEvent(@RequestBody Purchase purchase) {
//        purchaseService.saveOrUpdate(purchase);
//        return "Compra creada correctamente";
//    }
//
//    //TODO: actualizamos una compra por su id
//    @PutMapping("/purchase/{id}")
//    public String saveUpdateEvent(@PathVariable("id") int purchaseId, @RequestBody Purchase purchase) {
//
//        String message = "";
//        try {
//            if (purchaseService.getPurchaseById(purchaseId).isPresent()) {
//                purchaseService.saveOrUpdate(purchase);
//                message = "Compra actualizado correctamente";
//            } else {
//                message = "Compra no existe";
//            }
//        } catch (Exception ex) {
//            message = ex.getMessage();
//        }
//        return message;
//    }
//
//
//    //TODO: enviamos como parametros el id de la compra
//    @DeleteMapping("/purchase/{id}")
//    public String delete(@PathVariable("id") int purchaseId) {
//        purchaseService.delete(purchaseId);
//        return "Compra eliminada correctamente";
//    }
//
//
//}
