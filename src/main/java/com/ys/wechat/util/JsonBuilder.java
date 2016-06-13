package com.ys.wechat.util;

import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




/**
 * 
 * Copyright: Copyright (c) 2016 
 * Company:深圳前海银盛互联网金融服务有限公司
 * 
 * @Description:Json数据 工具类
 *
 * @author 吕志博
 * @date 2016-3-8 上午10:52:31
 * @version V1.0
 */
public class JsonBuilder {
	
	/**
	 * 得到JsonBuilder实例化对象
	 * 
	 * @return
	 */
	public static JsonBuilder getInstance() {
		return JsonHolder.JSON_BUILDER;
	}

	/**
	 * 静态内部类
	 * 
	 * 
	 */
	private static class JsonHolder {
		private static final JsonBuilder JSON_BUILDER = new JsonBuilder();
		private static PageListJsonMapperTwo mapper = new PageListJsonMapperTwo();
	}

	/**
	 * 将一个数据实体解析成Json数据格式
	 * 
	 * @param obj
	 * @return
	 */
	public String toJson(Object obj) {
		try {
			DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			JsonHolder.mapper.setDateFormat(dateFormat);
			
			return JsonHolder.mapper.writeValueAsString(obj);
		} catch (Exception e) {
			return "";
		}
	}
	
	public String toJson(Object obj,String dateFmt) {
		try {
			PageListJsonMapperTwo pmt = new PageListJsonMapperTwo(dateFmt);
			return pmt.writeValueAsString(obj);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 将一个Json字符串封装为指定类型对象
	 * 
	 * @param json
	 * @param c
	 * @return
	 */
	public Object fromJson(String json, Class<?> c) {
		json = cleanJson(json);
		try {
			Object obj = JsonHolder.mapper.readValue(json, c);
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将一个JsonArray数据转换成一个List的键值对 [{name:'zsp',value:1},{name:'zsp',value:2}]
	 * 
	 * @param json
	 * @return
	 */
	// @SuppressWarnings({ "rawtypes", "unchecked" })
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map> fromJsonArray(String json) {
		json = cleanJson(json);
		List<Map> dataList = (List<Map>) fromJson(json, ArrayList.class);

		return dataList;
	}

	/**
	 * 为操作成功返回Json
	 * 
	 * @param strData
	 * @return
	 */
	public String returnSuccessJson(String strData) {
		StringBuffer returnJson = new StringBuffer("{ \"success\" : true, \"obj\" :\" ");
		returnJson.append(strData);
		returnJson.append("\"}");
		return returnJson.toString();
	}

	/**
	 * 为操作失败返回Json
	 * 
	 * @param strData
	 * @return
	 */
	public String returnFailureJson(String strData) {
		StringBuffer returnJson = new StringBuffer("{ \"success\" : false, \"obj\" :\" ");
		returnJson.append(strData);
		returnJson.append("\"}");
		return returnJson.toString();
	}

	/**
	 * 为分页列表提供Json封装
	 * 
	 * @param count
	 *            记录总数
	 * @param entities
	 *            实体列表
	 * @param excludes
	 *            在json生成时需要排除的属性名称
	 * @return
	 */
	public String buildObjListToJson(Long count,
			Collection<? extends Object> records, boolean listJson) {
		try {
			StringBuffer pageJson = null;
			// 判断是否展示list的数据
			if (listJson) {
				pageJson = new StringBuffer("{totalCount:" + count + ","
						+ "rows" + ":");
			} else {
				pageJson = new StringBuffer("");
			}
			// 构建集合的json数据
			StringWriter w = new StringWriter();
			JsonHolder.mapper.writeValue(w, records);
			pageJson.append(w);
			w.close();

			if (listJson) {
				pageJson.append("}");
			} else {
				pageJson.append("");
			}
			return pageJson.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 格式化Json
	 * 
	 * @param json
	 * @return
	 */
	public String cleanJson(String json) {
		if (ArraysUtil.isNotEmpty(json)) {
			return json.replaceAll("\n", "");
		} else {
			return "";
		}
	}

	/**
	 * 
	 * @param jsonSql
	 *            [{sql:''},{}] ["asd","asdas"]
	 * @return
	 */
	public String[] jsonSqlToString(String jsonSql) {
		// 得到对象数据
		Object[] os = JSONArray.fromObject(jsonSql).toArray();
		String[] sqls = new String[os.length];
		for (int i = 0; i < os.length; i++) {
			// 使用JSONObject和sql键取出值
			JSONObject k = (JSONObject) os[i];
			String kk = (String) k.get("sql");
			sqls[i] = kk;
		}
		return sqls;
	}



	public static void main(String[] args) {
	
	}
}
