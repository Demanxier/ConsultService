package com.demanxier.cunsultService.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteForm {

    private String nome;

    private String email;

    private String senha;
}
