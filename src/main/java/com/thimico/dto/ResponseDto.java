package com.thimico.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author <a href="mailto:elizio.marcelino@gmail.com">Elizio Marcelino</a>
 */
@Getter
@RequiredArgsConstructor
public class ResponseDto {

    private final boolean showMessage;
    private final String message;

}
