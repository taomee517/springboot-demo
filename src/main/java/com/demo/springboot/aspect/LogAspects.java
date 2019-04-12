package com.demo.springboot.aspect;

import com.demo.springboot.constant.DataTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/12
 * @time 9:04
 */
@Slf4j
@Aspect
/**声明当前类是一个Spring切面类*/
public class LogAspects {
    /**方式一：抽取公共的切入点表达式
     * 本类引用：expressPointCut()
     */
    @Pointcut("execution(* com.demo.springboot.controller.*Controller.*(..))")
    public void expressPointCut(){
    }

    /**方式二：根据自定义注解切入*/
    @Pointcut("@annotation(com.demo.springboot.aspect.MyPointCut)")
    public void annotationPointCut(){
    }

    @Before("expressPointCut()")
    public void logStart() {
        log.info("进入控制层...参数列表是：{}");
    }

    @Before("annotationPointCut()")
    public void annoLogStart() {
        log.info("进入自定义切入点..前置处理");
    }

    @After("annotationPointCut()")
    public void annoDoAfter(JoinPoint joinPoint) {
        log.info("进入自定义切入点..后置处理");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //请求的IP
        String ip = request.getRemoteAddr();
        try {
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature)signature;
            log.info("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + signature.getName() + "()"));
            log.info("注解描述:" + getPointCutDescription(joinPoint));
            log.info("简单点的获取注解描述的方法:" + methodSignature.getMethod().getAnnotation(MyPointCut.class).desc());
            log.info("请求IP:" + ip);
        } catch (Exception e) {
            log.info("切入点后置处理器发生异常：{}" + e);
        }
    }

    @AfterReturning(returning = "result" ,pointcut = "annotationPointCut()")
    public void doAfterReturning(JoinPoint joinPoint,Object result){
        log.info("方法执行完成,后置处理器，返回结果是：" + result);
    }

    @AfterThrowing(throwing = "ex" ,pointcut = "annotationPointCut()")
    public void logException(JoinPoint joinPoint,Exception ex) {
        log.error(((MethodSignature) joinPoint.getSignature()).getMethod().getName() + "方法执行发生异常:",ex );
    }


    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getPointCutDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (parasConfirm(clazzs,arguments)) {
                    description = method.getAnnotation(MyPointCut.class).desc();
                    break;
                }
            }
        }
        return description;
    }

    /**判断参数个数及参数类型是否完全一致，以判断是否同一个方法*/
    public static boolean parasConfirm(Class[] clazzs,Object[] arguments){
        if(clazzs.length != arguments.length){
            return false;
        }
        if(clazzs.length == 0){
            return true;
        }
        for(int i=0;i<clazzs.length;i++){
            Object para = arguments[i];
            Class clz = clazzs[i];
            String paraClassName = para.getClass().getName();
            String fullClzPath = DataTypeEnum.basicMap.get(clz.getName()).getFullClassPath();
            if(!paraClassName.equals(clz.getName()) && !paraClassName.equals(fullClzPath)){
                return false;
            }
        }
        return true;
    }
}
