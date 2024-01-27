package hu.modeldriven.core.groovy;

import java.util.Map;

public interface ScriptExecutor {

    Object execute(String script, Map<String, Object> arguments) throws ScriptExecutionException;

}
