class Color {
    private int red;
    private int green;
    private int blue;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public boolean isBlue() {
        return red == 0 && green == 0 && blue == 255;
    }

    public boolean isRed() {
        return red == 255 && green == 0 && blue == 0;
    }

    public boolean isGreen() {
        return red == 0 && green == 255 && blue == 0;
    }

    public boolean isYellow() {
        return red == 255 && green == 255 && blue == 0;
    }

    public boolean isMagenta() {
        return red == 255 && green == 0 && blue == 255;
    }

    public boolean isCyan() {
        return red == 0 && green == 255 && blue == 255;
    }

    public boolean isBlack() {
        return red == 0 && green == 0 && blue == 0;
    }

    public boolean isWhite() {
        return red == 255 && green == 255 && blue == 255;
    }

    public boolean isGray() {
        return red == green && green == blue;
    }

    public boolean isDark() {
        return red < 128 && green < 128 && blue < 128;
    }

    public boolean isLight() {
        return red >= 128 && green >= 128 && blue >= 128;
    }

    public String toString() {
        return "(" + red + ", " + green + ", " + blue + ")";
    }

}
