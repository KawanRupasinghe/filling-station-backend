package com.lioc.backend.controller;

import com.lioc.backend.model.Sales;
import com.lioc.backend.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TO HANDLE CRUD OPERATION
@RestController// indicates that this is a rest controller
@RequestMapping("/sales")//maps urls to this controller
@CrossOrigin//allow the API  to run in differant origins
public class SalesController {

    private SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sales>> getAllSales() {
        return ResponseEntity.ok(salesService.getAll());//fetches a list of all sales records
    }

    @GetMapping("/search/{salesId}")//search specified sales by its id 
    public ResponseEntity<Sales> searchSales(@PathVariable int salesId) {
        return ResponseEntity.ok(salesService.searchSales(salesId));
    }

    @PostMapping("/add")//adding new sales records
    public ResponseEntity<String> addSales(@RequestBody Sales sales) {
        return ResponseEntity.ok(salesService.addSales(sales));
    }

    @PutMapping("/update/{salesId}")// updating a sales record
    public ResponseEntity<String> updateSales(@RequestBody Sales sales, @PathVariable int salesId) {
        return ResponseEntity.ok(salesService.updateSales(sales, salesId));
    }

    @DeleteMapping("/delete/{salesId}")//delete the sales by identifying relavant id
    public ResponseEntity<String> deleteSales(@PathVariable int salesId) {
        return ResponseEntity.ok(salesService.deleteSales(salesId));
    }
}
