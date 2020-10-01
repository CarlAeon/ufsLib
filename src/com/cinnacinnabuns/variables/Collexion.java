package com.cinnacinnabuns.variables;

import com.cinnacinnabuns.Variable;

import java.util.ArrayList;

public class Collexion extends Variable {
    public Collexion(Variable parent, Object object, String name) {
        super(parent, object, name);

        CollexionType collexionType = CollexionType.findCollexionType(object);
        assert collexionType != null;
        this.subVariables = new ArrayList<>();
        collexionType.mapper.mapCollexion(this, this.subVariables);
    }
}