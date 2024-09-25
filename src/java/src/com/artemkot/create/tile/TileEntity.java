package com.artemkot.create.tile;

import com.zhekasmirnov.innercore.api.commontypes.Coords;
import com.zhekasmirnov.innercore.api.commontypes.ItemInstance;
import com.zhekasmirnov.innercore.api.mod.ScriptableObjectHelper;
import com.zhekasmirnov.innercore.api.mod.util.ScriptableFunctionImpl;
import com.zhekasmirnov.innercore.api.runtime.Updatable;
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

    public HashMap data = new HashMap();
    public boolean isLoaded = true;

    TileEntity (Coords coords) {
        this.x = ScriptableObjectHelper.getIntProperty(coords, "x", -1);
        this.y = (short)ScriptableObjectHelper.getIntProperty(coords, "y", -1);
        this.z = ScriptableObjectHelper.getIntProperty(coords, "z", -1);
        this.prototypes.put(coords, this);

        ScriptableObject localScriptable = ScriptableObjectHelper.createEmpty();
        ScriptableObject globalScriptable = ScriptableObjectHelper.createEmpty();
        localScriptable.put("update", new ScriptableFunctionImpl() {
            @Override
            public Object call(Context context, Scriptable scriptable, Scriptable scriptable1, Object[] objects) {
                 onClientTick();
                 return null;
            };
        }, //
        );
        Updatable.getForClient().addUpdatable(localScriptable);
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
