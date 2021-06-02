package util;

import java.io.Serializable;

public class TableSize implements Serializable {
    private int size;

    public TableSize() {
        size = 0;
    }

    public TableSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
