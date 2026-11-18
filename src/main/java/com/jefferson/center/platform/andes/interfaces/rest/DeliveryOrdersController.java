package com.jefferson.center.platform.andes.interfaces.rest;

import com.jefferson.center.platform.andes.application.commands.CreateDeliveryOrderCommand;
import com.jefferson.center.platform.andes.application.commandservices.CreateDeliveryOrderCommandService;
import com.jefferson.center.platform.andes.domain.model.aggregates.DeliveryOrder;
import com.jefferson.center.platform.andes.interfaces.rest.resources.CreateDeliveryOrderResource;
import com.jefferson.center.platform.andes.interfaces.rest.resources.DeliveryOrderResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/delivery-orders")
public class DeliveryOrdersController {
    private final CreateDeliveryOrderCommandService createDeliveryOrderCommandService;

    public DeliveryOrdersController(CreateDeliveryOrderCommandService createDeliveryOrderCommandService) {
        this.createDeliveryOrderCommandService = createDeliveryOrderCommandService;
    }

    @PostMapping
    public ResponseEntity<DeliveryOrderResource> create(@RequestBody CreateDeliveryOrderResource resource) {
        CreateDeliveryOrderCommand command = new CreateDeliveryOrderCommand(
                resource.deliveryCode(),
                resource.warehouseId(),
                resource.deliveryWindowStartDate(),
                resource.deliveryWindowEndDate(),
                resource.packageLoadQuantity(),
                resource.packageLoadUnit(),
                resource.priorityLevel(),
                resource.deliveryStatus(),
                resource.deliveryNotes()
        );

        DeliveryOrder order = createDeliveryOrderCommandService.handle(command)
                .orElseThrow(() -> new IllegalArgumentException("Delivery order could not be created"));

        DeliveryOrderResource response = new DeliveryOrderResource(
                order.getId(),
                order.getDeliveryCode().deliveryCode(),
                order.getWarehouseId().warehouseId(),
                order.getDeliveryWindow().startDate(),
                order.getDeliveryWindow().endDate(),
                order.getPackageLoad().quantity(),
                order.getPackageLoad().unit(),
                order.getPriorityLevel(),
                order.getDeliveryStatus().name(),
                order.getDeliveryNotes(),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
