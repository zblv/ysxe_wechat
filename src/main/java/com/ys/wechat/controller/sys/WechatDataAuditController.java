package com.ys.wechat.controller.sys;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ys.wechat.controller.base.BaseController;
import com.ys.wechat.controller.common.InvokeResult;
import com.ys.wechat.model.TWechatDataAudit;
import com.ys.wechat.model.TWechatMenu;
import com.ys.wechat.service.TWechatDataAuditService;
import com.ys.wechat.service.TWechatMenuService;
import com.ys.wechat.util.WechatUtil;

@Controller
@RequestMapping(value="/system/data")
public class WechatDataAuditController extends BaseController{
private static Logger log = Logger.getLogger(WechatDataAuditController.class.getName());
	
	@Autowired
	private TWechatDataAuditService wechatDataAuditService;
	
	/**
	 * 
	 * @Description:审核资料，拥有资料审核最高权限
	 *
	 * @author 吕志博
	 * @date 2016-5-30 上午10:21:28
	 * @version V1.0
	 * @return
	 */
	@RequestMapping(value = "/shInit")
	public String shInit(){
		List<TWechatDataAudit> wechatDataAudits = wechatDataAuditService.selectAll(null);
		request.setAttribute("wechatDataAudits",wechatDataAudits);
		return "data/sh_data_edit";
	}
	
	/**
	 * 
	 * @Description:只能查看已审核通过的资料
	 *
	 * @author 吕志博
	 * @date 2016-5-30 上午10:22:03
	 * @version V1.0
	 * @return
	 */
	@RequestMapping(value = "/yshInit")
	public String yshInit(){
		List<TWechatDataAudit> wechatDataAudits = wechatDataAuditService.selectAll("open");
		request.setAttribute("wechatDataAudits",wechatDataAudits);
		return "data/ysh_data_edit";
	}
	
	
	
	/**
	 * 
	 * @Description:可查看所有上传的资料但是无权进行操作
	 *
	 * @author 吕志博
	 * @date 2016-5-30 上午10:22:34
	 * @version V1.0
	 * @return
	 */
	@RequestMapping(value = "/syInit")
	public String syInit(){
		List<TWechatDataAudit> wechatDataAudits = wechatDataAuditService.selectAll(null);
		request.setAttribute("wechatDataAudits",wechatDataAudits);
		return "data/sy_data_edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateDataState")
	public InvokeResult updateDataState(Long id,String state){
		log.info("管理员："+getCurrUser().getRelName()+"审核编号为："+id+"的资料审核结果："+state);
		TWechatDataAudit wechatDataAudit = wechatDataAuditService.selectByPrimaryKey(id);
		if (wechatDataAudit != null) {
			wechatDataAudit.setAuditPeople(getCurrUser().getRelName());
			wechatDataAudit.setState(state);
			wechatDataAuditService.updateByPrimaryKey(wechatDataAudit);
			return new InvokeResult().returnSuccess(null);
		}else {
			return new InvokeResult().returnError("修改失败：未找到对应记录");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateData")
	public InvokeResult updateData(TWechatDataAudit wechatDataAudit){
		if (wechatDataAudit != null) {
			log.info("管理员："+getCurrUser().getRelName()+"修改编号为："+wechatDataAudit.getId()+"的资料");
			wechatDataAudit.setAuditPeople(getCurrUser().getRelName());
			wechatDataAuditService.updateByPrimaryKey(wechatDataAudit);
			return new InvokeResult().returnSuccess("修改成功");
		}else {
			return new InvokeResult().returnError("修改失败：未找到对应记录");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/delData")
	public InvokeResult delData(Long id){
		
		if (id != null) {
			TWechatDataAudit wechatDataAudit = wechatDataAuditService.selectByPrimaryKey(id);
			if (wechatDataAudit != null ) {
				 wechatDataAuditService.delById(id);
//				 String[] srcs = wechatDataAudit.getImgNames().split(",");
//				 for (int i = 0; i < srcs.length; i++) {
//					 System.out.println(WechatUtil.FILESRC+srcs[i]);
//					 File file = new File(WechatUtil.FILESRC+srcs[i]);
//					   if(file.exists())	file.delete();
//				}
				 return new InvokeResult().returnSuccess("成功");
			}else return new InvokeResult().returnError("删除失败：未找到对应记录");
			
		}else return new InvokeResult().returnError("删除失败：未找到对应记录");
	}
}
