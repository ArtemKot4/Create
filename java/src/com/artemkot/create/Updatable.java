package com.artemkot.create;

import com.zhekasmirnov.innercore.api.mod.ScriptableObjectHelper;
import com.zhekasmirnov.innercore.api.mod.util.ScriptableFunctionImpl;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class Updatable {
    public interface ITick {
        void main();
    }
    public static void addServer(ITick tick) {
        ScriptableObject object = ScriptableObjectHelper.createEmpty();
        object.put("remove", object, false);
        object.put("update", object, new ScriptableFunctionImpl() {
            @Override
            public Object call(Context context, Scriptable scriptable, Scriptable scriptable1, Object[] objects) {
                tick.main();
                return null;
            }
        });
        com.zhekasmirnov.innercore.api.runtime.Updatable.getForServer().addUpdatable(object);
    };

    public static void addLocal(ITick tick) {
        ScriptableObject object = ScriptableObjectHelper.createEmpty();
        object.put("remove", object, false);
        object.put("update", object, new ScriptableFunctionImpl() {
            @Override
            public Object call(Context context, Scriptable scriptable, Scriptable scriptable1, Object[] objects) {
                tick.main();
                return null;
            }
        });
        com.zhekasmirnov.innercore.api.runtime.Updatable.getForClient().addUpdatable(object);
    }
}
