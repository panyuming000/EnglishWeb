package com.english.serviceImpl;

import com.english.adapt.Adapt;
import com.english.adapt.ElementMethodAdapt;
import com.english.adapt.ServiceAdapt;
import com.english.exception.ServiceNotFindException;
import com.english.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@org.springframework.stereotype.Service
public class ServiceFactor {

    Adapt adapt=new ElementMethodAdapt();

    @Autowired
    Map<String,Service> map;
    public Object invoke(String service,Object methodName,Object... param) throws ServiceNotFindException{
        Service sv=null;
        Object result=null;
        //从容器中获取serice
        if(map!=null){
           sv = map.get(service);
           if(sv!=null){
               result=adapt.methodAdapt(sv,methodName,param);
           }else{
               throw new ServiceNotFindException("没有找到"+service+"这个类");
           }
        }else{
            System.out.println("ServiceFactor的值为空");
        }
        return result;
    }
}
