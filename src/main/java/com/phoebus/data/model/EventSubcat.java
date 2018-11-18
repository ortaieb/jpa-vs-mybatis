package com.phoebus.data.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 */
@Entity
@Table(name = "event_subcat")
public class EventSubcat implements Serializable {

    private static final long serialVersionUID = 7673331498454340985L;

    @Id
    @Column(name = "event_subcat_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Basic(optional = false)
    @Column(name = "event_subcat_name")
    private String name;


    public EventSubcat() {}

    public EventSubcat(final int id, final String name) {
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EventSubcat{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EventSubcat)) {
            return false;
        }
        final EventSubcat that = (EventSubcat) o;
        return getId() == that.getId() &&
               Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
