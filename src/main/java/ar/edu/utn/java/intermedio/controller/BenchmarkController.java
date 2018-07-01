package ar.edu.utn.java.intermedio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.java.intermedio.domain.BenchmarkResponse;
import ar.edu.utn.java.intermedio.domain.Response;
import ar.edu.utn.java.intermedio.exception.CantidadItemsException;
import ar.edu.utn.java.intermedio.service.BenchmarkService;

@RestController
public class BenchmarkController {

    @Autowired
    private BenchmarkService service;

    @RequestMapping("/imprimir")
    public ResponseEntity<Response> imprimir(@RequestParam(value="cantidad_items") Integer cantidadItems) {
        
    	BenchmarkResponse responseOperation = new BenchmarkResponse();
    	try {
    		responseOperation = service.imprimir(cantidadItems);
    	} catch(CantidadItemsException e) {
    		e.printStackTrace();
    		Response response = new Response();
    		response.setResponseCode(400);
    		response.setResponseMessage(e.getMessage());
    		return ResponseEntity.badRequest().body(response);
    	}
    	responseOperation.setResponseMessage("Operacion finalizada");
    	return ResponseEntity.ok(responseOperation);
    }
    
    @RequestMapping("/sumar")
    public ResponseEntity<Response> sumar(@RequestParam(value="cantidad_items") Integer cantidadItems) {
        
    	BenchmarkResponse responseOperation = new BenchmarkResponse();
    	try {
    		responseOperation = service.sumar(cantidadItems);
    	} catch(CantidadItemsException e) {
    		e.printStackTrace();
    		Response response = new Response();
    		response.setResponseCode(400);
    		response.setResponseMessage(e.getMessage());
    		return ResponseEntity.badRequest().body(response);
    	}
    	responseOperation.setResponseMessage("Operacion finalizada");
    	return ResponseEntity.ok(responseOperation);
    }
    
    @RequestMapping("/maximo")
    public ResponseEntity<Response> maximo(@RequestParam(value="cantidad_items") Integer cantidadItems) {
        
    	BenchmarkResponse responseOperation = new BenchmarkResponse();
    	try {
    		responseOperation = service.maximo(cantidadItems);
    	} catch(CantidadItemsException e) {
    		e.printStackTrace();
    		Response response = new Response();
    		response.setResponseCode(400);
    		response.setResponseMessage(e.getMessage());
    		return ResponseEntity.badRequest().body(response);
    	}
    	responseOperation.setResponseMessage("Operacion finalizada");
    	return ResponseEntity.ok(responseOperation);
    }
    
    
}
