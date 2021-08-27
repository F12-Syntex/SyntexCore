package com.base.config;

import java.util.List;

import com.base.utils.ComponentBuilder;
import com.base.utils.MessageUtils;

public class Messages extends Config{

	public String prefix = "&7[&cBase&7]";
	public String error = "%prefix% sorry an error has accured!";;
	public String invalid_syntax = "%prefix% &cInvalid syntax";
	public String invalid_permission = "%prefix% &cYou cant do that!";
	public String invalid_entitiy = "%prefix% &cplayers only!";
	public String invalid_help_command = "%prefix% &c%command% is not a command!";
	public String invalid_configure_command = "%prefix% &c%config% is not a valid config!";
	public List<String> help_format = ComponentBuilder.createLore("%prefix% &b%command%&7: &c%description%", "%prefix% &bpermissions&7: &c%permission%");

	public Messages(String name, double version) {
		super(name, version);
		
		this.items.add(new ConfigItem("Messages.prefix", prefix));
		this.items.add(new ConfigItem("Messages.error", error));
		this.items.add(new ConfigItem("Messages.invalid_syntax", invalid_syntax));
		this.items.add(new ConfigItem("Messages.invalid_permission", invalid_permission));
		this.items.add(new ConfigItem("Messages.invalid_entitiy", invalid_entitiy));
		this.items.add(new ConfigItem("Messages.help.invalid_command", invalid_help_command));
		this.items.add(new ConfigItem("Messages.configure.invalid_command", invalid_configure_command));
		this.items.add(new ConfigItem("Messages.help.command_help_format", help_format));
		
		
	}

	@Override
	public Configuration configuration() {
		// TODO Auto-generated method stub
		return Configuration.MESSAGES;
	}
	
	@Override
	public void initialize() {
		this.prefix = MessageUtils.translateAlternateColorCodes(this.getConfiguration().getString("Messages.prefix"));
		this.error = MessageUtils.translateAlternateColorCodes(this.getConfiguration().getString("Messages.error").replace("%prefix%", prefix));
		this.invalid_syntax = MessageUtils.translateAlternateColorCodes(this.getConfiguration().getString("Messages.invalid_syntax").replace("%prefix%", prefix));
		this.invalid_permission = MessageUtils.translateAlternateColorCodes(this.getConfiguration().getString("Messages.invalid_permission").replace("%prefix%", prefix));
		this.invalid_entitiy = MessageUtils.translateAlternateColorCodes(this.getConfiguration().getString("Messages.invalid_entitiy").replace("%prefix%", prefix));
		this.invalid_help_command = MessageUtils.translateAlternateColorCodes(this.getConfiguration().getString("Messages.help.invalid_command").replace("%prefix%", prefix));
		this.help_format = ComponentBuilder.createLore(this.getConfiguration().getStringList("Messages.help.command_help_format"));
		this.invalid_configure_command = MessageUtils.translateAlternateColorCodes(this.getConfiguration().getString("Messages.configure.invalid_command").replace("%prefix%", prefix));
		
	}


	
}
