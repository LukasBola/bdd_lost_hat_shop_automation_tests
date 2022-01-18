package shop.context;

public class TestContext {
   public ScenarioContext scenarioContext;

    public TestContext(ScenarioContext scenarioContext) {
        this.scenarioContext = new ScenarioContext();
    }

    public ScenarioContext getScenarioContext(){
        return scenarioContext;
    }
}
