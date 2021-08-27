package com.base.config;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigManager {

    public ArrayList<Config> config = new ArrayList<Config>();
	
    public Messages messages;
    public Permissions permissions;
    public Cooldown cooldown;
    public Configs configs;
    
    public void setup(Plugin plugin) {
    	
    	this.messages = new Messages("messages", 1.0);
    	this.permissions = new Permissions("permissions", 1.0);
    	this.cooldown = new Cooldown("cooldown", 1.0);
    	this.configs = new Configs("configs", 1.0);
    	
    	this.config.clear();

    	this.config.add(messages);
    	this.config.add(permissions);
    	this.config.add(cooldown);
    	this.config.add(configs);
    	
    	for(int i = 0; i < config.size(); i++) {
    		
    		config.get(i).setup();
    		
    		if(config.get(i).getConfiguration().contains("identity.version") && (config.get(i).getConfiguration().getDouble("identity.version") == config.get(i).getVerison())) {
    			config.get(i).initialize();
        		continue;
    		}
    		
   				File file = config.get(i).backup();
   				
   				new File(plugin.getDataFolder(), config.get(i).getName() + ".yml").delete();
    			plugin.saveResource(config.get(i).getName() + ".yml", false);
       		
       			if(file != null) {
   					final FileConfiguration oldConfig = YamlConfiguration.loadConfiguration(file);
   					
   					final int index = i;
   		       		
   					oldConfig.getKeys(true).forEach(o -> {
   						if(config.get(index).getConfiguration().contains(o)) {
   							config.get(index).getConfiguration().set(o, oldConfig.get(o));
   						}
   					});
   		    
   					config.get(i).setDefault();
   					
   		    		config.get(index).getConfiguration().set("identity.version", config.get(i).getVerison());
   					
   		    		config.get(index).save();
   		    		config.get(index).initialize();
   		    		
   				}

    	}
    	
    	
    }
	
    
    public Config getConfig(Configuration configuration) {
    	return config.stream().filter(i -> i.configuration() == configuration).findFirst().get();
    }

}
