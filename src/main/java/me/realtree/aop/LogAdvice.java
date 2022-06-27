package me.realtree.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {

	//(..)=파라메타 타입 관계없다는 뜻
//	@Before("execution(* me.realtree.service.*.*(..))")
//	public void logBefore() {
//		System.out.println("===========내가 먼저 실행함 ㅎㅎ===============");
//	}
	
	
//	@After("execution(* me.realtree.service.*.doAdd(String,String)) && args(str1,str2)")
//	public void logBefore(String str1, String str2) {
//		System.out.println("===========나중에 실행함 ㅎㅎ  ===============");
//		System.out.println("첫 번째 파라미터 : " + str1);
//		System.out.println("두 번째 파라미터 : " + str2);
//		
//	}
	@Around("execution(* me.realtree.service.*.doAdd(String,String))")
	public Object logTime(ProceedingJoinPoint joinPoint) {
		long start = System.currentTimeMillis();
		
		Object result = null;
		
		try {
			result = joinPoint.proceed(); // doAdd메소드 호출
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("도달 시간 설정");
		//비지니스로직
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간 : " + (end - start));
		return result;
	}
}
