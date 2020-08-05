package com.lee.ajax.menu;

import java.util.List;

public interface MenuMapper {
	public abstract List<Menu> searchMenu(Menu m);
	public abstract List<Menu> getAllMenu();
	
}
