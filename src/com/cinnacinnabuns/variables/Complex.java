package com.cinnacinnabuns.variables;

import com.cinnacinnabuns.Variable;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Complex extends Variable {

    public Complex(Variable parent, Object object, String name) {
        super(parent, object, name);

        //  Collect nonstatic fields (get all fields, filter out statics, collect as list)
        List<Field> nonstaticFields = Arrays.stream(object.getClass().getDeclaredFields())
                .filter(field -> !Modifier.isStatic(field.getModifiers()))
                .collect(Collectors.toList());

        subVariables = new ArrayList<>(nonstaticFields.size());
        for (Field field : nonstaticFields) {
            field.setAccessible(true);
            try {
                subVariables.add(Variable.fromObject(
                        this,
                        field.get(object),
                        field.getName()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
