package com.remake.food4u.domain.goods;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long g_no;
    private String name;
    private int price;
    private String type;
    private String fname;
    private int stock;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Nutrient> nutrients = new ArrayList<Nutrient>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<Composition> compositions = new ArrayList<Composition>();


    @Builder

    public Goods(String name, int price, String type, String fname, int stock,Collection<Nutrient> nutrients,Collection<Composition> compositions) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.fname = fname;
        this.stock = stock;
    }
}
