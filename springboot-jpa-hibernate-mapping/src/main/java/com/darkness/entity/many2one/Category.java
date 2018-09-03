package com.darkness.entity.many2one;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany( mappedBy = "category",
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER )
    private Set<Product> products;

    public Category(String name) {
        this.name = name;
    }
}
