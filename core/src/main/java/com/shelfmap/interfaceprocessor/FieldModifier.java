package com.shelfmap.interfaceprocessor;

/**
 * Access modifier for a field.
 * @author Tsutomu YANO
 */
public enum FieldModifier {
    PRIVATE("private"), DEFAULT(""), PROTECTED("protected");

    @lombok.Getter private String modifier;

    private FieldModifier(String modifier) {
        this.modifier = modifier;
    }
}
