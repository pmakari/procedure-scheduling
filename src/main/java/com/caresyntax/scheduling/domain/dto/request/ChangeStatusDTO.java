package com.caresyntax.scheduling.domain.dto.request;

import com.caresyntax.scheduling.domain.dto.BaseRequestDTO;
import com.caresyntax.scheduling.domain.enums.Status;
import lombok.*;

/**
 * Created by MAP2LE on 13.05.2018.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ChangeStatusDTO extends BaseRequestDTO {
    private Status status;
    private Long id;
}
