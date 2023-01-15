package fii.jt.lab7.interceptor;

import fii.jt.lab7.interfaces.IInterceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@javax.interceptor.Interceptor
@IInterceptor
public class LogInterceptor implements Serializable {
    @AroundInvoke
    public final Object log(InvocationContext context) {
        Object o = null;
        try {
            o = context.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}
