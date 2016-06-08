/**
 * <p>文件: AbstractRestController.java</p>
 * <p>版权: Copyright © 2016 ZHOULINGFEI., Beijing. All Rights Reserved.</p>
 * <p>作者: 周凌飞(zhlf2001@163.com , 64426359@qq.com)</p>
 * <p>时间: 2016-04-21 14:11:45</p>
*/
package web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import web.bean.dto.RestResponse;

/**
 * 这是所有返回json的controller的父类
 * 
 * @author lijia
 *
 */
@Controller
public abstract class AbstractRestController {

	protected RestResponse<Object> wrap(Object obj) {
		RestResponse<Object> rr = new RestResponse<Object>();
		rr.setStatus("1");// 默认json中status="1"表示调用正常
		rr.setMessage("服务调用成功");// 正常情况下返回OK即可
		rr.setResult(obj);
		return rr;
	}

	protected RestResponse<Object> wrap(String status, String message) {
		RestResponse<Object> rr = new RestResponse<Object>();
		rr.setStatus(status);
		rr.setMessage(message);
		return rr;
	}

	protected RestResponse<Object> wrap(String status, String message, Object result) {
		RestResponse<Object> rr = new RestResponse<Object>();
		rr.setStatus(status);
		rr.setMessage(message);
		rr.setResult(result);
		return rr;
	}

	/**
	 * 
	 * @Description:获取请求的request对象，可以通过此对象获取一下header及cookie信息
	 * @return
	 * @Author:denghong1 2015年9月5日上午11:22:42
	 * @update1:
	 *
	 */
	public HttpServletRequest getHttpRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 
	 * @Description:获取response对象，可以通过此对象设置header及cookie信息
	 * @return
	 * @Author:denghong1 2015年9月5日上午11:23:15
	 * @update1:
	 *
	 */
	public HttpServletResponse getHttpResponse() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}
}
