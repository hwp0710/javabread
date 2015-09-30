package com.fengjr.crm.server;

/**
 * Created by bingquan.an@fengjr.com on 2015/4/23.
 * start jetty
 */
public class StartupAvocadoWeb extends AbstractServer {

    public StartupAvocadoWeb(String[] anArgs) {
        super(anArgs);
    }

    public static void main(String... anArgs) throws Exception {
    	try {
    		new StartupAvocadoWeb(anArgs).run();
		} catch (Exception e) {
		}
    }

    @Override
    public void init(Config config) {

//        config.setMin_thread(128);
//        config.setMax_thread(512);
        // URL url = super.getResource(Config.DEFAULT_TEMPLATE_FOLDER);

        // SmcVelocityEngine.setDefaultTemplateFolder(url.toString());
    }

}
