package com.ys.wechat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuVo extends TSysMenu implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean open = true;
	
	private boolean checked = false;
	
	private List<MenuVo> subMenuVos = new ArrayList<MenuVo>(0);
	
	public List<MenuVo> getSubMenuVos() {
		return subMenuVos;
	}

	public void setSubMenuVos(List<MenuVo> subMenuVos) {
		this.subMenuVos = subMenuVos;
	}
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TSysMenu other = (TSysMenu) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}