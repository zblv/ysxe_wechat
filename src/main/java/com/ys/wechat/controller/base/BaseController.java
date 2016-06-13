package com.ys.wechat.controller.base;

import java.beans.PropertyEditorSupport;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ys.wechat.controller.common.Constants;
import com.ys.wechat.model.TSysAdmin;

/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:
 *
 * @author 吕志博
 * @date 2016-3-8 下午3:31:07
 * @version V1.0
 */
public class BaseController {
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected PageBounds pageBounds;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		binder.registerCustomEditor(ArrayList.class,
				new PropertyEditorSupport() {
					@SuppressWarnings({ "rawtypes", "unchecked" })
					@Override
					public void setAsText(String text)
							throws IllegalArgumentException {
						if (StringUtils.isBlank(text)) {
							return;
						} else {
							text = text.trim();
							ArrayList arrayList = new ArrayList();
							arrayList.addAll(Arrays.asList(text.split(",")));
							setValue(arrayList);
						}
					}
				});

		binder.registerCustomEditor(Short.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (StringUtils.isBlank(text)) {
					return;
				} else {
					text = text.trim();
					Short shortValue = null;
					try {
						shortValue = Short.valueOf(text);
					} catch (NumberFormatException e) {
						logger.error(e.getMessage(),
								e);
						return;
					}

					setValue(shortValue);
				}
			}
		});
		binder.registerCustomEditor(Long.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (StringUtils.isBlank(text)) {
					return;
				} else {
					text = text.trim();
					Long longValue = Long.valueOf(text);
					setValue(longValue);
				}
			}
		});
		
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (StringUtils.isBlank(text)) {
					return;
				} else {
					text = text.trim();
					setValue(text);
				}
			}
			@Override
            public String getAsText()
            {
                return getValue() == null ? "" : getValue().toString().trim();
            }
		});
		
		binder.registerCustomEditor(int.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (StringUtils.isBlank(text)) {
					return;
				} else {
					// 这里还要专门对应日期映射
					text = text.trim();
					Integer intvalue = null;
					try {
						intvalue = Integer.valueOf(text);
					} catch (NumberFormatException e) {
						logger.error(e.getMessage(),
								e);
						intvalue = 1;
					}

					setValue(intvalue);
				}
			}
			@Override
            public String getAsText()
            {
                return super.getAsText();
            }
		});
		binder.registerCustomEditor(Integer.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (StringUtils.isBlank(text)) {
					return;
				} else {
					text = text.trim();
					// 这里还要专门对应日期映射
					Integer intvalue = null;
					try {
						intvalue = Integer.valueOf(text);
					} catch (NumberFormatException e) {
						logger.error(e.getMessage(),
								e);
						intvalue = 1;
					}

					setValue(intvalue);
				}
			}
			
			/* (non-Javadoc)
			 * @see java.beans.PropertyEditorSupport#getAsText()
			 */
			@Override
			public String getAsText()
			{
			    return getValue() == null ? "" : getValue().toString();
			}
		});
		binder.registerCustomEditor(boolean.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (StringUtils.isBlank(text)) {
					return;
				} else {
					text = text.trim();
					Boolean booleanvalue = Boolean.valueOf(text);
					setValue(booleanvalue);
				}
			}
		});

		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (StringUtils.isBlank(text)) {
					return;
				} else {
					text = text.trim();
					if(text.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}")){
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
								"yyyy-MM-dd");
						try {
							Date date = simpleDateFormat.parse(text);
							setValue(date);
						} catch (ParseException e) {
							logger.error(e.getMessage(),
									e);
						}
					}else if(text.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2} (0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]")){
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
						try {
							Date date = simpleDateFormat.parse(text);
							setValue(date);
						} catch (ParseException e) {
							logger.error(e.getMessage(),
									e);
						}
					}else if(text.matches("^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]")){
					    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                                "HH:mm:ss");
                        try {
                            Date date = simpleDateFormat.parse(text);
                            setValue(date);
                        } catch (ParseException e) {
                           logger.error(e.getMessage(),
                                    e);
                        }
					}
				}
			}
			@Override
			public String getAsText()
			{
			    return getValue() == null ? "" : getValue().toString();
			}
		});
	}
	
	@ModelAttribute
	public void setReqAndResp(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		this.request=request;
		this.response=response;
		this.session=request.getSession();
		
		String currMenuName =  request.getParameter("currMenuName");
		String fMenuName =  request.getParameter("fMenuName");
		String fMenuUrl = request.getParameter("fMenuUrl");
		if(StringUtils.isNotBlank(currMenuName)){
			request.setAttribute("currMenuName", URLDecoder.decode(currMenuName, "utf-8"));
		}
		if(StringUtils.isNotBlank(fMenuName)){
			request.setAttribute("fMenuName", URLDecoder.decode(fMenuName, "utf-8"));
		}
		
		if(StringUtils.isNotBlank(fMenuUrl)){
			request.setAttribute("fMenuUrl", URLDecoder.decode(fMenuUrl, "utf-8"));
		}
		String start = request.getParameter("page");
		String limit = request.getParameter("limit");
		
		if(StringUtils.isBlank(start)){
			start = "1";
		}
		if(StringUtils.isBlank(limit)){
			limit = "10";
		}
		if(StringUtils.isNotEmpty(start) && StringUtils.isNotEmpty(limit)){
			pageBounds=new PageBounds(Integer.valueOf(start), Integer.valueOf(limit));
		}
	}
	
	public TSysAdmin getCurrUser(){
		if(session.getAttribute(Constants.CURRENT_USER)!=null){
			return (TSysAdmin)session.getAttribute(Constants.CURRENT_USER);
		}
		return null;
	}
}
