package com.behsa.crm.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private String resultCode;
    private String resultDescription;
}
