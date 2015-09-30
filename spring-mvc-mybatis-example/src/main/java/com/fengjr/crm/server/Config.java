package com.fengjr.crm.server;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by bingquan.an@fengjr.com on 2015/4/23.
 */
public class Config {

    private static Properties props = new Properties();

    static {
        InputStream ins = Thread.currentThread().getContextClassLoader().getResourceAsStream("jetty.properties");
        if (ins != null) {
            try {
                props.load(ins);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    ins.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String server_name = props.getProperty("server_name");
    public static String deploy_root_home = props.getProperty("deploy_root_home");

    public static String ip = "127.0.0.1";
    public static int port = 18080;
    public static int min_thread = 128;
    public static int max_thread = 512;
    public static long idle_timeout = 60000L;
    public static int accecp_queuesize = 6000;
    public static long stop_timeout = 60000L;
    public static String server_log_home = deploy_root_home + "/" + server_name + "/" + "logs/";
    public static String temp_work_path = deploy_root_home + "/" + server_name + "/" + "work/";
    public static String access_log_path = server_log_home + "/access_" + port + ".log";

}
