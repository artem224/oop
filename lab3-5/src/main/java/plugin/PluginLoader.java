package plugin;

import java.lang.reflect.InvocationTargetException;

public class PluginLoader {

    public IPlugin loadPlugin(String className) {
        String path = "plugin";
        IPlugin plugin = null;
        try {
            Class<?> cls = Class.forName(path + "." + className);
            plugin = (IPlugin) cls.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                NoSuchMethodException | InvocationTargetException e) {
            Throwable actualException = e.getCause();
            actualException.printStackTrace();
        }
        return plugin;
    }
}
