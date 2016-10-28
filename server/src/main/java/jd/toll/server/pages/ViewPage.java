package jd.toll.server.pages;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel;
import org.apache.wicket.util.lang.Numbers;
import org.apache.wicket.validation.validator.RangeValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cisco on 20.10.2016.
 */
public class ViewPage extends WebPage {
    public ViewPage() {
        // create a list of ITab objects used to feed the tabbed panel
        final List<ITab> tabs = new ArrayList<ITab>();
        tabs.add(new AbstractTab(new Model<String>("first tab"))
        {
            @Override
            public Panel getPanel(String panelId)
            {
                return new TabPanel1(panelId);
            }

        });

        tabs.add(new AbstractTab(new Model<String>("second tab"))
        {
            @Override
            public Panel getPanel(String panelId)
            {
                return new TabPanel2(panelId);
            }

        });

        // add the new tabbed panel, attribute modifier only used to switch
        // between different css variations
        final TabbedPanel<ITab> tabbedPanel = new TabbedPanel<ITab>("tabs", tabs);
        tabbedPanel.add(AttributeModifier.replace("class", ViewPage.this.getDefaultModel()));
        add(tabbedPanel);
        Button button1 = new Button("button1")
        {
            @Override
            public void onSubmit()
            {
                info("submit.onSubmit executed");
            }
        };
        add(button1);
    }

    private static class TabPanel1 extends Panel
    {
        public TabPanel1(String id)
        {
            super(id);
            add(new TextField<String>("carTypeProperty").setRequired(true));
            add(new TextField<String>("brendProperty").setRequired(true));
            add(new TextField<String>("modelProperty").setRequired(true));
            add(new TextField<String>("numberProperty").setRequired(true));

        }
    }

    private static class TabPanel2 extends Panel
    {
        public TabPanel2(String id)
        {
            super(id);
            add(new TextField<String>("stringProperty").setRequired(true));
            add(new TextField<Numbers>("integerProperty").setRequired(true));
        }
    }
}
