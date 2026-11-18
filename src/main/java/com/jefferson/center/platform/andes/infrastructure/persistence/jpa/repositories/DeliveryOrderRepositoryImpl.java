package com.jefferson.center.platform.andes.infrastructure.persistence.jpa.repositories;

import com.jefferson.center.platform.andes.domain.model.aggregates.DeliveryOrder;
import com.jefferson.center.platform.andes.domain.model.valueobjects.*;
import com.jefferson.center.platform.andes.domain.repositories.DeliveryOrderRepository;
import com.jefferson.center.platform.andes.infrastructure.entities.DeliveryOrderEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DeliveryOrderRepositoryImpl implements DeliveryOrderRepository {
    private final JpaDeliveryOrderRepository jpaRepository;

    public DeliveryOrderRepositoryImpl(JpaDeliveryOrderRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public boolean existsByDeliveryCode(String deliveryCode) {
        return jpaRepository.existsByDeliveryCode(new DeliveryCode(deliveryCode));
    }

    @Override
    public DeliveryOrder save(DeliveryOrder deliveryOrder) {
        DeliveryOrderEntity entity = new DeliveryOrderEntity(
                deliveryOrder.getDeliveryCode(),
                deliveryOrder.getWarehouseId(),
                deliveryOrder.getDeliveryWindow(),
                deliveryOrder.getPackageLoad(),
                deliveryOrder.getDeliveryStatus(),
                deliveryOrder.getPriorityLevel(),
                deliveryOrder.getDeliveryNotes()
        );
        DeliveryOrderEntity saved = jpaRepository.save(entity);
        return toAggregate(saved);
    }

    @Override
    public Optional<DeliveryOrder> findById(Long id) {
        return jpaRepository.findById(id).map(this::toAggregate);
    }

    private DeliveryOrder toAggregate(DeliveryOrderEntity entity) {
        return new DeliveryOrder(
                entity.getId(),
                entity.getDeliveryCode(),
                entity.getWarehouseId(),
                entity.getDeliveryWindow(),
                entity.getPackageLoad(),
                entity.getDeliveryStatus(),
                entity.getPriorityLevel(),
                entity.getDeliveryNotes(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
