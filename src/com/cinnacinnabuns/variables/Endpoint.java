package com.cinnacinnabuns.variables;

import com.cinnacinnabuns.Variable;

public class Endpoint extends Variable {

    public Endpoint(Variable parent, Object object, String name) {
        super(parent, object, name);
    }

    @Override
    public String toString() {
        return name + " : " + object;
    }
}
