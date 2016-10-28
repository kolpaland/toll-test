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
@Table(name = "owner")
public class XBeeOwner {

    @Id
    @Column(name = "id")
    public String ownerId;

    @Column(name = "firstname")
    public String firstName;

    @Column(name = "middlename")
    public String middleName;

    @Column(name = "lastname")
    public String lastName;

    @Column(name = "passport")
    public String passport;

    @Column(name = "drivelicense")
    public String driveLisence;

    private static final Logger log = LoggerFactory.getLogger(XBeeOwner.class);

    public XBeeOwner() {
    }

    public XBeeOwner(
            String ownerId,
            String firstName,
            String middleName,
            String lastName,
            String passport,
            String driveLisence
    ) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.passport = passport;
        this.driveLisence = driveLisence;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDriveLisence() {
        return driveLisence;
    }

    public void setDriveLisence(String driveLisence) {
        this.driveLisence = driveLisence;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
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
}
