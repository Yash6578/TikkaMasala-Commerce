package com.tikkamasala.commerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "item_id")
    @JsonIgnoreProperties("inventories")
    private Item item;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    @JsonIgnoreProperties("teams")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "sale_id")
//    @JsonBackReference("sale-item")
    private Sale sale;

    @Column(name = "created_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = new Date();
    }
}
