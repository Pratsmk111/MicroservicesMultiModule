
package com.lcwd.hotel.HotelService.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lcwd.hotel.HotelService.Entity.Hotel;
import com.lcwd.hotel.HotelService.Services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService service;
	
	@PostMapping("/add")
	public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(hotel));
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Hotel>> getall(){
		return ResponseEntity.ok(service.getall());
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Hotel>> get(@PathVariable String id){
		return ResponseEntity.ok(service.get(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.ok("Hotel record deleted Succesfully");
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Hotel> update(@RequestBody Hotel hotel,@PathVariable String id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(hotel));
	}
}
