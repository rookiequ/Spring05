package com.user.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author zzq
 * 通知类：用于增强ServiceAccount方法
 */
public class Logger {

    /**
     * 前置通知
     */
    public void beforePrinting(){
        System.out.println("前置通知Logger类中的beforePrinting方法开始记录日志了...");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrinting(){
        System.out.println("后置通知Logger类中的afterReturningPrinting方法开始记录日志了...");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrinting(){
        System.out.println("异常通知Logger类中的afterThrowingPrinting方法开始记录日志了...");
    }

    /**
     * 最终通知 相当于finally，遇到异常后，最后肯定也会执行
     */
    public void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了...");
/*        try{

        }catch (Exception e){
            System.out.println("程序出现异常");
            e.printStackTrace();
        }finally {

        }*/
    }


    /**
     * 环绕通知  和普通的通知不一样的时，在遇到异常时，后面的增强方法也会继续执行，普通的通知时遇到异常后，后续的方法就不会在执行了
     * @param proceedingJoinPoint
     * @return
     */
    public Object aroundPrinting(ProceedingJoinPoint proceedingJoinPoint){
        //指定返回值
        Object returnValue = null;
        //获取执行方法的所有参数
        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println("环绕通知的前置通知开始执行了");
        try {
            //在调用切入点方法，也就是需要增加的方法
            returnValue = proceedingJoinPoint.proceed(args);
            System.out.println("环绕通知的后置通知开始执行了");
            return returnValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知的异常置通知开始执行了");
            throwable.printStackTrace();
        } finally {
            System.out.println("环绕通知的最终通知开始执行了");
        }

        return null;
    }


}
