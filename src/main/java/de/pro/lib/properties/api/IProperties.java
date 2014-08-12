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

package de.pro.lib.properties.api;

/**
 * The <code>Interface</code> for the class <code>de.pro.lib.properties.PRoProperties</code>.
 * Over the factory <code>de.pro.lib.properties.api.PropertiesFactory</code> you can 
 * access the methods in this <code>Interface</code>.
 *
 * @author PRo
 * @see de.pro.lib.properties.PRoProperties
 * @see de.pro.lib.properties.api.PropertiesFactory
 */
public interface IProperties {
    /**
     * Searches for the property with the specified key in this property list.
     * If the key is not found in this property list, the default property list,
     * and its defaults, recursively, are then checked. The method returns
     * {@code null} if the property is not found.
     * 
     * @param pathWithBundle The properties where value is stored.
     * @param key The property key.
     * @return The value in this property list with the specified key value.
     */
    public String getProperty(String pathWithBundle, String key);
    
    /**
     * Searches for the property with the specified key in this property list.
     * If the key is not found in this property list, the default property list,
     * and its defaults, recursively, are then checked. The method returns the
     * default value argument if the property is not found.
     * 
     * @param pathWithBundle The properties where value is stored.
     * @param key The property key.
     * @param defaultValue If the key-value pair not stored in the properties
     * then the <code>defaultValue</code> will be returned.
     * @return The value in this property list with the specified key value.
     */
    public String getProperty(String pathWithBundle, String key, String defaultValue);
    
    /**
     * Register with this method your <code>.properties</code> file. The parameter 
     * <code>pathWithBundle</code> have the format:<br />
     * <code>/your/package/path/to/your/FileToLoad.properties</code><br /><br />
     * 
     * The file should be in the <code>src/main/resources</code> folder with the 
     * previous named packaged structur in the specific maven module.
     * 
     * @param pathWithBundle The properties which should be register. If the 
     * properties always register nothing happen.
     */
    public void register(String pathWithBundle);
}
