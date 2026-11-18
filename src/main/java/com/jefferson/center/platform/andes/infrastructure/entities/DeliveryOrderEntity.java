package com.jefferson.center.platform.andes.infrastructure.entities;

import com.jefferson.center.platform.andes.domain.model.valueobjects.*;
import com.jefferson.center.platform.andes.infrastructure.converters.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_orders", uniqueConstraints = @UniqueConstraint(name = "uk_delivery_code", columnNames = "delivery_code"))
public class DeliveryOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = DeliveryCodePersistenceConverter.class)
    @Column(name = "delivery_code", nullable = false, unique = true)
    private DeliveryCode deliveryCode;

    @Convert(converter = WarehouseIdPersistenceConverter.class)
    @Column(name = "warehouse_id", nullable = false)
    private WarehouseId warehouseId;

    @Convert(converter = DeliveryWindowPersistenceConverter.class)
    @Column(name = "delivery_window", nullable = false)
    private DeliveryWindow deliveryWindow;

    @Convert(converter = PackageLoadPersistenceConverter.class)
    @Column(name = "package_load", nullable = false)
    private PackageLoad packageLoad;

    @Convert(converter = DeliveryStatusPersistenceConverter.class)
    @Column(name = "delivery_status", nullable = false)
    private DeliveryStatus deliveryStatus;

    @Column(name = "priority_level", nullable = false)
    private Integer priorityLevel;

    @Column(name = "delivery_notes")
    private String deliveryNotes;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    protected DeliveryOrderEntity() {}

    public DeliveryOrderEntity(DeliveryCode deliveryCode, WarehouseId warehouseId, DeliveryWindow deliveryWindow,
                               PackageLoad packageLoad, DeliveryStatus deliveryStatus, Integer priorityLevel,
                               String deliveryNotes) {
        this.deliveryCode = deliveryCode;
        this.warehouseId = warehouseId;
        this.deliveryWindow = deliveryWindow;
        this.packageLoad = packageLoad;
        this.deliveryStatus = deliveryStatus;
        this.priorityLevel = priorityLevel;
        this.deliveryNotes = deliveryNotes;
    }

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public DeliveryCode getDeliveryCode() { return deliveryCode; }
    public WarehouseId getWarehouseId() { return warehouseId; }
    public DeliveryWindow getDeliveryWindow() { return deliveryWindow; }
    public PackageLoad getPackageLoad() { return packageLoad; }
    public DeliveryStatus getDeliveryStatus() { return deliveryStatus; }
    public Integer getPriorityLevel() { return priorityLevel; }
    public String getDeliveryNotes() { return deliveryNotes; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
