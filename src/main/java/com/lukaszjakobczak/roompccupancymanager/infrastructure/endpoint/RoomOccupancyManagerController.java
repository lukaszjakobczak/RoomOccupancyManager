package com.lukaszjakobczak.roompccupancymanager.infrastructure.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms/optimize")
public class RoomOccupancyManagerController {

    @PostMapping
    ResponseEntity<Void> optimize(@RequestBody OrdersDto ordersDto) {
        return ResponseEntity.noContent().build();
    }
}
