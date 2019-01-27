package ArithmaticalOperation;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class LevelFactory {
    private int levelIndex;
    private ArrayList<Character> level;

    public Level createLevel(int index) throws IllegalAccessException, InstantiationException {
        String classPath = "Level" + index;
        Class<Level> classObject = null;
        try {
            classObject = (Class<Level>)Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Level level = (Level) classObject.newInstance();
        return level;
    }

}
