package com.artemkot.create.tile;

import com.zhekasmirnov.apparatus.api.common.Vector3;
import com.zhekasmirnov.innercore.api.commontypes.ItemInstance;
import com.zhekasmirnov.innercore.api.mod.adaptedscript.AdaptedScriptAPI;

import java.util.HashMap;
import java.util.Map;

public class TileEntity implements ITileEntity {
    public static Map<Vector3, ITileEntity> prototypes = new HashMap();

    public final int x;
    public final short y;
    public final int z;

    public HashMap data = new HashMap();
    public boolean isLoaded = true;

    TileEntity (Vector3 coords) {
        this.x = (int)coords.x;
        this.y = (short)coords.y;
        this.z = (int)coords.z;
        this.prototypes.put(coords, this);

    // AdaptedScriptAPI.Updatable.addLocalUpdatable();
    }

    public void onTick() {

    }

    public void onClick(ItemInstance item, Vector3 coords, int player) {

    }

    public void onLoad() {

    }

    public void onClientLoad() {

    }

    public void onUnload() {

    }

    public void onDestroy(Vector3 coords, int player) {

    }
}
