package com.lukaszjakobczak.roompccupancymanager.infrastructure.endpoint;

import com.lukaszjakobczak.roompccupancymanager.application.OrdersDto;
import com.lukaszjakobczak.roompccupancymanager.application.RoomOccupancyManagerApplicationFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms/optimize")
public class RoomOccupancyManagerController {

    private final RoomOccupancyManagerApplicationFacade roomOccupancyManagerApplicationFacade;

    public RoomOccupancyManagerController(RoomOccupancyManagerApplicationFacade roomOccupancyManagerApplicationFacade) {
        this.roomOccupancyManagerApplicationFacade = roomOccupancyManagerApplicationFacade;
    }

    @PostMapping
    ResponseEntity<RoomOccupancyRestDto> optimize(@RequestBody OrdersRestDto ordersRestDto) {
        return ResponseEntity.ok(
                RoomOccupancyRestDto.fromDto(
                        roomOccupancyManagerApplicationFacade.optimize(mapToDto(ordersRestDto))
                )
        );
    }

    private OrdersDto mapToDto(OrdersRestDto ordersRestDto) {
        return new OrdersDto(ordersRestDto.getOrders(), ordersRestDto.getFreeEconomyRooms(), ordersRestDto.getFreePremiumRooms());
    }
}
