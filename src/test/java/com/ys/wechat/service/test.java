package com.ys.wechat.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

	/**
	 * @Description:
	 *
	 * @author 吕志博
	 * @date 2016-4-6 下午2:38:07
	 * @version V1.0
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 1;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int x = 0; x < getList().size(); x++) {
			map.put(getList().get(x), x+1);
		}
		for (int j = 0; j <  getList().size(); j++) {
			List<String> strs = getList();
			strs.remove(j);
			for (int j2 = 0; j2 < strs.size(); j2++) {
				if (map.get(getList().get(j)) - map.get(strs.get(j2)) ==1) {
					System.out.println("----------->第{"+ i++ +"}轮" );
					System.out.println(map.get(getList().get(j)) +"-"+ map.get(strs.get(j2))+"="+(map.get(getList().get(j))-map.get(strs.get(j2))));
					
					List<String> strkAll  = new ArrayList<String>();
					strkAll.addAll(strs);
					strkAll.remove(j2);
					for (int k = 0; k < strkAll.size(); k++) {
						List<String> strks = new ArrayList<String>();
						strks.addAll(strkAll);
						strks.remove(k);
						for (int l = 0; l < strks.size(); l++) {
							if (map.get(strkAll.get(k)) - map.get(strks.get(l)) ==2) {
								System.out.println(map.get(strkAll.get(k))+"-"+map.get(strks.get(l))+"="+(map.get(strkAll.get(k)) - map.get(strks.get(l))));
								
								List<String> strmAll  = new ArrayList<String>();
								strmAll.addAll(strks);
								strmAll.remove(l);
								for (int m = 0; m < strmAll.size(); m++) {
									List<String> strms = new ArrayList<String>();
									strms.addAll(strmAll);
									strms.remove(m);
									for (int n = 0; n < strms.size(); n++) {
										if (map.get(strmAll.get(m)) + map.get(strms.get(n)) ==9) {
											System.out.println(map.get(strmAll.get(m))+"+"+map.get(strms.get(n))+"="+(map.get(strmAll.get(m)) + map.get(strms.get(n))));
											
											List<String> stryAll  = new ArrayList<String>();
											stryAll.addAll(strms);
											stryAll.remove(n);
											for (int y = 0; y < stryAll.size(); y++) {
												List<String> strys = new ArrayList<String>();
												strys.addAll(stryAll);
												strys.remove(y);
												for (int o = 0; o < strys.size(); o++) {
													if (map.get(stryAll.get(y)) + map.get(strys.get(o)) ==7) {
														System.out.println(map.get(stryAll.get(y))+"+"+map.get(strys.get(o))+"="+(map.get(stryAll.get(y)) + map.get(strys.get(o))));
														System.out.println("<------>成功");
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static List<String> getList(){
		List<String> strs = new ArrayList<>();
		strs.add("a");
		strs.add("b");
		strs.add("c");
		strs.add("d");
		strs.add("e");
		strs.add("f");
		strs.add("g");
		strs.add("h");
		return strs;
	}
}
