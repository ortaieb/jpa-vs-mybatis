package com.phoebus.data.model;

import org.junit.Test;

import java.util.List;

/**
 */
public class MarketTest extends AbstractTest {

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

        beginTransaction();

        List<Market> result = QueryDatabaseTools.tableContent("market", Market.class);
        System.out.println("Results : " + result.toString());

        commitTransaction();
    }
}
