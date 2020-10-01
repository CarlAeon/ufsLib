package com.cinnacinnabuns.variables;

import com.cinnacinnabuns.Variable;

import java.util.List;

public interface CollexionMapper {

    /**
     * Function that maps elements of a Collexion to a List<Variable>, which is used to instantiate the Collexion itself.
     * The subVariables item is dependably an empty object.
     * @param collexionObject The underlying Collexion object to map the elements of.
     * @param subVariables The list to map the elements to.
     */
    void mapCollexion(Collexion collexionObject, List<Variable> subVariables);
}
