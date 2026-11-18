package com.jefferson.center.platform.andes.domain.repositories;

import com.jefferson.center.platform.andes.domain.model.aggregates.DeliveryOrder;

import java.util.Optional;

public interface DeliveryOrderRepository {
    boolean existsByDeliveryCode(String deliveryCode);
    DeliveryOrder save(DeliveryOrder deliveryOrder);
    Optional<DeliveryOrder> findById(Long id);
}
