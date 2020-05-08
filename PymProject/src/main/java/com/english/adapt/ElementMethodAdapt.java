package com.english.adapt;

import com.english.service.BaseService;

import java.lang.reflect.Method;

public class ElementMethodAdapt implements Adapt{
    @Override
    public Object methodAdapt(Object adaptElement, Object methodName, Object... adaptParam) {
        Object result=null;
        Method method;
        try{Class[] clazz;
            if(adaptParam!=null){
                if(adaptParam.length>1){
                    clazz = new Class[adaptParam.length];
                    for(int a=0;a<adaptParam.length;a++){
                        clazz[a]=adaptParam[a].getClass();
                    }
                    method= adaptElement.getClass().getDeclaredMethod((String) methodName, clazz);
                    result = method.invoke(adaptElement,adaptParam);
                }else{
                    method= adaptElement.getClass().getDeclaredMethod((String) methodName, adaptParam[0].getClass());
                    result = method.invoke(adaptElement,adaptParam);
                }
            }
            else{
                method= adaptElement.getClass().getDeclaredMethod((String) methodName);
                result = method.invoke(adaptElement);
            }
        }catch (Exception e){
            System.out.println("适配时出现问题:["+adaptElement+"]");
            e.printStackTrace();
        }
        return result;
    }
}
