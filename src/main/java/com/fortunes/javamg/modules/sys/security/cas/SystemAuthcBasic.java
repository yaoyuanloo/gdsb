package com.fortunes.javamg.modules.sys.security.cas;

import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

public class SystemAuthcBasic extends BasicHttpAuthenticationFilter {

	public String getApplicationName() {
		return "SystemAuthcBasic";
	}
}
