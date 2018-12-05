/*
 * Copyright (C) 2014 Naoghuman
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
package com.github.naoghuman.lib.properties.internal;

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.properties.core.SimpleProperties;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * The {@code Implementation} from the {@code Interface} 
 * {@link com.github.naoghuman.lib.properties.core.SimpleProperties}.
 * <p>
 * Access to the methods from this default {@code Implementation} can be done over 
 * the facade {@link com.github.naoghuman.lib.properties.core.PropertiesFacade}.
 * 
 * @since   0.5.1
 * @version 0.6.0
 * @author  Naoghuman
 * @see com.github.naoghuman.lib.properties.core.PropertiesFacade
 * @see com.github.naoghuman.lib.properties.core.SimpleProperties
 */
public final class DefaultSimpleProperties implements SimpleProperties {
    
    private final ObservableMap<String, Properties> allProperties = FXCollections.observableHashMap();

    @Override
    public String getProperty(final String pathWithBundle, final String key) {
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(pathWithBundle);
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(key);
        
        return allProperties.get(pathWithBundle).getProperty(key);
    }

    @Override
    public String getProperty(final String pathWithBundle, final String key, final String defaultValue) {
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(pathWithBundle);
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(key);
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(defaultValue);
        
        return allProperties.get(pathWithBundle).getProperty(key, defaultValue);
    }
    
    @Override
    public String getSystemProperty(final String key) throws SecurityException, NullPointerException, IllegalArgumentException {
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(key);
        
        return System.getProperty(key);
    }

    @Override
    public Boolean isSystemProperty(final String key, final String value) throws SecurityException, NullPointerException, IllegalArgumentException {
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(key);
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(value);
        
        if (this.getSystemProperty(key) == null) {
            return Boolean.FALSE;
        }
        
        if (this.getSystemProperty(key).equals(value)) {
            return Boolean.TRUE;
        }
        
        return Boolean.FALSE;
    }

    @Override
    public void register(final String pathWithBundle) {
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(pathWithBundle);
        
        if (allProperties.containsKey(pathWithBundle)) {
            return;
        }
        
        try {
            final Properties properties = new Properties();
            properties.load(this.getClass().getResourceAsStream(pathWithBundle));
            allProperties.put(pathWithBundle, properties);
            
            LoggerFacade.getDefault().own(this.getClass(),
                    String.format("Load properties: %s", pathWithBundle)); // NOI18N
        } catch (IOException ex) {
            LoggerFacade.getDefault().error(this.getClass(),
                    String.format("Can't load properties: %s", pathWithBundle), ex); // NOI18N
        }
    }

    @Override
    public void register(final ArrayList<String> pathWithBundles) {
        DefaultSimplePropertiesValidator.requireNonNull(pathWithBundles);
        
        pathWithBundles.forEach(pathWithBundle -> {
            this.register(pathWithBundle);
        });
    }

    @Override
    public void registerSystemProperties(final String regex, final List<String> unnamed) throws SecurityException, NullPointerException, IllegalArgumentException {
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(regex);
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(unnamed);
        
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
    public void setSystemProperty(final String key, final String value) throws SecurityException, NullPointerException, IllegalArgumentException {
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(key);
        DefaultSimplePropertiesValidator.requireNonNullAndNotEmpty(value);
        
        System.setProperty(key, value);
    }
    
    
}
