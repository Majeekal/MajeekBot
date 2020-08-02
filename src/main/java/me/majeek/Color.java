package me.majeek;

public enum Color {
    GREEN(new java.awt.Color(67, 181, 129)),
    YELLOW(new java.awt.Color(255, 255, 0)),
    RED(new java.awt.Color(255, 71, 15));

    private java.awt.Color color;

    Color(java.awt.Color color){
        this.color = color;
    }

    public java.awt.Color getColor() {
        return color;
    }
}
