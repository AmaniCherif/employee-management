package org.acme.quartz;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name=" tasks ")
public class Task extends PanacheEntity{

    public Instant createdAt;

    public Task() {
        createdAt = Instant.now();
    }

    public Task(Instant time) {
        this.createdAt = time;
    }

}
