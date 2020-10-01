package com.cinnacinnabuns;

import com.cinnacinnabuns.variables.*;

import java.util.List;

public abstract class Variable {

    protected Variable parent;
    protected Object object;
    protected String name;
    protected List<Variable> subVariables;

    public Variable getParent() {
        return parent;
    }

    public Object getObject() {
        return object;
    }

    public String getName() {
        return name;
    }

    public List<Variable> getSubVariables() {
        return subVariables;
    }

    public static Variable fromObject(Variable parent, Object object, String name) {
        //  TODO: Order is important here. We probably shouldn't depend on it, but I don't know a better way atm.
        //  Check Collexion
        if (CollexionType.findCollexionType(object) != null) {
            return new Collexion(parent, object, name);
        }
        //  Check Endpoint
        else if (EndpointType.findEndpointType(object) != null) {
            return new Endpoint(parent, object, name);
        }
        //  Otherwise Complex
        else {
            return new Complex(parent, object, name);
        }
    }

    public Variable(Variable parent, Object object, String name) {
        this.parent = parent;
        this.object = object;
        this.name = name;
    }

    void print(int indentLevel) {
        System.out.println("\t".repeat(indentLevel) + this);
        if (subVariables != null)
            for (Variable subVariable : subVariables) {
                subVariable.print(indentLevel + 1);
            }
    }

    @Override
    public String toString() {
        return name + " (" + object.getClass().getSimpleName() + ")";
    }
}
