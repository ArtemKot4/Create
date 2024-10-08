package com.artemkot.create.tile;

import com.artemkot.create.Updatable;
import com.zhekasmirnov.apparatus.api.player.NetworkPlayerHandler;
import com.zhekasmirnov.apparatus.api.player.NetworkPlayerRegistry;
import com.zhekasmirnov.apparatus.mcpe.NativeBlockSource;
import com.zhekasmirnov.apparatus.multiplayer.Network;
import com.zhekasmirnov.apparatus.multiplayer.server.ConnectedClient;
import com.zhekasmirnov.innercore.api.commontypes.Coords;
import com.zhekasmirnov.innercore.api.commontypes.ItemInstance;
import com.zhekasmirnov.innercore.api.mod.ScriptableObjectHelper;
import com.zhekasmirnov.innercore.api.mod.adaptedscript.AdaptedScriptAPI;
import com.zhekasmirnov.innercore.api.mod.util.ScriptableFunctionImpl;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import java.util.HashMap;
import java.util.Map;


public class TileEntity implements ITileEntity {
    public static Map<Coords, ITileEntity> prototypes = new HashMap();

    public final int x;
    public final short y;
    public final int z;
    public int dimension = 0;
    public final int blockID;
    public HashMap data = new HashMap();
    public boolean isLoaded = true;

    TileEntity (Coords coords, int dimension) {

        this.x = ScriptableObjectHelper.getIntProperty(coords, "x", -1);
        this.y = (short)ScriptableObjectHelper.getIntProperty(coords, "y", -1);
        this.z = ScriptableObjectHelper.getIntProperty(coords, "z", -1);

        this.prototypes.put(coords, this);
        this.dimension = dimension;

        NativeBlockSource source = NativeBlockSource.getDefaultForDimension(dimension);

        this.blockID = source.getBlockID(x, y, z);

        Updatable.addLocal(() -> {
            if (NativeBlockSource.getDefaultForDimension(dimension).getBlockID(x, y, z) == blockID) {
                onClientTick();
            };

            if (AdaptedScriptAPI.Updatable.getSyncTime() % 60 == 0) {
                if(!isLoaded) {
                   // this.remove = true;
                }

            }
        });

        Updatable.addServer(() -> {
            if (NativeBlockSource.getDefaultForDimension(dimension).getBlockID(x, y, z) == blockID) {
                onTick();
            };

            if (AdaptedScriptAPI.Updatable.getSyncTime() % 60 == 0) {
                if(!isLoaded) {
                    // this.remove = true;
                }

            }
        });
    };

    public void onClientTick() {

    }
    public void onTick() {

    }

    public void onClick(ItemInstance item, Coords coords, int player) {

    }

    public void onLoad() {

    }

    public void onClientLoad() {

    }

    public void onUnload() {

    }

    public void onClientUnload() {

    }
    public void onDestroy(Coords coords, int player) {

    }
}
