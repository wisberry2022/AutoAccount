package org.program.ui;

import javax.swing.*;
import java.awt.*;

public class LayoutFactory {

    private static final Panel pManager = new Panel();

    public static LayoutManager getGridBagLayout() {
        LayoutManager grid = new GridBagLayout();
        return grid;
    }

    public static LayoutManager getGridLayout(int rows, int cols) {
        LayoutManager grid = new GridLayout(rows,cols);
        return grid;
    }

}
