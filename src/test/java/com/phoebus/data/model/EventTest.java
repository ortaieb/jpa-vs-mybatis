package com.phoebus.data.model;

import org.eclipse.collections.impl.factory.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EventTest
//        extends AbstractTest
{

    /*@Ignore
    @Test
    public void buildAllStructure() {

        EventSubcat subcat = new EventSubcat();
        subcat.setName("subcat-1");

        beginTransaction();
        em.persist(subcat);
        em.flush();
        commitTransaction();

        Event event = new Event();
        Market market1 = new Market();
        market1.setName("market-101");
        market1.setEvent(event);
        Market market2 = new Market();
        market2.setName("market-102");
        market2.setEvent(event);
        Market market3 = new Market();
        market3.setName("market-103");
        market3.setEvent(event);

        event.setName("event-1");
        event.setSubcat(subcat);
        event.setMarkets(Arrays.asList(market1, market2, market3));

        beginTransaction();
        em.persist(event);
        em.flush();
        commitTransaction();

        beginTransaction();
        Event persisted = (Event) em.createQuery("SELECT e FROM Event e").getSingleResult();
        assertThat(persisted == event, is(true));
        commitTransaction();
    }*/

    @Test
    public void add_market_to_existing_list() {
        Event event = new Event(100, null, null, null);
        List<Market> initialMarkets = Lists.fixedSize.of(
                new Market(1, "market-1", event),
                new Market(2, "market-2", event),
                new Market(3, "market-3", event)
        );
        event.setMarkets(initialMarkets);

        Market market = new Market(4, "market-4", null);
        event.addMarket(market);

        assertThat(event.getMarkets().size(), is(4));
        event.getMarkets().stream().filter(e -> e.getName().equals("market-4")).findFirst().orElseThrow(() -> new AssertionError("Could not find expected added market"));
    }

    @Test
    public void add_market_to_uninitiailsed_market_list() {
        Event event = new Event(100, null, null, null);

        Market market = new Market(4, "market-4", null);
        event.addMarket(market);

        assertThat(event.getMarkets().size(), is(1));
        event.getMarkets().stream().filter(e -> e.getName().equals("market-4")).findFirst().orElseThrow(() -> new AssertionError("Could not find expected added market"));
    }
}
