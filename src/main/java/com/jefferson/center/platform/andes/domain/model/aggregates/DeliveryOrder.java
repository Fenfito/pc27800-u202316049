package com.jefferson.center.platform.andes.domain.model.aggregates;
import com.jefferson.center.platform.andes.domain.model.valueobjects.DeliveryStatus;
import com.jefferson.center.platform.andes.domain.model.valueobjects.DeliveryCode;
import com.jefferson.center.platform.andes.domain.model.valueobjects.WarehouseId;
import com.jefferson.center.platform.andes.domain.model.valueobjects.DeliveryWindow;
import com.jefferson.center.platform.andes.domain.model.valueobjects.PackageLoad;



public class DeliveryOrder {
    private final DeliveryCode deliveryCode;
    private final WarehouseId warehouseId;
    private final DeliveryWindow deliveryWindow;
    private final PackageLoad packageLoad;
    private final DeliveryStatus deliveryStatus;

    public DeliveryOrder(DeliveryCode deliveryCode, WarehouseId warehouseId, DeliveryWindow deliveryWindow, PackageLoad packageLoad, DeliveryStatus deliveryStatus) {
        this.deliveryCode = deliveryCode;
        this.warehouseId = warehouseId;
        this.deliveryWindow = deliveryWindow;
        this.packageLoad = packageLoad;
        this.deliveryStatus = deliveryStatus;
    }

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



}
