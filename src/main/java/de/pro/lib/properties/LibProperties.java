/*
 * Copyright (C) 2014 PRo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.pro.lib.properties;

import de.pro.lib.logger.api.LoggerFacade;
import de.pro.lib.properties.api.ILibProperties;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * The implementation from the Interface {@link de.pro.lib.properties.api.ILibProperties}.<br />
 * Access to this class is over the facade {@link de.pro.lib.properties.api.PropertiesFacade}.
 * 
 * @author PRo
 * @see de.pro.lib.properties.api.ILibProperties
 * @see de.pro.lib.properties.api.PropertiesFacade
 */
public class LibProperties implements ILibProperties {
    
    private final ObservableMap<String, Properties> allProperties = FXCollections.observableHashMap();

    @Override
    public String getProperty(String pathWithBundle, String key) {
        return allProperties.get(pathWithBundle).getProperty(key);
    }

    @Override
    public String getProperty(String pathWithBundle, String key, String defaultValue) {
        return allProperties.get(pathWithBundle).getProperty(key, defaultValue);
    }
    
    @Override
    public String getSystemProperty(String key) throws SecurityException, NullPointerException, IllegalArgumentException {
        return System.getProperty(key);
    }

    @Override
    public Boolean isSystemProperty(String key, String value) throws SecurityException, NullPointerException, IllegalArgumentException {
        if (this.getSystemProperty(key) == null) {
            return Boolean.FALSE;
        }
        
        if (this.getSystemProperty(key).equals(value)) {
            return Boolean.TRUE;
        }
        
        return Boolean.FALSE;
    }

    @Override
    public void register(String pathWithBundle) {
        if (allProperties.containsKey(pathWithBundle)) {
            return;
        }
        
        try {
            final Properties properties = new Properties();
            properties.load(this.getClass().getResourceAsStream(pathWithBundle));
            allProperties.put(pathWithBundle, properties);
            
            LoggerFacade.INSTANCE.getLogger().own(this.getClass(),
                    String.format("Load properties: %s", pathWithBundle)); // NOI18N
        } catch (IOException ex) {
            LoggerFacade.INSTANCE.getLogger().error(this.getClass(),
                    String.format("Can't load properties: %s", pathWithBundle), ex); // NOI18N
        }
    }

    @Override
    public void registerSystemProperties(String regex, List<String> unnamed) throws SecurityException, NullPointerException, IllegalArgumentException {
        if (unnamed.isEmpty()) {
            return;
        }
        
        for (String systemProperty : unnamed) {
            final String[] split = systemProperty.split(regex);
            if (split.length != 2) {
                return;
            }
            
            System.setProperty(split[0], split[1]);
        }
    }

    @Override
    public void setSystemProperty(String key, String value) throws SecurityException, NullPointerException, IllegalArgumentException {
        System.setProperty(key, value);
    }
    
}
