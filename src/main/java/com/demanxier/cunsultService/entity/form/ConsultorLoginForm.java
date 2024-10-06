package com.demanxier.cunsultService.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultorLoginForm {

    private String email;

    private String senha;
}
