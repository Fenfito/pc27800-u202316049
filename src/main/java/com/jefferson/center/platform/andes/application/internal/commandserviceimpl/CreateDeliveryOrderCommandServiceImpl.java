package com.jefferson.center.platform.andes.application.internal.commandserviceimpl;

import com.jefferson.center.platform.andes.application.commands.CreateDeliveryOrderCommand;
import com.jefferson.center.platform.andes.application.commandservices.CreateDeliveryOrderCommandService;
import com.jefferson.center.platform.andes.domain.model.aggregates.DeliveryOrder;
import com.jefferson.center.platform.andes.domain.model.valueobjects.*;
import com.jefferson.center.platform.andes.domain.repositories.DeliveryOrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateDeliveryOrderCommandServiceImpl implements CreateDeliveryOrderCommandService {
    private final DeliveryOrderRepository deliveryOrderRepository;

    public CreateDeliveryOrderCommandServiceImpl(DeliveryOrderRepository deliveryOrderRepository) {
        this.deliveryOrderRepository = deliveryOrderRepository;
    }

    @Override
    public Optional<DeliveryOrder> handle(CreateDeliveryOrderCommand command) {
        if (command == null) {
            throw new IllegalArgumentException("Create delivery order command is required");
        }

        DeliveryCode deliveryCode = new DeliveryCode(command.deliveryCode());
        if (deliveryOrderRepository.existsByDeliveryCode(deliveryCode.deliveryCode())) {
            throw new IllegalArgumentException("A delivery order with the same deliveryCode already exists");
        }

        DeliveryStatus status = command.deliveryStatus() == null || command.deliveryStatus().isBlank()
                ? DeliveryStatus.PENDING
                : DeliveryStatus.valueOf(command.deliveryStatus().trim().toUpperCase());

        DeliveryOrder deliveryOrder = new DeliveryOrder(
                deliveryCode,
                new WarehouseId(command.warehouseId()),
                new DeliveryWindow(command.deliveryWindowStartDate(), command.deliveryWindowEndDate()),
                new PackageLoad(command.packageLoadQuantity(), command.packageLoadUnit()),
                status,
                command.priorityLevel(),
                command.deliveryNotes()
        );

        return Optional.of(deliveryOrderRepository.save(deliveryOrder));
    }
}
