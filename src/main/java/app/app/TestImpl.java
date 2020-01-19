package app.app;

import app.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TestImpl implements Test {
//    private static final char PKG_SEPARATOR = '.';
//
//    private static final char DIR_SEPARATOR = '/';
//
//    private static final String CLASS_FILE_SUFFIX = ".class";
//
//    private static final String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the package '%s' exists?";
//
//    /**
//     * @param scannedPackage
//     * @return
//     */
//    public List<Class<?>> find(String scannedPackage) {
//        String scannedPath = scannedPackage.replace(PKG_SEPARATOR, DIR_SEPARATOR);
//        URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
//        if (scannedUrl == null) {
//            throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage));
//        }
//        File scannedDir = new File(scannedUrl.getFile());
//        List<Class<?>> classes = new ArrayList<>();
//        for (File file : scannedDir.listFiles()) {
//            classes.addAll(find(file, scannedPackage));
//        }
//        return classes;
//    }
//
//    private List<Class<?>> find(File file, String scannedPackage) {
//        List<Class<?>> classes = new ArrayList<>();
//        String resource = scannedPackage + PKG_SEPARATOR + file.getName();
//        if (file.isDirectory()) {
//            for (File child : file.listFiles()) {
//                classes.addAll(find(child, resource));
//            }
//        } else if (resource.endsWith(CLASS_FILE_SUFFIX)) {
//            int endIndex = resource.length() - CLASS_FILE_SUFFIX.length();
//            String className = resource.substring(0, endIndex);
//            try {
//                classes.add(Class.forName(className));
//            } catch (ClassNotFoundException ignore) {
//            }
//        }
//        return classes;
//    }
        public String getText() {
        try {
            ClassLoader cl = this.getClass().getClassLoader();
            String pack = "classes";
            String dottedPackage = pack.replaceAll("[/]", ".");
            List<Class> classes = new ArrayList<Class>();
            URL upackage = cl.getResource(pack);
            System.out.println("upackage " + upackage);

            BufferedReader dis
                    = new BufferedReader(new InputStreamReader((InputStream) upackage.getContent()));
            String line = null;
            while ((line = dis.readLine()) != null) {
                if (line.endsWith(".class")) {
                    classes.add(Class.forName(dottedPackage + "." + line.substring(0, line.lastIndexOf('.'))));
                }
            }
            return classes.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
