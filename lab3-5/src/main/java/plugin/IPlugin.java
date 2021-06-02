package plugin;

public interface IPlugin {
    void action(String extension);

    static String srcName(String extension) {
        return "output." + extension;
    }
}
