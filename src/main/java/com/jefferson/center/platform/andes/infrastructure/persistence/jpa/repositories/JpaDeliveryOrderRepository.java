package com.jefferson.center.platform.andes.infrastructure.persistence.jpa.repositories;

import com.jefferson.center.platform.andes.infrastructure.entities.DeliveryOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDeliveryOrderRepository extends JpaRepository<DeliveryOrderEntity, Long> {
    boolean existsByDeliveryCode(com.jefferson.center.platform.andes.domain.model.valueobjects.DeliveryCode deliveryCode);
}
