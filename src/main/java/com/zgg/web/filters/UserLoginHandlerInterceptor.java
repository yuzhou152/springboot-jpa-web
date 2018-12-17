package com.zgg.web.filters;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class UserLoginHandlerInterceptor implements HandlerInterceptor {
	private static byte[] lock1 = new byte[]{};
	private static byte[] lock2 = new byte[]{};
	//最大用户数
    private long maxUserNumber = 10;
    //当前用户数
    private static volatile long currentUserNumber = 0;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    	boolean bool;
    	synchronized (lock1) {
    		bool = currentUserNumber >= maxUserNumber;
    	}
    	//若当前用户数大于等于最大用户数则拒绝访问,并报警
	    if (bool) {
	    	System.out.println("已达到最大值，报警！");
	    	return false;
	    }
    	//若当前用户数小于最大用户数则接收访问,并当前用户数++
    	dealNumber(true);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) throws Exception {
    	//当前用户访问完毕则当前用户数--
    	dealNumber(false);
    }

    private static void dealNumber(boolean addOrReduce) {
    	synchronized (lock2) {
			if (addOrReduce) {
				System.out.println(currentUserNumber);
				currentUserNumber++;
			} else {
				currentUserNumber--;
			}
		}
    }
    
    public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
		    new Thread(new Runnable() {
				
				@Override
				public void run() {
					dealNumber(true);
				}
			}).start();
		}
	}
}
