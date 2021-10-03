package com.candyshop.model.form;

import com.candyshop.model.Chocolate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientForm {
    //@NotNull, @Size, @Column são especificações do Bean Validation.
    @NotNull
    @Size(min = 2, max = 15, message = "Your name must have at least 3 letters")
    private String nameClient;
    @NotNull
    private String descriptionClient;
    @NotNull
    private List<Chocolate> chocolates;


}
