package com.candyshop.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;
    @Column(name = "name_client")
    private String nameClient;
    @Column(name = "description_client")
    private String descriptionClient;
    @Column(name = "chocolates_client")
    @OneToMany(cascade =  CascadeType.ALL)
    private List<Chocolate> chocolates;

}
