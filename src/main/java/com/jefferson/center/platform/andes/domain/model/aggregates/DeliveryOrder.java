package com.jefferson.center.platform.andes.domain.model.aggregates;
import com.jefferson.center.platform.andes.domain.model.valueobjects.DeliveryCode;
import com.jefferson.center.platform.andes.domain.model.valueobjects.DeliveryStatus;
import com.jefferson.center.platform.andes.domain.model.valueobjects.DeliveryWindow;
import com.jefferson.center.platform.andes.domain.model.valueobjects.PackageLoad;
import com.jefferson.center.platform.andes.domain.model.valueobjects.WarehouseId;

import java.time.LocalDateTime;

public class DeliveryOrder {
    private Long id;
    private final DeliveryCode deliveryCode;
    private final WarehouseId warehouseId;
    private final DeliveryWindow deliveryWindow;
    private final PackageLoad packageLoad;
    private final DeliveryStatus deliveryStatus;
    private final Integer priorityLevel;
    private final String deliveryNotes;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public DeliveryOrder(DeliveryCode deliveryCode, WarehouseId warehouseId, DeliveryWindow deliveryWindow, PackageLoad packageLoad, DeliveryStatus deliveryStatus) {
        this(null, deliveryCode, warehouseId, deliveryWindow, packageLoad, deliveryStatus, 1, null, null, null);
    }

    public DeliveryOrder(DeliveryCode deliveryCode, WarehouseId warehouseId, DeliveryWindow deliveryWindow, PackageLoad packageLoad,
                         DeliveryStatus deliveryStatus, Integer priorityLevel, String deliveryNotes) {
        this(null, deliveryCode, warehouseId, deliveryWindow, packageLoad, deliveryStatus, priorityLevel, deliveryNotes, null, null);
    }

    public DeliveryOrder(Long id, DeliveryCode deliveryCode, WarehouseId warehouseId, DeliveryWindow deliveryWindow,
                         PackageLoad packageLoad, DeliveryStatus deliveryStatus, Integer priorityLevel, String deliveryNotes,
                         LocalDateTime createdAt, LocalDateTime updatedAt) {
        if (deliveryCode == null) throw new IllegalArgumentException("Delivery code is required");
        if (warehouseId == null) throw new IllegalArgumentException("Warehouse ID is required");
        if (deliveryWindow == null) throw new IllegalArgumentException("Delivery window is required");
        if (packageLoad == null) throw new IllegalArgumentException("Package load is required");
        if (deliveryStatus == null) throw new IllegalArgumentException("Delivery status is required");
        if (priorityLevel == null || priorityLevel < 1 || priorityLevel > 5) {
            throw new IllegalArgumentException("Priority level must be between 1 and 5");
        }
        if (deliveryNotes != null && deliveryNotes.isBlank()) deliveryNotes = null;
        this.id = id;
        this.deliveryCode = deliveryCode;
        this.warehouseId = warehouseId;
        this.deliveryWindow = deliveryWindow;
        this.packageLoad = packageLoad;
        this.deliveryStatus = deliveryStatus;
        this.priorityLevel = priorityLevel;
        this.deliveryNotes = deliveryNotes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() { return id; }
    public DeliveryCode getDeliveryCode() {
        return deliveryCode;
    }
    public WarehouseId getWarehouseId() {
        return warehouseId;
    }
    public DeliveryWindow getDeliveryWindow() {
        return deliveryWindow;
    }
    public PackageLoad getPackageLoad() {
        return packageLoad;
    }
    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }
    public Integer getPriorityLevel() { return priorityLevel; }
    public String getDeliveryNotes() { return deliveryNotes; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
