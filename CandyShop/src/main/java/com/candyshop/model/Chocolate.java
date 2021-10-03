package com.candyshop.model;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "tb_chocolate")
public class Chocolate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chocolate")
    private Long idChocolate;
    @Column(name = "name_chocolate")
    private String chocolateName;
    @Column(name = "type_chocolate")
    private String chocolateType;
}