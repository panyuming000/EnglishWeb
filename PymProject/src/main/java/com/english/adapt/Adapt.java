package com.english.adapt;

import com.english.service.Service;

public interface Adapt {
    public Object methodAdapt(Object adaptElement, Object methodName, Object... adaptParam);
}
