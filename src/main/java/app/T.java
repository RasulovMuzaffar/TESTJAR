package app;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;

public class T {
    public void getCs() {
        try (ScanResult scanResult = new ClassGraph()
                .whitelistPackages("classes")
                .scan()) {
            for (ClassInfo classInfo : scanResult.getAllClasses()) {
                System.out.println(classInfo.getName());
            }
        }
    }
}
