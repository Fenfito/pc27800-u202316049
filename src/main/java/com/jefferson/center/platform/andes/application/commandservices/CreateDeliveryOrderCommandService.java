package com.jefferson.center.platform.andes.application.commandservices;

import com.jefferson.center.platform.andes.application.commands.CreateDeliveryOrderCommand;
import com.jefferson.center.platform.andes.domain.model.aggregates.DeliveryOrder;

import java.util.Optional;

public interface CreateDeliveryOrderCommandService {
    Optional<DeliveryOrder> handle(CreateDeliveryOrderCommand command);
}
