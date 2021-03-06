/*
 * Copyright (c) 2013-2018 GraphAware
 *
 * This file is part of the GraphAware Framework.
 *
 * GraphAware Framework is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */
package com.graphaware.nlp.dsl.request;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.graphaware.nlp.dsl.request.RequestConstants.*;
import java.util.HashMap;
import org.neo4j.graphdb.Node;

public class ComputeVectorRequest extends AbstractProcedureRequest {

    private static String DEFAULT_TYPE = "query";
    private static String DEFAULT_PROPERTY = "vector";
    private static Map<String, Object> DEFAULT_PARAMETERS = new HashMap<>();
    
    private Node input;
    private String type;
    private Map<String, Object> parameters;
    private String propertyName;
    private String label;
    
    public ComputeVectorRequest() {
    }

    public ComputeVectorRequest(Node input, String type, Map<String, Object> parameters, String propertyName) {
        this.input = input;
        this.type = type;
        this.parameters = parameters;
        this.propertyName = propertyName;
    }

    public Node getInput() {
        return input;
    }

    public void setInput(Node input) {
        this.input = input;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    
    @Override
    public List<String> validMapKeys() {
        return Arrays.asList(
                NODE_KEY,
                TYPE_KEY,
                PARAMETERS_KEY,
                PROPERTY_KEY,
                LABEL_KEY
        );
    }

    @Override
    public List<String> mandatoryKeys() {
        return Arrays.asList(
                NODE_KEY
        );
    }

    public static ComputeVectorRequest fromMap(Map<String, Object> map) {
        ComputeVectorRequest request = new ComputeVectorRequest();
        request.setInput((Node)map.get(NODE_KEY));
        String type = (String)map.get(TYPE_KEY);
        if (type == null) {
            type = DEFAULT_TYPE;
        }
        request.setType(type);
        String property = (String)map.get(PROPERTY_KEY);
        if (property == null) {
            property = DEFAULT_PROPERTY;
        }
        request.setPropertyName(property);   
        Map parameters = (Map)map.get(PARAMETERS_KEY);
        if (parameters == null) {
            parameters = DEFAULT_PARAMETERS;
        }
        request.setLabel((String)map.getOrDefault(LABEL_KEY, null));
        request.setParameters(parameters);        
        request.validateMap(map);
        return request;
    }
}
