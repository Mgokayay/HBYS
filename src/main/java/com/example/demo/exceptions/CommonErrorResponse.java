package com.example.demo.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonErrorResponse {

    private Integer status;
    private String message;
    private LocalDateTime timeStamp;
}
