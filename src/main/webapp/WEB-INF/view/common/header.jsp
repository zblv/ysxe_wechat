<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>
<div class='navbar'>
        <div class='navbar-inner'>
            <div class='container-fluid'>
                <a class='brand' href='javascript:void(0);'>
                    <i class='icon-heart-empty'></i>
                    <span class='hidden-phone'>Bravo</span>
                </a>
                <a class='toggle-nav btn pull-left' href='#'>
                    <i class='icon-reorder'></i>
                </a>
                <ul class='nav pull-right'>
                    
                    <li class='dropdown dark user-menu'>
                        <a class='dropdown-toggle' data-toggle='dropdown' href='#'>
                            <img alt='Mila Kunis' height='23' src='${basePath }assets/images/avatar.jpg' width='23' />
                            <span class='user-name hidden-phone'>${currUser.userName}</span>
                            <b class='caret'></b>
                        </a>
                        <ul class='dropdown-menu'>
                            <li>
                                <a href="javascript:alert('即将开放');">
                                    <i class='icon-user'></i>
                                  	  用户中心
                                </a>
                            </li>
                            <li>
                                <a href="javascript:alert('即将开放');">
                                    <i class='icon-cog'></i>
                                    	个性设置
                                </a>
                            </li>
                            <li class='divider'></li>
                            <li>
                                <a href='${basePath }logout'>
                                    <i class='icon-signout'></i>
                                  	退&nbsp;&nbsp;&nbsp;&nbsp;出
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>