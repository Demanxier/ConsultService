package com.demanxier.cunsultService.entity.form;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaForm {

    private String nome;

    private String cnpj;
}
