package hu.modeldriven.core.groovy;

public interface ScriptExecutor {

    Object execute(String script, String argumentKey, Object argument) throws ScriptExecutionException;

}
