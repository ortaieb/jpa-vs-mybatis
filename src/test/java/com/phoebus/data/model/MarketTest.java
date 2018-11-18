package com.phoebus.data.model;

import org.junit.Test;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

/**
 */
public class MarketTest
//        extends AbstractTest
{

    /*@Ignore
    @Test
    public void insertToMarket() {
        beginTransaction();

        Market market1 = new Market();
        market1.setName("market-1");
        Market market2 = new Market();
        market2.setName("market-2");

        System.out.println("market1 before : " + market1);
        System.out.println("market2 before : " + market2);

        this.em.persist(market1);
        this.em.persist(market2);
        this.em.flush();
        
        System.out.println("market1 after  : " + market1);
        System.out.println("market2 after  : " + market2);
        commitTransaction();

//        beginTransaction();
//
//        long n = em.createQuery("SELECT m FROM Market m", Market.class).getResultStream().count();
//
//        assertThat(n, is(2L));
//
//        commitTransaction();
    }*/

    @Test
    public void create_market_with_explicit_event_add_market_to_event() {
        Event event = new Event(100, "event", null, null);

        Market market = new Market(null, "market-1", event);

        assertThat(event.getMarkets(), hasItem(market));

    }

}
