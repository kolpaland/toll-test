package jd.toll.server.domain;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User: saturn
 * Date: 17.09.2014
 */
@Entity
@Table(name = "transport")
public class XBeeTransport {

    @Id
    @Column(name = "owner_id")
    public String ownerId;

    @Column(name = "id")
    public String transportId;

    @Column(name = "type")
    public String type;

    @Column(name = "model")
    public String model;

    @Column(name = "brand")
    public String brand;

    @Column(name = "statenumber")
    public String stateNumber;

    private static final Logger log = LoggerFactory.getLogger(XBeeTransport.class);

    public XBeeTransport() {
    }

    public XBeeTransport(
            String ownerId,
            String transportId,
            String type,
            String model,
            String brand,
            String stateNumber
    ) {
        this.ownerId = ownerId;
        this.transportId = transportId;
        this.type = type;
        this.model = model;
        this.brand = brand;
        this.stateNumber = stateNumber;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public String getDH() {
        return this.ownerId.substring(0, 8);
    }

    public String getDL() {
        return this.ownerId.substring(8, ownerId.length());
    }

    public int[] getOwnerIdAsInt() {
        if (StringUtils.isEmpty(ownerId)) {
            return null;
        }
        int[] result = new int[8];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.valueOf(ownerId.substring(i*2, i*2 + 2), 16);

        }
        return result;
    }

    public int[] getTransportIdAsInt() {
        if (StringUtils.isEmpty(transportId)) {
            return null;
        }
        int[] result = new int[8];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.valueOf(transportId.substring(i*2, i*2 + 2), 16);

        }
        return result;
    }
}
