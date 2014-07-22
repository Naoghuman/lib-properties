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

import de.pro.lib.properties.PRoProperties;

/**
 *
 * @author PRo
 */
public final class PropertiesFactory {
    
    private static IProperties instance = null;
    
    public static IProperties getDefault() {
        
        if (instance == null) {
            instance = new PRoProperties();
        }
        
        return instance;
    }
    
    private PropertiesFactory() { }
}
