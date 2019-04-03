package com.pj.clientserv.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ReturnInfo  implements Serializable {
    private int resultcode;
    private String resultmsg;
}
