package com.artemkot.create.tile;

import com.zhekasmirnov.innercore.api.commontypes.Coords;
import com.zhekasmirnov.innercore.api.commontypes.ItemInstance;

interface ITileEntity {

    public void onTick();
    public void onClick(ItemInstance item, Coords coords, int player);
    public void onLoad();
    public void onClientLoad();
    public void onUnload();
    public void onDestroy(Coords coords, int player);

}

