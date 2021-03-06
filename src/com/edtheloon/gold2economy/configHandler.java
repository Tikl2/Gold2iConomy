package com.edtheloon.gold2economy;

import java.io.File;

import org.bukkit.plugin.Plugin;
import org.bukkit.util.config.Configuration;

public class configHandler {
	
	// Configuration file properties
	private Plugin plugin;
	private File configFile = new File("plugins/Gold2Economy" + File.separator + "config.yml");
	private Configuration config;
	
	// Default conversion rate
	public Double cRate = 29.99;
	public boolean iConomy;
	public boolean BOSEconomy;
	public boolean usePermissions;
	
	// CONSTRUCTOR 
	public configHandler(Plugin _plugin) {
		this.plugin = _plugin;
		this.config = new Configuration(configFile);
	}
	
	// Check to see if config exists, returns true or false
	public boolean checkConfig() {
		if (!configFile.exists())
		{
			return false;
		} else {
			return true;
		}
	}
	
	// Create the configuration file and insert default values
	public void createConfig() {
		config.setProperty("rate", cRate);
		config.setProperty("permissions", false);
		config.setProperty("economy.iConomy", true);
		config.setProperty("economy.BOSEconomy", false);
		config.setHeader("# Gold2Economy Version " + plugin.getDescription().getVersion());
		config.save();
		
		// Now that Config is created we can load the values
		loadConfig();
	}
	
	// Load configuration file
	public void loadConfig() {
		config.load();
		cRate = config.getDouble("rate", 29.99);
		usePermissions = config.getBoolean("permissions", false);
		iConomy = config.getBoolean("economy.iConomy", true);
		BOSEconomy = config.getBoolean("economy.BOSEconomy", false);
	}
}
