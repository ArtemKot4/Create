package com.artemkot.create.tile;

import com.zhekasmirnov.apparatus.api.common.Vector3;
import com.zhekasmirnov.innercore.api.commontypes.ItemInstance;

interface ITileEntity {

    public void onTick();
    public void onClick(ItemInstance item, Vector3 coords, int player);
    public void onLoad();
    public void onClientLoad();
    public void onUnload();
    public void onDestroy(Vector3 coords, int player);

}

