package jd.toll.server.dao;

import jd.toll.server.domain.XBeeNode;
import jd.toll.server.domain.XBeeOwner;
import org.springframework.data.repository.CrudRepository;

public interface XBeeOwnerRepository extends CrudRepository<XBeeOwner, String> {

}