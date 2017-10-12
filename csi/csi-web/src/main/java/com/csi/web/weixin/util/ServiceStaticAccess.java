package com.csi.web.weixin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by fanlin on 2017/10/12.
 */
@Component
public class ServiceStaticAccess implements ApplicationContextAware, DisposableBean {
    private static Logger logger = LoggerFactory.getLogger(ServiceStaticAccess.class);

    private static ApplicationContext applicationContext = null;

    @Override
    public void destroy() throws Exception {
        ServiceStaticAccess.clear();
    }

    private static void clear() {
        logger.debug("清除ServiceStaticAccess中的ApplicationContext:" + applicationContext);
        applicationContext = null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        logger.debug("注入ApplicationContext到SpringApplicationContext:" + applicationContext);

        if(ServiceStaticAccess.applicationContext != null) {
            logger.warn("ServiceStaticAccess中的ApplicationContext被覆盖, 原有ApplicationContext为:"
                    + ServiceStaticAccess.applicationContext);
        }

        ServiceStaticAccess.applicationContext = applicationContext;
    }
    
    public static <T> T getBean(String name, Class clazz) {
        assertContextInJected();
        return (T) applicationContext.getBean(name, clazz);
    }

    /**检查applicationContext不为空*/
    private static void assertContextInJected() {

        if(applicationContext == null){
            throw new IllegalStateException("applicationContext未注入,请在applicationContext.xml中定义ServiceStaticAccess");
        }
    }
}
