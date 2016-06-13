package com.ys.wechat.util;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.miemiedev.mybatis.paginator.domain.PageList;


@SuppressWarnings("serial")
public class PageListJsonMapperTwo extends ObjectMapper{
	
	public PageListJsonMapperTwo(){
		 SimpleModule module = new SimpleModule("PageListJSONModule", new Version(1, 0, 0, null, null, null));
		 module.addSerializer(PageList.class, new PageListJsonSerializerTwo());
		 registerModule(module);
	}
	//日期格式化
	public PageListJsonMapperTwo(String dateFormatString){
		SimpleModule module = new SimpleModule("PageListJSONModule",new Version(1, 0, 0, null, null, null));
		PageListJsonSerializerTwo pt = new PageListJsonSerializerTwo();
		pt.setDateFormatString(dateFormatString);
		module.addSerializer(PageList.class, pt);
		registerModule(module);
	}
}
