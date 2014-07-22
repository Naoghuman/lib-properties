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

import de.pro.lib.logger.api.LoggerFactory;
import de.pro.lib.properties.api.IProperties;
import java.io.IOException;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 *
 * @author PRo
 */
public class PRoProperties implements IProperties {
    
    private final ObservableMap<String, Properties> allProperties = FXCollections.observableHashMap();

    public PRoProperties() {
    }

    @Override
    public String getProperty(String pathWithBundle, String key) {
        return allProperties.get(pathWithBundle).getProperty(key);
    }

    @Override
    public String getProperty(String pathWithBundle, String key, String defaultValue) {
        return allProperties.get(pathWithBundle).getProperty(key, defaultValue);
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
            
            LoggerFactory.getDefault().debug(this.getClass(),
                    String.format("Load properties: %s", pathWithBundle)); // NOI18N
        } catch (IOException ex) {
            LoggerFactory.getDefault().error(this.getClass(),
                    String.format("Can't load properties: %s", pathWithBundle), ex); // NOI18N
        }
    }
}
