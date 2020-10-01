package com.cinnacinnabuns.variables;

import com.cinnacinnabuns.Variable;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Type constituted of the supported Collexion types.
 * Use findCollexionType() to check if an object is of a supported type (unsupported returns null.)
 */
public enum CollexionType {
    ARRAY(Object[].class, new CollexionMapper() {
        @Override
        public void mapCollexion(Collexion collexionObject, List<Variable> subVariables) {
            Object[] castCollection = (Object[]) collexionObject.getObject();
            int index = 0;
            for (Object collectionElement : castCollection) {
                subVariables.add(Variable.fromObject(
                        collexionObject,
                        collectionElement,
                        Integer.toString(index)
                ));
                index++;
            }
        }
    }),
    COLLECTION(Collection.class, new CollexionMapper() {
        @Override
        public void mapCollexion(Collexion collexionObject, List<Variable> subVariables) {
            Collection<?> castCollection = (Collection<?>) collexionObject.getObject();
            int index = 0;
            for (Object collectionElement : castCollection) {
                subVariables.add(Variable.fromObject(
                        collexionObject,
                        collectionElement,
                        Integer.toString(index)
                ));
                index++;
            }
        }
    }),
    MAP(Map.class, new CollexionMapper() {
        @Override
        public void mapCollexion(Collexion collexionObject, List<Variable> subVariables) {
            Map<?, ?> castCollection = (Map<?, ?>) collexionObject.getObject();
            castCollection.forEach((key, value) -> {
                subVariables.add(Variable.fromObject(
                        collexionObject,
                        value,
                        key.toString()
                ));
            });
        }
    })
    ;

    Class<?> underlyingCollectionType;
    CollexionMapper mapper;

    CollexionType(Class<?> underlyingCollectionType, CollexionMapper mapper) {
        this.underlyingCollectionType = underlyingCollectionType;
        this.mapper = mapper;
    }

    public static CollexionType findCollexionType(Object object) {
        for (CollexionType collexionType : CollexionType.values()) {
            if (collexionType.underlyingCollectionType.isInstance(object)) {
                return collexionType;
            }
        }
        return null;
    }
}
