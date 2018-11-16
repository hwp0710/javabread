// https://www.cnblogs.com/peter1018/p/9156393.html#_title9
//https://www.cnblogs.com/peter1018/p/9183959.html

import java.lang.management.*;
import java.util.List;

public class TestManagementFactory {
    public static void main(String[] args) {
        //Java虚拟机的内存系统
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        System.out.println("虚拟机的堆内存使用量: " + memoryMXBean.getHeapMemoryUsage());
        System.out.println("虚拟机的非堆内存使用量: " + memoryMXBean.getNonHeapMemoryUsage());
        //Java虚拟机的类加载系统
        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        System.out.println("当前加载到Java虚拟机中的类的数量: " + classLoadingMXBean.getLoadedClassCount());
        System.out.println("自Java虚拟机开始执行到目前已经加载的类的总数: " + classLoadingMXBean.getTotalLoadedClassCount());
        //Java虚拟机的线程系统
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        System.out.println("当前线程的总CPU时间: " + threadMXBean.getCurrentThreadCpuTime());
        System.out.println("当前活动线程的数目，包括守护线程和非守护线程: " + threadMXBean.getThreadCount());
        //Java虚拟机的线程系统
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println("当前Java库路径: " + runtimeMXBean.getLibraryPath());
        System.out.println("当前Java虚拟机实现提供商: " + runtimeMXBean.getVmVendor());
        //操作系统
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println("当前Java虚拟机可以使用的处理器数目: " + operatingSystemMXBean.getAvailableProcessors());
        System.out.println("当前操作系统名称: " + operatingSystemMXBean.getName());
        //Java虚拟机的编译系统
        CompilationMXBean compilationMXBean = ManagementFactory.getCompilationMXBean();
        System.out.println("当前(JIT)编译器的名称: " + compilationMXBean.getName());
        System.out.println("当前即时(JIT)编译器的名称: " + compilationMXBean.getTotalCompilationTime());
        //Java虚拟机的垃圾回收系统
        List<GarbageCollectorMXBean> garbageCollectorMXBeanList = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean garbageCollectorMXBean : garbageCollectorMXBeanList) {
            System.out.println("当前垃圾收集器的名字: " + garbageCollectorMXBean.getName());
            System.out.println("当前垃圾收集器累计回收总次数: " + garbageCollectorMXBean.getCollectionCount());
            System.out.println("当前垃圾收集器累计回收总时间: " + garbageCollectorMXBean.getCollectionTime());
        }
    }
}