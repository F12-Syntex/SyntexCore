package com.base.config;

import com.base.main.Base;

public class Permissions extends Config{

	public String basic = "bukkit.command.help";
	public String admin = "base.admin";
	public String bypass = "base.timer.bypass";
	public String reload = "base.admin.reload";
	public String configure = "base.admin.configure";
	
	public Permissions(String name, double version) {
		super(name, version);
		
		this.items.add(new ConfigItem("Permissions.everyone.basic", basic));
		this.items.add(new ConfigItem("Permissions.administration.admin", admin));
		this.items.add(new ConfigItem("Permissions.administration.timer_bypass", bypass));
		this.items.add(new ConfigItem("Permissions.administration.reload", reload));
		this.items.add(new ConfigItem("Permissions.administration.configure", configure));
	}

	@Override
	public Configuration configuration() {
		// TODO Auto-generated method stub
		return Configuration.PERMISSIONS;
	}
	
	@Override
	public void initialize() {
		this.basic = this.getConfiguration().getString("Permissions.everyone.basic").replace("%prefix%", Base.getInstance().configManager.messages.prefix);
		this.admin = this.getConfiguration().getString("Permissions.administration.admin").replace("%prefix%", Base.getInstance().configManager.messages.prefix);
		this.bypass = this.getConfiguration().getString("Permissions.administration.timer_bypass").replace("%prefix%", Base.getInstance().configManager.messages.prefix);
		this.reload = this.getConfiguration().getString("Permissions.administration.reload").replace("%prefix%", Base.getInstance().configManager.messages.prefix);
		this.configure = this.getConfiguration().getString("Permissions.administration.configure").replace("%prefix%", Base.getInstance().configManager.messages.prefix);
	}


	
}
