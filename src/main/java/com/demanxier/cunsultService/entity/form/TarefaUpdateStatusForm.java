package com.demanxier.cunsultService.entity.form;

import com.demanxier.cunsultService.entity.enums.StatusTarefa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaUpdateStatusForm {

    private StatusTarefa status;
}
