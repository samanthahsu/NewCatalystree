package com.example.newcatalystree;

public class MapBlock {
//    private variable
    int _x;
    int _y;
    int _block;

//   empty constructor
    public MapBlock() {
    }

//    default constructor of empty tile
    public MapBlock(int _x, int _y) {
        this._x = _x;
        this._y = _y;
        this._block = 0;
    }
// all constructor
    public MapBlock(int _x, int _y, int _block) {
        this._x = _x;
        this._y = _y;
        this._block = _block;
    }

    public int get_x() {
        return _x;
    }

    public int get_y() {
        return _y;
    }

    public int get_block() {
        return _block;
    }

    public void set_x(int _x) {
        this._x = _x;
    }

    public void set_y(int _y) {
        this._y = _y;
    }

    public void set_block(int _block) {
        this._block = _block;
    }
}

//
//String CREATE_MAP_DETAIL_TABLE = "CREATE_TABLE " + TABLE_MAP_DETAIL + "(" + KEY_X_COORD + " INTEGER PRIMARY KEY, " +
//        KEY_Y_COORD + " INT," + KEY_BLOCK_TEXTURE + " INT " + ")";
//        db.
