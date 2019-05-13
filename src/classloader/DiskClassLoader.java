package classloader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DiskClassLoader extends ClassLoader{

    private byte[] bytes;
    public DiskClassLoader(ClassLoader parent, byte[] bytes) {
        super(parent);
        this.bytes = bytes;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return defineClass("Jobs", bytes, 0, bytes.length);
    }

    public static void main(String[] args) {
        String extClassFile = "/Users/aliouswang/Desktop/Jobs.class";
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(extClassFile)));
            byte[] result = null;
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                if (result == null) {
                    result = new byte[len];
                    System.arraycopy(bytes, 0, result, 0, len);
                } else {
                    byte[] newResult = new byte[result.length + len];
                    System.arraycopy(result, 0, newResult, 0, result.length);
                    System.arraycopy(bytes, 0, newResult, result.length, len);
                }
            }
            if (result != null) {
                DiskClassLoader diskClassLoader = new DiskClassLoader(ClassLoader.getSystemClassLoader(), result);
                Class clazz = Class.forName("Jobs", true, diskClassLoader);
                if (clazz != null) {
                    Method method = clazz.getDeclaredMethod("say");
                    method.setAccessible(true);
                    Object object = clazz.newInstance();
                    method.invoke(object);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
