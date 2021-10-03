package com.candyshop.model.dto;

import com.candyshop.model.Chocolate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long idClient;
    private String nameClient;
    private String descriptionClient;
    private List<Chocolate> chocolates;

}
