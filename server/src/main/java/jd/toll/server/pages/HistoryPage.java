package jd.toll.server.pages;

import jd.toll.server.domain.XBeeTransport;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.AbstractReadOnlyModel;

/**
 * Created by cisco on 20.10.2016.
 */
public class HistoryPage extends WebPage{
    public HistoryPage() {
        add(new DataView<XBeeTransport>("simple", new DataProvider())
        {
            @Override
            protected void populateItem(final Item<XBeeTransport> item)
            {
                XBeeTransport contact = item.getModelObject();
                item.add(new Label("contactid", String.valueOf(contact.getTransportId())));
                item.add(new Label("firstname", contact.getModel()));
                item.add(new Label("lastname", contact.getBrand()));
                item.add(new Label("homephone", contact.getStateNumber()));
                item.add(new Label("cellphone", contact.getType()));

                item.add(AttributeModifier.replace("class", new AbstractReadOnlyModel<String>()
                {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public String getObject()
                    {
                        return (item.getIndex() % 2 == 1) ? "even" : "odd";
                    }
                }));
            }
        });
    }
}
