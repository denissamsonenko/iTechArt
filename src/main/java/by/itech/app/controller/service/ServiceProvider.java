package by.itech.app.controller.service;

import by.itech.app.controller.service.impl.MainServiceImpl;

public class ServiceProvider {
    private static ServiceProvider instance;

    private static final MainService mainService = new MainServiceImpl();

    private ServiceProvider() {
    }

    public MainService getMainService() {
        return mainService;
    }

    public static ServiceProvider getInstance(){
        if (instance == null) {
            instance = new ServiceProvider();
        }
        return instance;
    }

}
