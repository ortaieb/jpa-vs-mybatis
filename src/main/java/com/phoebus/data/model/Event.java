package com.phoebus.data.model;

import com.sun.javafx.collections.ImmutableObservableList;
import org.eclipse.collections.impl.factory.Lists;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 */
@Entity
@Table(name = "event")
public class Event implements Serializable {

    private static final long serialVersionUID = -9017509534886247694L;

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "event_name")
    private String name;

    @JoinColumn(name = "event_subcat_id", referencedColumnName = "event_subcat_id")
    @ManyToOne(optional = false)
    private EventSubcat subcat;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event", fetch = FetchType.LAZY)
    private List<Market> markets;


    public Event() {}

    public Event(final Integer id, final String name, final EventSubcat subcat, final List<Market> markets) {
        this.id = id;
        this.name = name;
        this.subcat = subcat;
        this.markets = markets;
    }


    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public EventSubcat getSubcat() {
        return subcat;
    }

    public void setSubcat(final EventSubcat subcat) {
        this.subcat = subcat;
    }

    public List<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(final List<Market> markets) {
        this.markets = markets;
    }


    void addMarket(Market market) {
        markets = Lists.immutable.ofAll(markets).newWith(market).castToList();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", subcat=").append(subcat);
        sb.append(", markets=").append(markets);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Event)) {
            return false;
        }
        final Event event = (Event) o;
        return getId() == event.getId() &&
               Objects.equals(getName(), event.getName()) &&
               Objects.equals(getSubcat(), event.getSubcat()) &&
               Objects.equals(getMarkets(), event.getMarkets());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSubcat(), getMarkets());
    }
}
