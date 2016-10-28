package jd.toll.server.pages;

import jd.toll.server.domain.XBeeTransport;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;

import java.util.Iterator;

/**
 * Created by cisco on 21.10.2016.
 */
public class DataProvider implements IDataProvider<XBeeTransport> {
    @Override
    public Iterator<? extends XBeeTransport> iterator(long first, long count) {
        return null;
    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public IModel<XBeeTransport> model(XBeeTransport object) {
        return null;
    }

    @Override
    public void detach() {

    }
}
