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
 *
 * @author PRo
 */
public interface IProperties {
    public String getProperty(String pathWithBundle, String key);
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