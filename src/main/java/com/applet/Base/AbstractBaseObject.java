package com.applet.Base;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractBaseObject implements Serializable {
    private static final long serialVersionUID = 4885441308232145678L;

}
