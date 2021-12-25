package com.homon.SpringBoot.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.homon.SpringBoot.annotation.Log;
import com.homon.SpringBoot.util.result.ResultInfo;
import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.UUID;

@Aspect
@Component
public class LogAop {
    protected static Logger logger = LoggerFactory.getLogger(LogAop.class);

    ThreadLocal<Long> time = new ThreadLocal<>();
    ThreadLocal<String> tag = new ThreadLocal<>();

    private static Gson gson = new Gson();

    @Pointcut("@annotation(com.homon.SpringBoot.annotation.Log)")
    public void log() {}

    /**
     * 在所有标注@Log的地方切入
     *
     * @param joinPoint
     */
    @Before("log()")
    public void beforeExec(JoinPoint joinPoint) {

        time.set(System.currentTimeMillis());
        tag.set(UUID.randomUUID().toString());

        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();

        Object[] os = joinPoint.getArgs();
        String[] pn = ms.getParameterNames();
        logger.info("["+joinPoint.getTarget().toString()+"] " + method.getName() + " Args:");
        for (int i = 0; i < os.length; i++) {
            logger.info("["+joinPoint.getTarget().toString()+"] \t==>参数[" + pn[i] + "]:\t" + (os[i]==null ? null : os[i].toString()));
        }

        logger.info("["+joinPoint.getTarget().toString()+"] Before method : " + method.getName() + " uuid:" + tag.get());
    }

    @After("log()")
    public void afterExec(JoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        logger.info("["+joinPoint.getTarget().toString()+"] After method : " + method.getName() + " uuid:" + tag.get() + " cost time:" + (System.currentTimeMillis() - time.get()) + "ms");
    }

    @AfterReturning(pointcut="@annotation(log)", returning="returnValue")
    public void afterExecWithReturn(JoinPoint joinPoint, Object returnValue, Log log) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        // 获取log参数
        boolean isReturnValue = log.returnValue();
        if (isReturnValue){
            logger.info("["+joinPoint.getTarget().toString()+"] After result method : " + method.getName() + " uuid:" + tag.get() + " return ：" + gson.toJson(returnValue));
        } else {
            SimplePropertyPreFilter simplePropertyPreFilter = new SimplePropertyPreFilter(ResultInfo.class,"errno","errmsg");
            logger.info("["+joinPoint.getTarget().toString()+"] After result method : " + method.getName() + " uuid:" + tag.get() + " return ：" + JSON.toJSONString(returnValue,simplePropertyPreFilter));
        }

    }

    private void info(JoinPoint joinPoint) {
        logger.info("--------------------------------------------------");
        logger.info("King:\t" + joinPoint.getKind());
        logger.info("Target:\t" + joinPoint.getTarget().toString());
        Object[] os = joinPoint.getArgs();
        logger.info("Args:");
        for (int i = 0; i < os.length; i++) {
            logger.info("\t==>参数[" + i + "]:\t" + os[i].toString());
        }
        logger.info("Signature:\t" + joinPoint.getSignature());
        logger.info("SourceLocation:\t" + joinPoint.getSourceLocation());
        logger.info("StaticPart:\t" + joinPoint.getStaticPart());
        logger.info("--------------------------------------------------");
    }

}