package shop.context;

import shop.managers.PageObjectManager;

public class TestContext {
   private ScenarioContext scenarioContext;
   private PageObjectManager pageObjectManager;

    public TestContext() {
        this.scenarioContext = new ScenarioContext();
        this.pageObjectManager = new PageObjectManager();
    }

    public ScenarioContext getScenarioContext(){
        return scenarioContext;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
