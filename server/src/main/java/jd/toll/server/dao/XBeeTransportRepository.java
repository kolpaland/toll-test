package jd.toll.server.dao;

import jd.toll.server.domain.XBeeOwner;
import jd.toll.server.domain.XBeeTransport;
import org.springframework.data.repository.CrudRepository;

public interface XBeeTransportRepository extends CrudRepository<XBeeTransport, String> {

}